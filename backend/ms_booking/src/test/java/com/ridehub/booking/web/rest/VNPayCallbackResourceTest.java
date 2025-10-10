package com.ridehub.booking.web.rest;

import com.ridehub.booking.service.PaymentService;
import com.ridehub.booking.service.payment.vnpay.VNPayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the VNPayCallbackResource REST controller.
 */
@WebMvcTest(VNPayCallbackResource.class)
class VNPayCallbackResourceTest {

    @Autowired
    private MockMvc restVNPayCallbackMockMvc;

    @MockBean
    private PaymentService paymentService;

    @MockBean
    private VNPayService vnPayService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @WithMockUser
    void testQueryTransactionSuccess() throws Exception {
        // Mock successful query response
        VNPayService.VNPayQueryResult queryResult = new VNPayService.VNPayQueryResult(
            true, "00", "Transaction successful", "00", new BigDecimal("100000")
        );
        
        when(vnPayService.queryTransaction(any(), any(), any(), any()))
            .thenReturn(queryResult);

        restVNPayCallbackMockMvc
            .perform(get("/api/payment/vnpay/query/123456")
                .param("transactionDate", "20251010120000")
                .param("orderRef", "BOOK123456"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.success").value(true))
            .andExpect(jsonPath("$.transactionId").value("123456"))
            .andExpect(jsonPath("$.orderRef").value("BOOK123456"))
            .andExpect(jsonPath("$.responseCode").value("00"))
            .andExpect(jsonPath("$.transactionStatus").value("00"))
            .andExpect(jsonPath("$.amount").value(100000))
            .andExpect(jsonPath("$.paymentMethod").value("VNPAY"))
            .andExpect(jsonPath("$.canSynthesizeWebhook").value(true))
            .andExpect(jsonPath("$.reconciliationData.gatewayStatus").value("00"))
            .andExpect(jsonPath("$.reconciliationData.amount").value(100000))
            .andExpect(jsonPath("$.reconciliationData.transactionId").value("123456"))
            .andExpect(jsonPath("$.reconciliationData.orderRef").value("BOOK123456"));
    }

    @Test
    @WithMockUser
    void testQueryTransactionFailure() throws Exception {
        // Mock failed query response
        VNPayService.VNPayQueryResult queryResult = new VNPayService.VNPayQueryResult(
            false, "01", "Transaction failed", "01", null
        );
        
        when(vnPayService.queryTransaction(any(), any(), any(), any()))
            .thenReturn(queryResult);

        restVNPayCallbackMockMvc
            .perform(get("/api/payment/vnpay/query/123456"))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.success").value(false))
            .andExpect(jsonPath("$.responseCode").value("01"))
            .andExpect(jsonPath("$.transactionStatus").value("01"))
            .andExpect(jsonPath("$.canSynthesizeWebhook").value(false));
    }

    @Test
    @WithMockUser
    void testQueryTransactionWithoutOrderRef() throws Exception {
        // Mock successful query response without orderRef
        VNPayService.VNPayQueryResult queryResult = new VNPayService.VNPayQueryResult(
            true, "00", "Transaction successful", "00", new BigDecimal("50000")
        );
        
        when(vnPayService.queryTransaction(any(), any(), any(), eq(null)))
            .thenReturn(queryResult);

        restVNPayCallbackMockMvc
            .perform(get("/api/payment/vnpay/query/789012"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.success").value(true))
            .andExpect(jsonPath("$.transactionId").value("789012"))
            .andExpect(jsonPath("$.orderRef").isEmpty())
            .andExpect(jsonPath("$.amount").value(50000))
            .andExpect(jsonPath("$.canSynthesizeWebhook").value(true));
    }
}
