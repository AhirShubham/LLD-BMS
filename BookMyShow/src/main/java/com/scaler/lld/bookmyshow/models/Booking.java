package com.scaler.lld.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity //automatically creates a table in db with help of ORM
public  class Booking extends BaseModel{

    private String bookingNumber;

    // 1 Booking -> 1 user, 1 user -> Many Bookings
    @ManyToOne
    private User user;
    @OneToMany
    private List<ShowSeat> showSeats;

    private int amount;

    @OneToMany
    private List<Payment> payments;

    private BookingStatus bookingStatus;

}
