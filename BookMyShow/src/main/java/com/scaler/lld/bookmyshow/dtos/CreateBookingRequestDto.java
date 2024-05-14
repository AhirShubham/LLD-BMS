package com.scaler.lld.bookmyshow.dtos;


import com.scaler.lld.bookmyshow.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {

    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;

}
