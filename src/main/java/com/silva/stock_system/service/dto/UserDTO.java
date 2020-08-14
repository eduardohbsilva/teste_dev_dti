package com.silva.stock_system.service.dto;

import com.silva.stock_system.model.User;

/**
 * A DTO representing a user, with his authorities.
 */
public class UserDTO {

    private Long id;

    private String userName;

    private String password;
    
    private String name;
    
    private Boolean isAdmin;
    
    public UserDTO() {
		// Auto-generated constructor stub
	}

	public UserDTO(User user) {
		this.id = user.getId();
		this.userName = user.getUserName();
		this.name = user.getName();
		this.isAdmin = user.getIsAdmin().equals("S") ? true : false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
