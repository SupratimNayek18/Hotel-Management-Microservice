package com.guest.dto;

public class GuestDTO {

	private Integer id;

	private String name;

	private Integer age;

	private Long phoneNumber;
	
	private AddressDTO addressDTO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	@Override
	public String toString() {
		return "GuestDTO [id=" + id + ", name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber
				+ ", addressDTO=" + addressDTO + "]";
	}


}
