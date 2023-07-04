package com.crossasyst.sqstodatabase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sqs_message_entity")
@ToString
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pharmacyId;

    @Column(name = "store_number")
    private String storeNumber;

    private String actions;

    @Column(name = "last_action_date_time")
    private String lastActionDateTime;

    @Column(name = "action_history")
    private String actionHistory;

    @Column(name = "system_version")
    private String systemVersion;

    private boolean active;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address_line_one")
    private String addressLineOne;

    @Column(name = "address_line_two")
    private String addressLineTwo;

    private String city;

    private String state;

    private String zipcode;

    @Column(name = "contact_id")
    private Long contactId;

    @Column(name = "phone_number_one")
    private String phoneNumberOne;

    @Column(name = "phone_number_two")
    private String phoneNumberTwo;
}
