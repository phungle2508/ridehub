package com.ridehub.booking.repository;

import com.ridehub.booking.domain.PaymentWebhookLog;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PaymentWebhookLog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentWebhookLogRepository extends JpaRepository<PaymentWebhookLog, Long>, JpaSpecificationExecutor<PaymentWebhookLog> {}
