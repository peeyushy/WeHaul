package com.erwebadmin.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class Load implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long lid;

	private String lpickuploc;

	private String ldroploc;

	private boolean lpickupdropflexi = true;

	private LoadType ltype;

	private boolean lassistance = false;

	private LocalDateTime ldatetime;

	private boolean ldatetimeflexi = true;

	private String status;

	private Long clientid;

	private String comments;

	private Date CREATEDAT;

	private Date UPDATEDAT;

	private String createdby;

	private String lastupdatedby;

	/**
	 * @return the lid
	 */
	public Long getLid() {
		return lid;
	}

	/**
	 * @param lid the lid to set
	 */
	public void setLid(Long lid) {
		this.lid = lid;
	}

	/**
	 * @return the lpickuploc
	 */
	public String getLpickuploc() {
		return lpickuploc;
	}

	/**
	 * @param lpickuploc the lpickuploc to set
	 */
	public void setLpickuploc(String lpickuploc) {
		this.lpickuploc = lpickuploc;
	}

	/**
	 * @return the ldroploc
	 */
	public String getLdroploc() {
		return ldroploc;
	}

	/**
	 * @param ldroploc the ldroploc to set
	 */
	public void setLdroploc(String ldroploc) {
		this.ldroploc = ldroploc;
	}

	/**
	 * @return the lpickupdropflexi
	 */
	public boolean isLpickupdropflexi() {
		return lpickupdropflexi;
	}

	/**
	 * @param lpickupdropflexi the lpickupdropflexi to set
	 */
	public void setLpickupdropflexi(boolean lpickupdropflexi) {
		this.lpickupdropflexi = lpickupdropflexi;
	}

	/**
	 * @return the ltype
	 */
	public LoadType getLtype() {
		return ltype;
	}

	/**
	 * @param ltype the ltype to set
	 */
	public void setLtype(LoadType ltype) {
		this.ltype = ltype;
	}

	/**
	 * @return the lassistance
	 */
	public boolean isLassistance() {
		return lassistance;
	}

	/**
	 * @param lassistance the lassistance to set
	 */
	public void setLassistance(boolean lassistance) {
		this.lassistance = lassistance;
	}

	/**
	 * @return the ldatetime
	 */
	public LocalDateTime getLdatetime() {
		return ldatetime;
	}

	/**
	 * @param ldatetime the ldatetime to set
	 */
	public void setLdatetime(LocalDateTime ldatetime) {
		this.ldatetime = ldatetime;
	}

	/**
	 * @return the ldatetimeflexi
	 */
	public boolean isLdatetimeflexi() {
		return ldatetimeflexi;
	}

	/**
	 * @param ldatetimeflexi the ldatetimeflexi to set
	 */
	public void setLdatetimeflexi(boolean ldatetimeflexi) {
		this.ldatetimeflexi = ldatetimeflexi;
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

	/**
	 * @return the clientid
	 */
	public Long getClientid() {
		return clientid;
	}

	/**
	 * @param clientid the clientid to set
	 */
	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
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
		result = prime * result + ((clientid == null) ? 0 : clientid.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((createdby == null) ? 0 : createdby.hashCode());
		result = prime * result + (lassistance ? 1231 : 1237);
		result = prime * result + ((lastupdatedby == null) ? 0 : lastupdatedby.hashCode());
		result = prime * result + ((ldatetime == null) ? 0 : ldatetime.hashCode());
		result = prime * result + (ldatetimeflexi ? 1231 : 1237);
		result = prime * result + ((ldroploc == null) ? 0 : ldroploc.hashCode());
		result = prime * result + ((lid == null) ? 0 : lid.hashCode());
		result = prime * result + (lpickupdropflexi ? 1231 : 1237);
		result = prime * result + ((lpickuploc == null) ? 0 : lpickuploc.hashCode());
		result = prime * result + ((ltype == null) ? 0 : ltype.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (!(obj instanceof Load))
			return false;
		Load other = (Load) obj;
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
		if (clientid == null) {
			if (other.clientid != null)
				return false;
		} else if (!clientid.equals(other.clientid))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (createdby == null) {
			if (other.createdby != null)
				return false;
		} else if (!createdby.equals(other.createdby))
			return false;
		if (lassistance != other.lassistance)
			return false;
		if (lastupdatedby == null) {
			if (other.lastupdatedby != null)
				return false;
		} else if (!lastupdatedby.equals(other.lastupdatedby))
			return false;
		if (ldatetime == null) {
			if (other.ldatetime != null)
				return false;
		} else if (!ldatetime.equals(other.ldatetime))
			return false;
		if (ldatetimeflexi != other.ldatetimeflexi)
			return false;
		if (ldroploc == null) {
			if (other.ldroploc != null)
				return false;
		} else if (!ldroploc.equals(other.ldroploc))
			return false;
		if (lid == null) {
			if (other.lid != null)
				return false;
		} else if (!lid.equals(other.lid))
			return false;
		if (lpickupdropflexi != other.lpickupdropflexi)
			return false;
		if (lpickuploc == null) {
			if (other.lpickuploc != null)
				return false;
		} else if (!lpickuploc.equals(other.lpickuploc))
			return false;
		if (ltype == null) {
			if (other.ltype != null)
				return false;
		} else if (!ltype.equals(other.ltype))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	public Load(@NotNull Long clientid) {
		super();
		this.clientid = clientid;
	}

	public Load() {
		super();
		// TODO Auto-generated constructor stub
	}
}
