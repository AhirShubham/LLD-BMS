package com.scaler.lld.bookmyshow.models;

import jakarta.persistence.Entity;


public enum PaymentStatus {
    CONFIRMED,
    PENDING,
    IN_PROGRESS,
    REFUNDED
}
