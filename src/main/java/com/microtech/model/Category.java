package com.microtech.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;


    private String name;
}
