package org.lv.domain;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class User {

	@NotBlank(message="��¼������Ϊ��")
	private String loginname;
	
	@NotBlank(message="���벻��Ϊ��")
	@Length(min=6,max=8,message="���볤�ȱ�����6λ��8λ֮��")
	private String password;
	
	@NotBlank(message="�û�������Ϊ��")
	private String username;
	
	@Range(min=15,max=60,message="���������15��69��֮��")
	private int age;
	
	@Email(message="�����ǺϷ��������ַ")
	private String email;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past(message="���ձ�����һ����ȥ������")
	private Date birthday;
	
	@Length(min=11,max=11,message="��Ч�ĵ绰����")
	private String phone;

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
