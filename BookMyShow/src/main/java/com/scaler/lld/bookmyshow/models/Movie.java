package com.scaler.lld.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;
    private Date releaseDate;
}
