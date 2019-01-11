package com.erwebadmin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long clientid;

	private String clientname;

	private String clienttype;

	private String contactno;

	private String address;

	private boolean broker = true;
	
	private boolean verified = false;

	// later blob
	private String comments;
	
	private String email;

	private boolean active  = true;

	private int revid;

	private List<User> users;

	private List<Vehicle> vehicle;

	private List<Load> load;

	private Date CREATEDAT;

	private Date UPDATEDAT;

	private String createdby;

	private String lastupdatedby;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String clienttype) {
		super();
		this.clienttype = clienttype;
	}

	public Client(Long clientid) {
		super();
		this.clientid = clientid;
	}

	public Long getClientid() {
		return clientid;
	}

	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getClienttype() {
		return clienttype;
	}

	public void setClienttype(String clienttype) {
		this.clienttype = clienttype;
	}

	/**
	 * @return the broker
	 */
	public boolean isBroker() {
		return broker;
	}

	/**
	 * @param broker the broker to set
	 */
	public void setBroker(boolean broker) {
		this.broker = broker;
	}	

	/**
	 * @return the verified
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * @param verified the verified to set
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * @return the revid
	 */
	public int getRevid() {
		return revid;
	}

	/**
	 * @param revid the revid to set
	 */
	public void setRevid(int revid) {
		this.revid = revid;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the vehicle
	 */
	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the load
	 */
	public List<Load> getLoad() {
		return load;
	}

	/**
	 * @param load the load to set
	 */
	public void setLoad(List<Load> load) {
		this.load = load;
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

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
