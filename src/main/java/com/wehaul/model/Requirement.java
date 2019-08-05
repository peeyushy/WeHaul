package com.wehaul.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.wehaul.constants.ReqStatus;

public class Requirement implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long reqid;

	private String reqtype;

	private String reqpickuploc;

	private String reqpickuplocid;

	private String reqdroploc;

	private String reqdroplocid;

	private boolean reqpickupdropflexi = true;

	private LocalDateTime reqdatetime;

	private boolean reqdatetimeflexi = true;

	private ReqStatus status;

	private String comments;

	private VehicleType vtype;

	private LoadType ltype;

	private Client client;

	private Date CREATEDAT;

	private Date UPDATEDAT;

	private String createdby;

	private String lastupdatedby;

	public Requirement() {
		super();
	}

	public Requirement(ReqStatus status) {
		super();
		this.status = status;
	}

	public Requirement(Client client) {
		super();
		this.client = client;
	}

	/**
	 * @return the reqid
	 */
	public Long getReqid() {
		return reqid;
	}

	/**
	 * @param reqid the reqid to set
	 */
	public void setReqid(Long reqid) {
		this.reqid = reqid;
	}

	/**
	 * @return the reqtype
	 */
	public String getReqtype() {
		return reqtype;
	}

	/**
	 * @param reqtype the reqtype to set
	 */
	public void setReqtype(String reqtype) {
		this.reqtype = reqtype;
	}

	/**
	 * @return the reqpickuploc
	 */
	public String getReqpickuploc() {
		return reqpickuploc;
	}

	/**
	 * @param reqpickuploc the reqpickuploc to set
	 */
	public void setReqpickuploc(String reqpickuploc) {
		this.reqpickuploc = reqpickuploc;
	}

	/**
	 * @return the reqpickuplocid
	 */
	public String getReqpickuplocid() {
		return reqpickuplocid;
	}

	/**
	 * @param reqpickuplocid the reqpickuplocid to set
	 */
	public void setReqpickuplocid(String reqpickuplocid) {
		this.reqpickuplocid = reqpickuplocid;
	}

	/**
	 * @return the reqdroploc
	 */
	public String getReqdroploc() {
		return reqdroploc;
	}

	/**
	 * @param reqdroploc the reqdroploc to set
	 */
	public void setReqdroploc(String reqdroploc) {
		this.reqdroploc = reqdroploc;
	}

	/**
	 * @return the reqdroplocid
	 */
	public String getReqdroplocid() {
		return reqdroplocid;
	}

	/**
	 * @param reqdroplocid the reqdroplocid to set
	 */
	public void setReqdroplocid(String reqdroplocid) {
		this.reqdroplocid = reqdroplocid;
	}

	/**
	 * @return the reqpickupdropflexi
	 */
	public boolean isReqpickupdropflexi() {
		return reqpickupdropflexi;
	}

	/**
	 * @param reqpickupdropflexi the reqpickupdropflexi to set
	 */
	public void setReqpickupdropflexi(boolean reqpickupdropflexi) {
		this.reqpickupdropflexi = reqpickupdropflexi;
	}

	/**
	 * @return the reqdatetime
	 */
	public LocalDateTime getReqdatetime() {
		return reqdatetime;
	}

	/**
	 * @param reqdatetime the reqdatetime to set
	 */
	public void setReqdatetime(LocalDateTime reqdatetime) {
		this.reqdatetime = reqdatetime;
	}

	/**
	 * @return the reqdatetimeflexi
	 */
	public boolean isReqdatetimeflexi() {
		return reqdatetimeflexi;
	}

	/**
	 * @param reqdatetimeflexi the reqdatetimeflexi to set
	 */
	public void setReqdatetimeflexi(boolean reqdatetimeflexi) {
		this.reqdatetimeflexi = reqdatetimeflexi;
	}

	/**
	 * @return the status
	 */
	public ReqStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ReqStatus status) {
		this.status = status;
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
	public LoadType getLtype() {
		return ltype;
	}

	/**
	 * @param ltype the ltype to set
	 */
	public void setLtype(LoadType ltype) {
		this.ltype = ltype;
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
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((createdby == null) ? 0 : createdby.hashCode());
		result = prime * result + ((lastupdatedby == null) ? 0 : lastupdatedby.hashCode());
		result = prime * result + ((ltype == null) ? 0 : ltype.hashCode());
		result = prime * result + ((reqdatetime == null) ? 0 : reqdatetime.hashCode());
		result = prime * result + (reqdatetimeflexi ? 1231 : 1237);
		result = prime * result + ((reqdroploc == null) ? 0 : reqdroploc.hashCode());
		result = prime * result + ((reqdroplocid == null) ? 0 : reqdroplocid.hashCode());
		result = prime * result + ((reqid == null) ? 0 : reqid.hashCode());
		result = prime * result + (reqpickupdropflexi ? 1231 : 1237);
		result = prime * result + ((reqpickuploc == null) ? 0 : reqpickuploc.hashCode());
		result = prime * result + ((reqpickuplocid == null) ? 0 : reqpickuplocid.hashCode());
		result = prime * result + ((reqtype == null) ? 0 : reqtype.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (getClass() != obj.getClass())
			return false;
		Requirement other = (Requirement) obj;
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
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
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
		if (reqdatetime == null) {
			if (other.reqdatetime != null)
				return false;
		} else if (!reqdatetime.equals(other.reqdatetime))
			return false;
		if (reqdatetimeflexi != other.reqdatetimeflexi)
			return false;
		if (reqdroploc == null) {
			if (other.reqdroploc != null)
				return false;
		} else if (!reqdroploc.equals(other.reqdroploc))
			return false;
		if (reqdroplocid == null) {
			if (other.reqdroplocid != null)
				return false;
		} else if (!reqdroplocid.equals(other.reqdroplocid))
			return false;
		if (reqid == null) {
			if (other.reqid != null)
				return false;
		} else if (!reqid.equals(other.reqid))
			return false;
		if (reqpickupdropflexi != other.reqpickupdropflexi)
			return false;
		if (reqpickuploc == null) {
			if (other.reqpickuploc != null)
				return false;
		} else if (!reqpickuploc.equals(other.reqpickuploc))
			return false;
		if (reqpickuplocid == null) {
			if (other.reqpickuplocid != null)
				return false;
		} else if (!reqpickuplocid.equals(other.reqpickuplocid))
			return false;
		if (reqtype == null) {
			if (other.reqtype != null)
				return false;
		} else if (!reqtype.equals(other.reqtype))
			return false;
		if (status != other.status)
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
		return "Requirement [reqid=" + reqid + ", reqtype=" + reqtype + ", reqpickuploc=" + reqpickuploc
				+ ", reqpickuplocid=" + reqpickuplocid + ", reqdroploc=" + reqdroploc + ", reqdroplocid=" + reqdroplocid
				+ ", reqpickupdropflexi=" + reqpickupdropflexi + ", reqdatetime=" + reqdatetime + ", reqdatetimeflexi="
				+ reqdatetimeflexi + ", status=" + status + ", comments=" + comments + ", vtype=" + vtype + ", ltype="
				+ ltype + ", client=" + client + ", CREATEDAT=" + CREATEDAT + ", UPDATEDAT=" + UPDATEDAT
				+ ", createdby=" + createdby + ", lastupdatedby=" + lastupdatedby + "]";
	}
}
