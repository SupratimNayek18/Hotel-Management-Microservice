package com.guest.dto;

public class UserCredentialsDTO {

	private Integer id;

	private String userName;

	private String password;

	private Integer guestId;

	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserCredentialsDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", guestId="
				+ guestId + ", role=" + role + "]";
	}

}
