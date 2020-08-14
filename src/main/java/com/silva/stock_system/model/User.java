package com.silva.stock_system.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.dom4j.tree.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.silva.stock_system.service.dto.UserDTO;

/**
 * A user.
 */
@Entity
@Table(name = "user")
@SuppressWarnings("serial")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username", length = 50, unique = true)
    private String userName;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "password", length = 60)
    private String password;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;
    
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "admin", length = 1)
    private String isAdmin;
    
	public User() {
		// Auto-generated constructor stub
	}

	public User(UserDTO userDTO) {
		this.id = userDTO.getId();
		this.userName = userDTO.getUserName();
		this.name = userDTO.getName();
		this.isAdmin = userDTO.getIsAdmin() ? "S" : "N";
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

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

}
