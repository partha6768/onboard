package com.imovies.onboard.resource.booking.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class BookingStatusUpdateVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "status can not null or empty")
    @Pattern(regexp = "^SUCCESS|FAILED|CANCELLED$")
    private String status;

    private String paymentTransactionId;

}
