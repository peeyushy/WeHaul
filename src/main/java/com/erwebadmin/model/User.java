package com.erwebadmin.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	private Long userid;
	
	private Long clientid;

	private String name;

	private String username;

	private String password;

	private String email;	

	private String contactno;

	private String notificationtype;
	
	private String status;
	
	private Role role;
	
	private Date CREATEDAT;

	private Date UPDATEDAT;	
	
	private String createdby;
	
	private String lastupdatedby;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(Long clientid) {
		super();
		this.clientid = clientid;
	}

	public User(Long userid, Long clientid, String name, String username, String password, String email,
			Role role) {
		super();
		this.userid = userid;
		this.clientid = clientid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getClientid() {
		return clientid;
	}

	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getNotificationtype() {
		return notificationtype;
	}

	public void setNotificationtype(String notificationtype) {
		this.notificationtype = notificationtype;
	}	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if(status.equals("DISABLED,ACTIVE")) {
			this.status = "ACTIVE";	
		}else {
			this.status = status;	
		}
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getCREATEDAT() {
		return CREATEDAT;
	}

	public void setCREATEDAT(Date cREATEDAT) {
		CREATEDAT = cREATEDAT;
	}

	public Date getUPDATEDAT() {
		return UPDATEDAT;
	}

	public void setUPDATEDAT(Date uPDATEDAT) {
		UPDATEDAT = uPDATEDAT;
	}


	public String getCreatedby() {
		return createdby;
	}


	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}


	public String getLastupdatedby() {
		return lastupdatedby;
	}


	public void setLastupdatedby(String lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}	
}
