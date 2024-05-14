package com.scaler.lld.bookmyshow;

import com.scaler.lld.bookmyshow.controllers.BookingController;
import com.scaler.lld.bookmyshow.dtos.CreateBookingRequestDto;
import com.scaler.lld.bookmyshow.dtos.CreateBookingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication {

	@Autowired
	BookingController bookingController;

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
		CreateBookingResponseDto createBookingResponseDto = bookingController.createBooking(new CreateBookingRequestDto() );


	}

}
