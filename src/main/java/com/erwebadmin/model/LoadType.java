package com.erwebadmin.model;

import java.io.Serializable;

public class LoadType implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long ltypeid;
	
	private String ltypename;
	
	private String status;
	
	private String ltypedesc;	

	public LoadType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoadType(Long ltypeid) {
		super();
		this.ltypeid = ltypeid;
	}

	/**
	 * @return the ltypeid
	 */
	public Long getLtypeid() {
		return ltypeid;
	}

	/**
	 * @param ltypeid the ltypeid to set
	 */
	public void setLtypeid(Long ltypeid) {
		this.ltypeid = ltypeid;
	}

	/**
	 * @return the ltypename
	 */
	public String getLtypename() {
		return ltypename;
	}

	/**
	 * @param ltypename the ltypename to set
	 */
	public void setLtypename(String ltypename) {
		this.ltypename = ltypename;
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
		this.status = status;
	}

	/**
	 * @return the ltypedesc
	 */
	public String getLtypedesc() {
		return ltypedesc;
	}

	/**
	 * @param ltypedesc the ltypedesc to set
	 */
	public void setLtypedesc(String ltypedesc) {
		this.ltypedesc = ltypedesc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ltypedesc == null) ? 0 : ltypedesc.hashCode());
		result = prime * result + ((ltypeid == null) ? 0 : ltypeid.hashCode());
		result = prime * result + ((ltypename == null) ? 0 : ltypename.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LoadType))
			return false;
		LoadType other = (LoadType) obj;
		if (ltypedesc == null) {
			if (other.ltypedesc != null)
				return false;
		} else if (!ltypedesc.equals(other.ltypedesc))
			return false;
		if (ltypeid == null) {
			if (other.ltypeid != null)
				return false;
		} else if (!ltypeid.equals(other.ltypeid))
			return false;
		if (ltypename == null) {
			if (other.ltypename != null)
				return false;
		} else if (!ltypename.equals(other.ltypename))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoadType [ltypeid=" + ltypeid + ", ltypename=" + ltypename + ", status=" + status + ", ltypedesc="
				+ ltypedesc + "]";
	}				
}
