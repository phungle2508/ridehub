package com.ridehub.booking.web.rest.admin;

import com.ridehub.booking.service.BookingScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

/**
 * REST controller for admin scheduler operations.
 */
@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminSchedulerController {

    private final Logger log = LoggerFactory.getLogger(AdminSchedulerController.class);

    private final BookingScheduler bookingScheduler;

    public AdminSchedulerController(BookingScheduler bookingScheduler) {
        this.bookingScheduler = bookingScheduler;
    }

    /**
     * {@code POST  /api/admin/cleanup} : manually trigger expired bookings cleanup.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and cleanup report in body.
     */
    @PostMapping("/cleanup")
    public ResponseEntity<CleanupReport> triggerCleanup() {
        log.debug("REST request to manually trigger expired bookings cleanup");

        Instant startTime = Instant.now();
        
        // Get count before cleanup
        long expiredCountBefore = bookingScheduler.getExpiredBookingsCount();
        
        // Trigger the cleanup
        bookingScheduler.triggerExpiredBookingsCleanup();
        
        // Get count after cleanup
        long expiredCountAfter = bookingScheduler.getExpiredBookingsCount();
        
        Instant endTime = Instant.now();
        long processingTimeMs = endTime.toEpochMilli() - startTime.toEpochMilli();
        
        CleanupReport report = new CleanupReport(
            expiredCountBefore,
            expiredCountBefore - expiredCountAfter,
            expiredCountAfter,
            processingTimeMs,
            startTime,
            endTime
        );

        log.info("Manual cleanup completed. Processed {} expired bookings in {}ms", 
            report.getCanceledCount(), processingTimeMs);

        return ResponseEntity.ok().body(report);
    }

    /**
     * {@code GET  /api/admin/cleanup/status} : get current status of expired bookings.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and status information in body.
     */
    @GetMapping("/cleanup/status")
    public ResponseEntity<CleanupStatus> getCleanupStatus() {
        log.debug("REST request to get cleanup status");

        long expiredCount = bookingScheduler.getExpiredBookingsCount();
        
        CleanupStatus status = new CleanupStatus(
            expiredCount,
            expiredCount > 0,
            Instant.now()
        );

        return ResponseEntity.ok().body(status);
    }

    /**
     * Response class for cleanup operations.
     */
    public static class CleanupReport {
        private long totalExpiredFound;
        private long canceledCount;
        private long remainingExpired;
        private long processingTimeMs;
        private Instant startTime;
        private Instant endTime;

        public CleanupReport(long totalExpiredFound, long canceledCount, long remainingExpired, 
                           long processingTimeMs, Instant startTime, Instant endTime) {
            this.totalExpiredFound = totalExpiredFound;
            this.canceledCount = canceledCount;
            this.remainingExpired = remainingExpired;
            this.processingTimeMs = processingTimeMs;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public long getTotalExpiredFound() {
            return totalExpiredFound;
        }

        public void setTotalExpiredFound(long totalExpiredFound) {
            this.totalExpiredFound = totalExpiredFound;
        }

        public long getCanceledCount() {
            return canceledCount;
        }

        public void setCanceledCount(long canceledCount) {
            this.canceledCount = canceledCount;
        }

        public long getRemainingExpired() {
            return remainingExpired;
        }

        public void setRemainingExpired(long remainingExpired) {
            this.remainingExpired = remainingExpired;
        }

        public long getProcessingTimeMs() {
            return processingTimeMs;
        }

        public void setProcessingTimeMs(long processingTimeMs) {
            this.processingTimeMs = processingTimeMs;
        }

        public Instant getStartTime() {
            return startTime;
        }

        public void setStartTime(Instant startTime) {
            this.startTime = startTime;
        }

        public Instant getEndTime() {
            return endTime;
        }

        public void setEndTime(Instant endTime) {
            this.endTime = endTime;
        }
    }

    /**
     * Status class for cleanup status checks.
     */
    public static class CleanupStatus {
        private long expiredBookingsCount;
        private boolean cleanupNeeded;
        private Instant checkedAt;

        public CleanupStatus(long expiredBookingsCount, boolean cleanupNeeded, Instant checkedAt) {
            this.expiredBookingsCount = expiredBookingsCount;
            this.cleanupNeeded = cleanupNeeded;
            this.checkedAt = checkedAt;
        }

        public long getExpiredBookingsCount() {
            return expiredBookingsCount;
        }

        public void setExpiredBookingsCount(long expiredBookingsCount) {
            this.expiredBookingsCount = expiredBookingsCount;
        }

        public boolean isCleanupNeeded() {
            return cleanupNeeded;
        }

        public void setCleanupNeeded(boolean cleanupNeeded) {
            this.cleanupNeeded = cleanupNeeded;
        }

        public Instant getCheckedAt() {
            return checkedAt;
        }

        public void setCheckedAt(Instant checkedAt) {
            this.checkedAt = checkedAt;
        }
    }
}
