package com.jamesconlon.financetracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter; // allows you to get the value of a field without writing a getter/setter method
import lombok.Setter;

import java.time.LocalDate;

/*
    The Entry class represents a financial entry.
*/


@Entity
public class Entry {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generates unique primary key values
    private Long id; // transaction id

    @Getter
    @Setter
    private LocalDate date;
    @Getter
    @Setter
    private double latitude;
    @Getter
    @Setter
    private double longitude;

    @Getter
    @Setter
    private int amount; // in cents
    @Getter
    @Setter
    private String category; // eg groceries, school, rent, gas, clothes
    @Getter
    @Setter
    private String merchant; // eg walmart, amazon, hooters
    @Getter
    @Setter
    private String tag; // for additional categorization (reimbursement, refund, income, etc)
    @Getter
    @Setter
    private String description;

}

