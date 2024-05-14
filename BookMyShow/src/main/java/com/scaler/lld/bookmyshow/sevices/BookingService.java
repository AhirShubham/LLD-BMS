package com.scaler.lld.bookmyshow.sevices;

import com.scaler.lld.bookmyshow.exceptions.ShowNotFoundException;
import com.scaler.lld.bookmyshow.exceptions.UserNotFoundException;
import com.scaler.lld.bookmyshow.models.*;
import com.scaler.lld.bookmyshow.repositories.BookingRepository;
import com.scaler.lld.bookmyshow.repositories.ShowRepository;
import com.scaler.lld.bookmyshow.repositories.ShowSeatRepository;
import com.scaler.lld.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(isolation= Isolation.SERIALIZABLE)
public class BookingService {

    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private UserRepository userRepository;
    private BookingRepository bookingRepository;

    public BookingService(ShowSeatRepository showSeatRepository, ShowRepository showRepository,UserRepository userRepository, BookingRepository bookingRepository) {
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
    }


    public Booking createBooking(Long showId, Long userId, List<Long> showSeatIds) throws UserNotFoundException,ShowNotFoundException{

        //Check whether valid user
        Optional<User> optionalUser=userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with id "+userId+ " does not exist");
        }



        // We need to get the entries from showSeat table for given showIds
        List<ShowSeat> showSeatlist = showSeatRepository.findAllById(showSeatIds);

        //Check if all seats are available

        for(ShowSeat showSeat : showSeatlist){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILBLE)){
                throw new RuntimeException("Show Seat with id : " + showSeat.getId() + " isn't available.");
            }
        }

        //mark the seats as blocked
        for(ShowSeat showSeat : showSeatlist){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        // Get the show with the given showId.
        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty()) {
            throw new ShowNotFoundException("Show with id: " + showId + " not found");
        }
        Show show = optionalShow.get();

        // Create the booking with pending status. [save booking obj to DB.]
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setCreatedAt(new Date());
        booking.setUser(optionalUser.get());
        booking.setShow(show);
        booking.setPayments(new ArrayList<>());
        booking.setShowSeats(showSeatlist);
        booking.setAmount(priceCalculator.calculatePrice(show, showSeats));

        return bookingRepository.save(booking);

        return booking;

    }
}
