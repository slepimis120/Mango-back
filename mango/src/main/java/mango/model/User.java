package mango.model;

import mango.dto.ExpandedUserDTO;

public abstract class User {
	private Integer id;
	private String name;
	private String surname;
	private String profilePicture;
	private String telephoneNumber;
	private String email;
	private String address;
	
	private String password;
	private boolean blocked;
	
	public User(Integer id, String firstName, String lastName, String profilePictureURL, String phoneNumber, String email,
				String address, String password, boolean blocked) {
		this.id = id;
		this.name = firstName;
		this.surname = lastName;
		this.profilePicture = profilePictureURL;
		this.telephoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.password = password;
		this.blocked = blocked;
	}

	public User(ExpandedUserDTO data) {
		this.id = -1;
		this.name = data.getName();
		this.surname = data.getSurname();
		this.profilePicture = data.getProfilePicture();
		this.telephoneNumber = data.getTelephoneNumber();
		this.email = data.getEmail();
		this.address = data.getAddress();
		this.password = data.getPassword();
		this.blocked = false;
	}
	
    public User() {

    }

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

}
