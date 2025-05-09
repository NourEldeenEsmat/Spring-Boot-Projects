package com.fullStack.serviceBookingSystem.entity;

import com.fullStack.serviceBookingSystem.dto.UserDto;
import com.fullStack.serviceBookingSystem.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String lastName;
    private String phone;
    private String password;
    private UserRole role;

    public UserDto getDto(){
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setName(name);
        userDto.setPhone(phone);
        return userDto;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
}
