package com.example.taylormanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @Column(unique=true)
    @NonNull
    private String userName;

    @Column(unique = true)
    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String address;

    @NonNull
    private String mobileNumber;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="USER_ROLE",
    joinColumns = {
            @JoinColumn(name = "USER_ID")
        },
            inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")
        }
    )
    private Set<Role> role;

    public User() {
    }
}
