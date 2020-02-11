package com.goodibooks.service;

import com.goodibooks.vo.MemberVO;

public interface MemberService {

	void registerMember(MemberVO member);

	MemberVO findMemberByEmailAndPasswd(MemberVO member);

}
