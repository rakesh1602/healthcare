package com.crossasyst.sqstodatabase.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String storeNumber;

    private String actions;

    private String lastActionDateTime;

    private String actionHistory;

    private String systemVersion;

    private boolean active;

    private Long addressId;

    private String addressLineOne;

    private String addressLineTwo;

    private String city;

    private String state;

    private String zipcode;

    private Long contactId;

    private String phoneNumberOne;

    private String phoneNumberTwo;
}
