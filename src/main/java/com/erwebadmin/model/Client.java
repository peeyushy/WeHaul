package com.erwebadmin.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {
	
	private Long clientid;
	
	private String clientname;

	private String clienttype;
	
	private String contactno;

	private String country;

	private String city;

	private String addressline1;

	private String addressline2;

	private String postcode;

	private String website;

	// blob column
	private String clientlogo;

	// blob
	private String comments;

	private String status;

	private Long revid;

	private Date CREATEDAT;

	private Date UPDATEDAT;
	
	private String createdby;	
	
	private String lastupdatedby;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(Long clientid, String clientname, String clienttype) {
		super();
		this.clientid = clientid;
		this.clientname = clientname;
		this.clienttype = clienttype;
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
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getClientlogo() {
		return clientlogo;
	}

	public void setClientlogo(String clientlogo) {
		this.clientlogo = clientlogo;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public Long getRevid() {
		return revid;
	}

	public void setRevid(Long revid) {
		this.revid = revid;
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
}
