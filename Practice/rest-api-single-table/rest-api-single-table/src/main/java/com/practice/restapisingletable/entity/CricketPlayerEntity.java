package com.practice.restapisingletable.entity;

import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cricket_players_details")
public class CricketPlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String role;
}
