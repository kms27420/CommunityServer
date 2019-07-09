package com.kms.communityserver.model.account;

public class AccountTO {
	private String id, password, name;
	private Long birth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getBirth() {
		return birth;
	}
	public void setBirth(Long birth) {
		this.birth = birth;
	}
}
