package com.scaler.lld.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


public enum BookingStatus {
    CONFIRMED,
    PENDING,
    CANCEL
}
