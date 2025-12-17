package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Entity
@Table(name = "tag")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long tagId;

    @Column(length = 30, nullable = false, unique = true)
    private String tagName;
}
