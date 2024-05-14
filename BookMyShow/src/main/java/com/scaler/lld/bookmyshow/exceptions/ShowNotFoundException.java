package com.scaler.lld.bookmyshow.exceptions;

public class ShowNotFoundException extends Exception{

    String message;

    public ShowNotFoundException(String message) {

        super(message);
    }
}
