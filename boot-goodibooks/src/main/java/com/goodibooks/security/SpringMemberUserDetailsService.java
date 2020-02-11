package com.goodibooks.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.goodibooks.mapper.MemberMapper;
import com.goodibooks.vo.MemberVO;

import lombok.Data;
import lombok.Setter;

@Data
public class SpringMemberUserDetailsService implements UserDetailsService {

	@Setter
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		MemberVO member = memberMapper.selectMemberById(id);
		
		SpringMemberUserDetails details = null;
		
		if(member != null) {
			details = new SpringMemberUserDetails();
			details.setMember(member);
		}
		
		return details;
	}

}
