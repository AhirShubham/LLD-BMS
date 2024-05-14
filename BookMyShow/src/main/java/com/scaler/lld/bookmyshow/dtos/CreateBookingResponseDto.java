package com.scaler.lld.bookmyshow.dtos;

import com.scaler.lld.bookmyshow.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDto {

    private Long bookingId;
    private ResponseStatus responseStatus;
    private int amount;
}
