package com.goodibooks.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {

	private String id;
	private String passwd;
	private String name; 
	private String phone;
	private String email;
	private boolean userType;
	private boolean deleted;
	private String addr1;
	private String addr2;
	private String addr3;
	private Date regDate;
	private boolean enabled;
	
	private List<MemberRoleVO> roles;
	
}
