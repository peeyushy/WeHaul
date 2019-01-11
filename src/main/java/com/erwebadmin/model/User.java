package com.erwebadmin.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userid;

	private String name;

	private String username;

	private String password;

	private String email;

	private String contactno;

	private String notificationtype;

	private boolean active = true;

	private Role role;

	private Date CREATEDAT;

	private Date UPDATEDAT;

	private String createdby;

	private String lastupdatedby;

	private Client client;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Client client) {
		super();
		this.client = client;
	}

	public User(Long userid) {
		super();
		this.userid = userid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
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

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
}
