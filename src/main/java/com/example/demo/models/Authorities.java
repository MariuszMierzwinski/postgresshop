package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "authorities")
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AuthorityType name;

    public Authorities() {
    }

    public Authorities(AuthorityType name) {
        this.name = name;
    }
}