package com.optum.optumsample.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "users")
@Data
public class User {
    @Id
    @SequenceGenerator(name = "userSeqGen", sequenceName = "userSeqGen", initialValue = 11, allocationSize = 1)
    @GeneratedValue(generator = "userSeqGen")
    private Long user_id;
    @Column
    private String firstName;
    @Column
    private String middleInitial;
    @Column
    private String lastName;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zipCode;
    @Column
    private String phoneNumber;
}
