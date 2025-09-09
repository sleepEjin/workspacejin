package com.kh.jdbc.service;

import java.sql.Connection;
import java.util.List;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.model.vo.Member;

public class MemberService {
	
	public List<Member> selectAllMemberList() {
		Connection conn = JDBCTemplate.getConnection();
		
		
	}
}
