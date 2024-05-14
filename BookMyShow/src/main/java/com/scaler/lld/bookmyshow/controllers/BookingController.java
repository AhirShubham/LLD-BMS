package com.scaler.lld.bookmyshow.controllers;

import com.scaler.lld.bookmyshow.dtos.CreateBookingRequestDto;
import com.scaler.lld.bookmyshow.dtos.CreateBookingResponseDto;
import com.scaler.lld.bookmyshow.models.Booking;
import com.scaler.lld.bookmyshow.models.BookingStatus;
import com.scaler.lld.bookmyshow.models.ResponseStatus;
import com.scaler.lld.bookmyshow.sevices.BookingService;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class BookingController {

    BookingService bookingService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    public CreateBookingResponseDto createBooking(CreateBookingRequestDto createBookingRequestDto) {

        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();

        try {
            Booking booking= bookingService.createBooking(createBookingRequestDto.getShowId(),createBookingRequestDto.getUserId(),createBookingRequestDto.getShowSeatIds());
            responseDto.setBookingId(booking.getId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);

        }
        catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILED);
        }

        return responseDto;


    }
}
