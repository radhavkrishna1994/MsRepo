package com.training.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="users")
public class MyUser {

	@Id
	@Column(name="username",length = 100)
	private String username;
	private String password;
	private String role;
	//private boolean isEnabled;
	
}
