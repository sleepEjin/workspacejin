package com.kh.spring.service;

import com.kh.spring.model.vo.Member;
import org.apache.ibatis.annotations.Mapper;

public interface MemberService {
    Member getMemberById(String memberId);
    int getMemberCountById(String memberId);
    int addMember(Member member);
    int updateMember(Member member);
}


