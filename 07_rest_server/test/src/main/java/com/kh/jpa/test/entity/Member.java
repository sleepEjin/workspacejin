package com.kh.jpa.test.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED) //JPA 스펙상 필수
@Entity
public class Member {

    @Id
    @Column(length = 30)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(length = 100, nullable = false)
    private String userPwd;

    @Column(length = 15, nullable = false)
    private String userName;

    @Column(length = 254)
    private String email;

    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    @Column()
    private String phone;

    @Column(length = 100)
    private String address;

    public enum Gender {
        M, F
    }
}
