package org.lv.domain;

public class User {
	private String username;
	private String sex;
	private Integer age;
	private String password;
	
	public User(String username, String sex, Integer age, String password) {
		super();
		this.username = username;
		this.sex = sex;
		this.age = age;
		this.password = password;
	}

	public User() {}

	public User(String username, String sex, Integer age) {
		super();
		this.username = username;
		this.sex = sex;
		this.age = age;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
