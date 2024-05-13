package com.scaler.lld.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    private int amount;
    private PaymentProvider paymentProvider;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String referenceNumber;

}
