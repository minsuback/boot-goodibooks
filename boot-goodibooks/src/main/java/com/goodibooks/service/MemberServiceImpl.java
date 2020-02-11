package com.goodibooks.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.goodibooks.mapper.MemberMapper;
import com.goodibooks.vo.MemberRoleVO;
import com.goodibooks.vo.MemberVO;

import lombok.Setter;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Setter
	private MemberMapper memberMapper;
	
	@Setter
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void registerMember(MemberVO member) {

		// 패스워드 암호화 처리
		String hashedPasswd = passwordEncoder.encode(member.getPasswd());
		member.setPasswd(hashedPasswd);

		memberMapper.insertMember(member);
		
//		for(MemberRoleVO role : member.getRoles()) {
//			memberMapper.insertMemberRole(role);
//		}
		
		MemberRoleVO role = new MemberRoleVO();
		role.setId(member.getId());
		role.setRoleName("ROLE_MEMBER");
		memberMapper.insertMemberRole(role);
	}

	@Override
	public MemberVO findMemberByEmailAndPasswd(MemberVO member) {
		
		// 패스워드 아모화 처리
		String hashedPasswd = passwordEncoder.encode(member.getPasswd());
		member.setPasswd(hashedPasswd);
		
//		return memberMapper.selectMemberByEmailAndPasswd(member);
		return null;
		
	}

}
