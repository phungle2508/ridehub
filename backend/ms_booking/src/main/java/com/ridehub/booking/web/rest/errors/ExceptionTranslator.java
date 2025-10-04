package com.ridehub.booking.web.rest.errors;

import static org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation;

import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.lang.Nullable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.jhipster.config.JHipsterConstants;
import tech.jhipster.web.rest.errors.ProblemDetailWithCause;
import tech.jhipster.web.rest.errors.ProblemDetailWithCause.ProblemDetailWithCauseBuilder;
import tech.jhipster.web.util.HeaderUtil;

/**
 * Controller advice to translate the server side exceptions to client-friendly
 * json structures.
 * The error response follows RFC7807 - Problem Details for HTTP APIs
 * (https://tools.ietf.org/html/rfc7807).
 */
@ControllerAdvice
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

    private static final String FIELD_ERRORS_KEY = "fieldErrors";
    private static final String MESSAGE_KEY = "message";
    private static final String PATH_KEY = "path";
    private static final boolean CASUAL_CHAIN_ENABLED = false;

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionTranslator.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final Environment env;

    public ExceptionTranslator(Environment env) {
        this.env = env;
    }

    @ExceptionHandler(Exception.class)
    @Order(Ordered.LOWEST_PRECEDENCE)
    public ResponseEntity<Object> handleAnyException(Exception ex, NativeWebRequest request) {
        LOG.error("Exception caught in handleAnyException: {} - {}", ex.getClass().getName(), ex.getMessage());

        // Log the full exception chain for debugging
        logExceptionChain(ex);

        // Check if this is a Feign-related exception and delegate to specific handlers
        FeignException feignException = extractFeignException(ex);
        if (feignException != null) {
            LOG.error("Found FeignException in exception chain: {} - {}", feignException.getClass().getName(),
                    feignException.getMessage());
            return handleFeignException(feignException, request);
        }

        // Check if this is an UndeclaredThrowableException
        if (ex instanceof UndeclaredThrowableException undeclaredEx) {
            LOG.error("Found UndeclaredThrowableException, delegating to handleUndeclaredThrowableException");
            return handleUndeclaredThrowableException(undeclaredEx, request);
        }

        LOG.error("No specific handler found, using default exception handling for: {}", ex.getClass().getName());
        ProblemDetailWithCause pdCause = wrapAndCustomizeProblem(ex, request);
        return handleExceptionInternal(ex, pdCause, buildHeaders(ex), HttpStatusCode.valueOf(pdCause.getStatus()),
                request);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, NativeWebRequest request) {
        LOG.error("ResponseStatusException occurred: {} - {}", ex.getStatusCode(), ex.getReason(), ex);

        ProblemDetailWithCause problemDetail = ProblemDetailWithCauseBuilder.instance()
                .withStatus(ex.getStatusCode().value())
                .withTitle("Service Error")
                .withDetail(ex.getReason() != null ? ex.getReason() : "An error occurred while processing the request")
                .build();

        problemDetail.setProperty(MESSAGE_KEY, "error.service");
        problemDetail.setProperty(PATH_KEY, getPathValue(request));

        return handleExceptionInternal(ex, problemDetail, null, ex.getStatusCode(), request);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Object> handleFeignException(FeignException ex, NativeWebRequest request) {
        LOG.error("Feign client error occurred: {}", ex.getMessage(), ex);

        // Extract the HTTP status from the Feign exception
        HttpStatus status = HttpStatus.valueOf(ex.status());

        ProblemDetailWithCause problemDetail = ProblemDetailWithCauseBuilder.instance()
                .withStatus(status.value())
                .withTitle("External Service Error")
                .withDetail("Error communicating with external service: " + extractFeignErrorMessage(ex))
                .build();

        problemDetail.setProperty(MESSAGE_KEY, "error.external.service");
        problemDetail.setProperty(PATH_KEY, getPathValue(request));

        return handleExceptionInternal(ex, problemDetail, null, status, request);
    }

    @ExceptionHandler(UndeclaredThrowableException.class)
    public ResponseEntity<Object> handleUndeclaredThrowableException(UndeclaredThrowableException ex,
            NativeWebRequest request) {
        LOG.error("UndeclaredThrowableException occurred: {}", ex.getMessage(), ex);

        // Check if the underlying cause is a FeignException
        Throwable undeclared = ex.getUndeclaredThrowable();
        FeignException feign = extractFeignException(undeclared);
        if (feign != null) {
            return handleFeignException(feign, request);
        }

        // For other undeclared throwable exceptions, treat as internal server error
        ProblemDetailWithCause problemDetail = ProblemDetailWithCauseBuilder.instance()
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withTitle("Internal Server Error")
                .withDetail("An unexpected error occurred while processing the request")
                .build();

        problemDetail.setProperty(MESSAGE_KEY, "error.http.500");
        problemDetail.setProperty(PATH_KEY, getPathValue(request));

        return handleExceptionInternal(ex, problemDetail, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Nullable
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex,
            @Nullable Object body,
            HttpHeaders headers,
            HttpStatusCode statusCode,
            WebRequest request) {
        body = body == null ? wrapAndCustomizeProblem((Throwable) ex, (NativeWebRequest) request) : body;
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    protected ProblemDetailWithCause wrapAndCustomizeProblem(Throwable ex, NativeWebRequest request) {
        return customizeProblem(getProblemDetailWithCause(ex), ex, request);
    }

    private ProblemDetailWithCause getProblemDetailWithCause(Throwable ex) {
        if (ex instanceof ErrorResponseException exp
                && exp.getBody() instanceof ProblemDetailWithCause problemDetailWithCause)
            return problemDetailWithCause;
        return ProblemDetailWithCauseBuilder.instance().withStatus(toStatus(ex).value()).build();
    }

    protected ProblemDetailWithCause customizeProblem(ProblemDetailWithCause problem, Throwable err,
            NativeWebRequest request) {
        if (problem.getStatus() <= 0)
            problem.setStatus(toStatus(err));

        if (problem.getType() == null || problem.getType().equals(URI.create("about:blank")))
            problem.setType(getMappedType(err));

        // higher precedence to Custom/ResponseStatus types
        String title = extractTitle(err, problem.getStatus());
        String problemTitle = problem.getTitle();
        if (problemTitle == null || !problemTitle.equals(title)) {
            problem.setTitle(title);
        }

        if (problem.getDetail() == null) {
            // higher precedence to cause
            problem.setDetail(getCustomizedErrorDetails(err));
        }

        Map<String, Object> problemProperties = problem.getProperties();
        if (problemProperties == null || !problemProperties.containsKey(MESSAGE_KEY))
            problem.setProperty(
                    MESSAGE_KEY,
                    getMappedMessageKey(err) != null ? getMappedMessageKey(err) : "error.http." + problem.getStatus());

        if (problemProperties == null || !problemProperties.containsKey(PATH_KEY))
            problem.setProperty(PATH_KEY, getPathValue(request));

        if ((err instanceof MethodArgumentNotValidException fieldException) &&
                (problemProperties == null || !problemProperties.containsKey(FIELD_ERRORS_KEY)))
            problem.setProperty(FIELD_ERRORS_KEY, getFieldErrors(fieldException));

        problem.setCause(buildCause(err.getCause(), request).orElse(null));

        return problem;
    }

    private String extractTitle(Throwable err, int statusCode) {
        return getCustomizedTitle(err) != null ? getCustomizedTitle(err)
                : extractTitleForResponseStatus(err, statusCode);
    }

    private List<FieldErrorVM> getFieldErrors(MethodArgumentNotValidException ex) {
        return ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(f -> new FieldErrorVM(
                        f.getObjectName().replaceFirst("DTO$", ""),
                        f.getField(),
                        StringUtils.isNotBlank(f.getDefaultMessage()) ? f.getDefaultMessage() : f.getCode()))
                .toList();
    }

    private String extractTitleForResponseStatus(Throwable err, int statusCode) {
        ResponseStatus specialStatus = extractResponseStatus(err);
        return specialStatus == null ? HttpStatus.valueOf(statusCode).getReasonPhrase() : specialStatus.reason();
    }

    private String extractURI(NativeWebRequest request) {
        HttpServletRequest nativeRequest = request.getNativeRequest(HttpServletRequest.class);
        return nativeRequest != null ? nativeRequest.getRequestURI() : StringUtils.EMPTY;
    }

    private HttpStatus toStatus(final Throwable throwable) {
        // Let the ErrorResponse take this responsibility
        if (throwable instanceof ErrorResponse err)
            return HttpStatus.valueOf(err.getBody().getStatus());

        return Optional.ofNullable(getMappedStatus(throwable)).orElse(
                Optional.ofNullable(resolveResponseStatus(throwable)).map(ResponseStatus::value)
                        .orElse(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private ResponseStatus extractResponseStatus(final Throwable throwable) {
        return Optional.ofNullable(resolveResponseStatus(throwable)).orElse(null);
    }

    private ResponseStatus resolveResponseStatus(final Throwable type) {
        final ResponseStatus candidate = findMergedAnnotation(type.getClass(), ResponseStatus.class);
        return candidate == null && type.getCause() != null ? resolveResponseStatus(type.getCause()) : candidate;
    }

    private URI getMappedType(Throwable err) {
        if (err instanceof MethodArgumentNotValidException)
            return ErrorConstants.CONSTRAINT_VIOLATION_TYPE;
        return ErrorConstants.DEFAULT_TYPE;
    }

    private String getMappedMessageKey(Throwable err) {
        if (err instanceof MethodArgumentNotValidException) {
            return ErrorConstants.ERR_VALIDATION;
        } else if (err instanceof ConcurrencyFailureException
                || err.getCause() instanceof ConcurrencyFailureException) {
            return ErrorConstants.ERR_CONCURRENCY_FAILURE;
        } else if (err instanceof FeignException) {
            return "error.external.service";
        } else if (err instanceof UndeclaredThrowableException undeclaredEx) {
            if (undeclaredEx.getUndeclaredThrowable() instanceof FeignException) {
                return "error.external.service";
            }
        }
        return null;
    }

    private String getCustomizedTitle(Throwable err) {
        if (err instanceof MethodArgumentNotValidException)
            return "Method argument not valid";
        if (err instanceof FeignException)
            return "External Service Error";
        if (err instanceof UndeclaredThrowableException undeclaredEx) {
            if (undeclaredEx.getUndeclaredThrowable() instanceof FeignException) {
                return "External Service Error";
            }
        }
        return null;
    }

    private String getCustomizedErrorDetails(Throwable err) {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());

        // Handle Feign exceptions specifically
        if (err instanceof FeignException feignEx) {
            return extractFeignErrorMessage(feignEx);
        }

        if (err instanceof UndeclaredThrowableException undeclaredEx) {
            if (undeclaredEx.getUndeclaredThrowable() instanceof FeignException feignEx) {
                return extractFeignErrorMessage(feignEx);
            }
        }

        if (activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_PRODUCTION)) {
            if (err instanceof HttpMessageConversionException)
                return "Unable to convert http message";
            if (err instanceof DataAccessException)
                return "Failure during data access";
            if (containsPackageName(err.getMessage()))
                return "Unexpected runtime exception";
        }
        return err.getCause() != null ? err.getCause().getMessage() : err.getMessage();
    }

    private HttpStatus getMappedStatus(Throwable err) {
        // Where we disagree with Spring defaults
        if (err instanceof AccessDeniedException)
            return HttpStatus.FORBIDDEN;
        if (err instanceof ConcurrencyFailureException)
            return HttpStatus.CONFLICT;
        if (err instanceof BadCredentialsException)
            return HttpStatus.UNAUTHORIZED;

        // Handle Feign exceptions
        if (err instanceof FeignException feignEx) {
            return HttpStatus.valueOf(feignEx.status());
        }

        // Handle UndeclaredThrowableException that wraps FeignException
        if (err instanceof UndeclaredThrowableException undeclaredEx) {
            Throwable cause = undeclaredEx.getUndeclaredThrowable();
            if (cause instanceof FeignException feignEx) {
                return HttpStatus.valueOf(feignEx.status());
            }
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return null;
    }

    private URI getPathValue(NativeWebRequest request) {
        if (request == null)
            return URI.create("about:blank");
        return URI.create(extractURI(request));
    }

    private HttpHeaders buildHeaders(Throwable err) {
        return err instanceof BadRequestAlertException badRequestAlertException
                ? HeaderUtil.createFailureAlert(
                        applicationName,
                        true,
                        badRequestAlertException.getEntityName(),
                        badRequestAlertException.getErrorKey(),
                        badRequestAlertException.getMessage())
                : null;
    }

    public Optional<ProblemDetailWithCause> buildCause(final Throwable throwable, NativeWebRequest request) {
        if (throwable != null && isCasualChainEnabled()) {
            return Optional.of(customizeProblem(getProblemDetailWithCause(throwable), throwable, request));
        }
        return Optional.ofNullable(null);
    }

    private boolean isCasualChainEnabled() {
        // Customize as per the needs
        return CASUAL_CHAIN_ENABLED;
    }

    private boolean containsPackageName(String message) {
        // This list is for sure not complete
        return StringUtils.containsAny(message, "org.", "java.", "net.", "jakarta.", "javax.", "com.", "io.", "de.",
                "com.ridehub.booking");
    }

    private FeignException extractFeignException(Throwable throwable) {
        if (throwable == null) {
            return null;
        }

        // Direct FeignException
        if (throwable instanceof java.lang.reflect.InvocationTargetException inv) {
            FeignException nested = extractFeignException(inv.getTargetException());
            if (nested != null)
                return nested;
            // also try standard cause chain just in case
        }

        // Check UndeclaredThrowableException
        if (throwable instanceof UndeclaredThrowableException undeclaredEx) {
            Throwable undeclaredThrowable = undeclaredEx.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof FeignException) {
                return (FeignException) undeclaredThrowable;
            }
            // Recursively check the undeclared throwable's cause chain
            FeignException nested = extractFeignException(undeclaredThrowable);
            if (nested != null) {
                return nested;
            }
        }

        // Traverse the cause chain to find FeignException
        Throwable cause = throwable.getCause();
        int depth = 0;
        while (cause != null && cause != throwable && depth < 10) { // Prevent infinite loops
            if (cause instanceof FeignException) {
                return (FeignException) cause;
            }
            if (cause instanceof java.lang.reflect.InvocationTargetException inv) {
                FeignException nested = extractFeignException(inv.getTargetException());
                if (nested != null)
                    return nested;
            }
            if (cause instanceof UndeclaredThrowableException undeclaredEx) {
                Throwable undeclaredThrowable = undeclaredEx.getUndeclaredThrowable();
                if (undeclaredThrowable instanceof FeignException) {
                    return (FeignException) undeclaredThrowable;
                }
                // Recursively check the undeclared throwable's cause chain
                FeignException nested = extractFeignException(undeclaredThrowable);
                if (nested != null) {
                    return nested;
                }
            }
            cause = cause.getCause();
            depth++;
        }

        return null;
    }

    private void logExceptionChain(Throwable throwable) {
        LOG.error("=== Exception Chain Debug ===");
        Throwable current = throwable;
        int level = 0;
        while (current != null && level < 10) {
            LOG.error("Level {}: {} - {}", level, current.getClass().getName(), current.getMessage());

            if (current instanceof UndeclaredThrowableException undeclaredEx) {
                Throwable undeclared = undeclaredEx.getUndeclaredThrowable();
                LOG.error("  -> UndeclaredThrowable: {} - {}",
                        undeclared != null ? undeclared.getClass().getName() : "null",
                        undeclared != null ? undeclared.getMessage() : "null");
            }

            current = current.getCause();
            level++;
        }
        LOG.error("=== End Exception Chain ===");
    }

    private String extractFeignErrorMessage(FeignException ex) {
        String message = ex.getMessage();
        if (StringUtils.isBlank(message)) {
            return "External service returned error code: " + ex.status();
        }

        // Try to extract meaningful error message from Feign exception
        // Feign exceptions often contain the full response body
        try {
            // If the message contains JSON error response, try to extract the detail
            if (message.contains("\"detail\":")) {
                int detailStart = message.indexOf("\"detail\":\"") + 10;
                int detailEnd = message.indexOf("\"", detailStart);
                if (detailStart > 9 && detailEnd > detailStart) {
                    return message.substring(detailStart, detailEnd);
                }
            }

            // If the message contains a title, extract it
            if (message.contains("\"title\":")) {
                int titleStart = message.indexOf("\"title\":\"") + 9;
                int titleEnd = message.indexOf("\"", titleStart);
                if (titleStart > 8 && titleEnd > titleStart) {
                    return message.substring(titleStart, titleEnd);
                }
            }

            // Extract the main error message after the HTTP method and URL
            if (message.contains("] during [")) {
                int messageStart = message.indexOf("] during [");
                int messageEnd = message.indexOf("]: [");
                if (messageStart > 0 && messageEnd > messageStart) {
                    String httpInfo = message.substring(messageStart + 10, messageEnd);
                    return "Failed to call external service: " + httpInfo;
                }
            }

        } catch (Exception e) {
            LOG.debug("Failed to extract detailed error message from Feign exception", e);
        }

        // Fallback to the original message but limit its length
        return message.length() > 200 ? message.substring(0, 200) + "..." : message;
    }
}
