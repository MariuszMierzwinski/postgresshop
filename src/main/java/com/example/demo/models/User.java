package com.example.demo.models;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "user1")
/*
@Eager
*/
public class User implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "sure_name")
    private String sureName;
    private String email;
    private String userName;
    private String password;
    private String matchingPassword;
    private int active;
    /*@JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})*/

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user1_authority",
            joinColumns = {@JoinColumn(name = "user1_id")},
            inverseJoinColumns = {@JoinColumn(name = "authorities_id")})
    private Set<Authorities> authorities = new HashSet<>();

    public User() {
    }

}
