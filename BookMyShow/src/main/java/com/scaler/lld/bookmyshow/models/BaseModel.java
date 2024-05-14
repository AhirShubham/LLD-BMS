package com.scaler.lld.bookmyshow.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@MappedSuperclass //this will propogate the attributes to all child classes
public class BaseModel {

    @Id //For marking the field property as a primary key of the entity.
    @GeneratedValue(strategy= GenerationType.IDENTITY) // instruct hibernate to automatically generate a unique value using some strategy
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}

/*
we don't want JPA to create this table.
But all attributes must be present in child classes
*/
