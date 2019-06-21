package com.timesheet.user;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmpUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmpUser;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String userName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String password;
	
	public EmpUser() {
		
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

	public int getIdEmpUser() {
		return idEmpUser;
	}

	public void setIdEmpUser(int idEmpUser) {
		this.idEmpUser = idEmpUser;
	}
	
	
	
}
