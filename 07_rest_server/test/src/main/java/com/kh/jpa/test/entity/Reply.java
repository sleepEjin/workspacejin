package com.kh.jpa.test.entity;

import com.kh.jpa.test.enums.CommonEnums;
import jakarta.persistence.*;
import lombok.*;

@Builder @AllArgsConstructor
@Getter
@Entity
@Table(name = "REPLY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyNo;

    @Column(length = 400, nullable = false)
    private String replyContent;

    @Column(length = 30, nullable = false)
    private String replyWriter;

    @Column(length=1, nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private CommonEnums.Status status = CommonEnums.Status.Y;

    //==== 연관관계 ====
    //댓글 : 게시글 (N : 1) - 연관관계 주인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_bno", nullable = false)
    private Board board;

    //댓글 : 댓글작성
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_writer", nullable = false)
    private Member member;

}
