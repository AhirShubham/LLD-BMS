package com.scaler.lld.bookmyshow.models;

import jakarta.persistence.*;
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

    @ManyToOne
    private Show show;

    @ManyToMany//depends on scenario
    private List<ShowSeat> showSeats;

    private int amount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.ORDINAL) //store as a number/id instead of entire entire string
    private BookingStatus bookingStatus;

}
