package com.goodibooks.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.goodibooks.vo.MemberRoleVO;
import com.goodibooks.vo.MemberVO;

import lombok.Data;

@Data
public class SpringMemberUserDetails implements UserDetails {

	private MemberVO member;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<MemberRoleVO> roles = member.getRoles();
		ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (MemberRoleVO role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {		
		return member.getPasswd();
	}

	@Override
	public String getUsername() {		
		return member.getId();
	}

	@Override
	public boolean isAccountNonExpired() {		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return member.isEnabled();
	}

}
