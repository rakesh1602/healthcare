package com.practice.restapisingletable.entity;

import lombok.*;
import org.hibernate.annotations.GeneratorType;


import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cricket_players_details")
public class CricketPlayerEntity {
    @Id
    @SequenceGenerator(name = "cricket_player_seq", sequenceName ="cricket_player_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cricket_player_seq")
    private Long id;
    private String name;
    private String role;
}
