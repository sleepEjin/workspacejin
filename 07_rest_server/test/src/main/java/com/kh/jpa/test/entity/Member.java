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

    //==== 연관관계 맵핑 ====
    //cascade Member객체 상태 자체가 삭제(변경)되면 profile에도 영향을 주겠다.
    //orphanRemoval : Member객체에서 profile의 참조값이 삭제되면 실제 DB에 반영하겠다.
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
    private Profile profile;

    public enum Gender {
        M, F
    }
}
