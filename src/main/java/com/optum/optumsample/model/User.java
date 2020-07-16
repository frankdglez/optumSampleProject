package com.optum.optumsample.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private String id = UUID.randomUUID().toString();
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String phoneNumber;
    private Address address;
}
