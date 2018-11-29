package com.erwebadmin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long vid;

	private String regno;

	private VehicleType vtype;

	private List<LoadType> ltype = new ArrayList<>();

	private String avatar;

	private int opcost;

	private String status;

	private Client client;
	
	private List<Load> loads = new ArrayList<>();

	private Date CREATEDAT;

	private Date UPDATEDAT;

	private String createdby;

	private String lastupdatedby;	

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(Client client) {
		super();
		this.client = client;
	}

	/**
	 * @return the vid
	 */
	public Long getVid() {
		return vid;
	}

	/**
	 * @param vid the vid to set
	 */
	public void setVid(Long vid) {
		this.vid = vid;
	}

	/**
	 * @return the regno
	 */
	public String getRegno() {
		return regno;
	}

	/**
	 * @param regno the regno to set
	 */
	public void setRegno(String regno) {
		this.regno = regno;
	}

	/**
	 * @return the vtype
	 */
	public VehicleType getVtype() {
		return vtype;
	}

	/**
	 * @param vtype the vtype to set
	 */
	public void setVtype(VehicleType vtype) {
		this.vtype = vtype;
	}

	/**
	 * @return the ltype
	 */
	public List<LoadType> getLtype() {
		return ltype;
	}

	/**
	 * @param ltype the ltype to set
	 */
	public void setLtype(List<LoadType> ltype) {
		this.ltype = ltype;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the opcost
	 */
	public int getOpcost() {
		return opcost;
	}

	/**
	 * @param opcost the opcost to set
	 */
	public void setOpcost(int opcost) {
		this.opcost = opcost;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		if (status.equals("DISABLED,ACTIVE")) {
			this.status = "ACTIVE";
		} else {
			this.status = status;
		}
	}	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}	

	/**
	 * @return the loads
	 */
	public List<Load> getLoads() {
		return loads;
	}

	/**
	 * @param loads the loads to set
	 */
	public void setLoads(List<Load> loads) {
		this.loads = loads;
	}

	/**
	 * @return the cREATEDAT
	 */
	public Date getCREATEDAT() {
		return CREATEDAT;
	}

	/**
	 * @param cREATEDAT the cREATEDAT to set
	 */
	public void setCREATEDAT(Date cREATEDAT) {
		CREATEDAT = cREATEDAT;
	}

	/**
	 * @return the uPDATEDAT
	 */
	public Date getUPDATEDAT() {
		return UPDATEDAT;
	}

	/**
	 * @param uPDATEDAT the uPDATEDAT to set
	 */
	public void setUPDATEDAT(Date uPDATEDAT) {
		UPDATEDAT = uPDATEDAT;
	}

	/**
	 * @return the createdby
	 */
	public String getCreatedby() {
		return createdby;
	}

	/**
	 * @param createdby the createdby to set
	 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	/**
	 * @return the lastupdatedby
	 */
	public String getLastupdatedby() {
		return lastupdatedby;
	}

	/**
	 * @param lastupdatedby the lastupdatedby to set
	 */
	public void setLastupdatedby(String lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CREATEDAT == null) ? 0 : CREATEDAT.hashCode());
		result = prime * result + ((UPDATEDAT == null) ? 0 : UPDATEDAT.hashCode());
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((createdby == null) ? 0 : createdby.hashCode());
		result = prime * result + ((lastupdatedby == null) ? 0 : lastupdatedby.hashCode());
		result = prime * result + ((ltype == null) ? 0 : ltype.hashCode());
		result = prime * result + opcost;
		result = prime * result + ((regno == null) ? 0 : regno.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((vid == null) ? 0 : vid.hashCode());
		result = prime * result + ((vtype == null) ? 0 : vtype.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vehicle))
			return false;
		Vehicle other = (Vehicle) obj;
		if (CREATEDAT == null) {
			if (other.CREATEDAT != null)
				return false;
		} else if (!CREATEDAT.equals(other.CREATEDAT))
			return false;
		if (UPDATEDAT == null) {
			if (other.UPDATEDAT != null)
				return false;
		} else if (!UPDATEDAT.equals(other.UPDATEDAT))
			return false;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (createdby == null) {
			if (other.createdby != null)
				return false;
		} else if (!createdby.equals(other.createdby))
			return false;
		if (lastupdatedby == null) {
			if (other.lastupdatedby != null)
				return false;
		} else if (!lastupdatedby.equals(other.lastupdatedby))
			return false;
		if (ltype == null) {
			if (other.ltype != null)
				return false;
		} else if (!ltype.equals(other.ltype))
			return false;
		if (opcost != other.opcost)
			return false;
		if (regno == null) {
			if (other.regno != null)
				return false;
		} else if (!regno.equals(other.regno))
			return false;
		if (status != other.status)
			return false;
		if (vid == null) {
			if (other.vid != null)
				return false;
		} else if (!vid.equals(other.vid))
			return false;
		if (vtype == null) {
			if (other.vtype != null)
				return false;
		} else if (!vtype.equals(other.vtype))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", regno=" + regno + ", vtype=" + vtype + ", ltype=" + ltype + ", avatar="
				+ avatar + ", opcost=" + opcost + ", status=" + status + ", client=" + client + ", CREATEDAT="
				+ CREATEDAT + ", UPDATEDAT=" + UPDATEDAT + ", createdby=" + createdby + ", lastupdatedby="
				+ lastupdatedby + "]";
	}

}
