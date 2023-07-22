package com.imovies.onboard.resource.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Accessors(chain = true)
@Table(name = "booking_cancellation")
public class BookingCancellation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "BOOKING_ID", nullable = false)
    private Integer bookingId;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "TOTAL_PRICE", nullable = false)
    private Double totalPrice;

    @Column(name = "CANCELLATION_CHARGES", nullable = false)
    private Double cancellationCharges;

    @Column(name = "REFUND_AMOUNT", nullable = false)
    private Double refundAmount;

    @Column(name = "REFUND_STATUS", nullable = false)
    private String refundStatus;

    @Column(name = "REFUND_TRANSACTION_ID")
    private String refundTransactionId;

    @Column(name = "CREATED_TS", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTs;

    @Column(name = "UPDATED_TS", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedTs = LocalDateTime.now();

}
