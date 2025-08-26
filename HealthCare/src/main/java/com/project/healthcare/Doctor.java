package com.project.healthcare;

import java.sql.Date;

public class Doctor {
	private int dId;
	private String dName;
	private int exp;
	private String spec;
	private Date dob;
	private String loc;

	public Doctor() {
	}

	public int getdId() {
		return dId;
	}

	public String getdName() {
		return dName;
	}

	@Override
	public String toString() {
		return "Doctor [dId=" + dId + ", dName=" + dName + ", exp=" + exp + ", specialization=" + spec + ", dob=" + dob
				+ ", location=" + loc + "]";
	}

	public Doctor(int dId, String dName, int exp, String spec, Date dob, String loc) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.exp = exp;
		this.spec = spec;
		this.dob = dob;
		this.loc = loc;
	}

	public int getExp() {
		return exp;
	}

	public String getSpec() {
		return spec;
	}

	public Date getDob() {
		return dob;
	}

	public String getLoc() {
		return loc;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
