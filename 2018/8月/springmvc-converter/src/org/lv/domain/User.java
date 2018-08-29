package org.lv.domain;

import java.util.Date;

public class User {

	private String username;
	private Date birthday;
	
	public User() {
		super();
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
