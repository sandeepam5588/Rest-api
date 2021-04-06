package org.project.restapi.model;

import java.io.Serializable;


public class ResultId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resultID;
	private String regno;
	public ResultId() {}
	
	public ResultId(String resultID, String regno) {
		super();
		this.resultID = resultID;
		this.regno = regno;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regno == null) ? 0 : regno.hashCode());
		result = prime * result + ((resultID == null) ? 0 : resultID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultId other = (ResultId) obj;
		if (regno == null) {
			if (other.regno != null)
				return false;
		} else if (!regno.equals(other.regno))
			return false;
		if (resultID == null) {
			if (other.resultID != null)
				return false;
		} else if (!resultID.equals(other.resultID))
			return false;
		return true;
	}
	
	

}
