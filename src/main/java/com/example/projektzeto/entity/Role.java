package com.example.projektzeto.entity;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "tbl_role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;


    @OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}