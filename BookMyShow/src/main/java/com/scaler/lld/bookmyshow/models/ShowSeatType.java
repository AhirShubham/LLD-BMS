package com.scaler.lld.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{

    @ManyToOne
    private Show show;

    /*
    ShowSeatType  Show
         1    -  1   1 showSeatType will have one show
         M     -  1  1 show can be part of many showSeatType
     */

    @ManyToOne
    private Seat seat;

    private int price;


}
