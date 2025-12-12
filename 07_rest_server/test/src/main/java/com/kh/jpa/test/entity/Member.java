package com.kh.jpa.test.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(length = 100, nullable = false)
    private String userPwd;

    @Column(length = 15, nullable = false)
    private String userName;

    @Column(length = 254)
    private String email;

    @Column(length = 1, check =)
    private char gender;
    private int age;
    private LocalDateTime address;
    private LocalDateTime enrollDate;
    private char status;
}
