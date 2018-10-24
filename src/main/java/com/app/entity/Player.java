package com.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer rate;

}
