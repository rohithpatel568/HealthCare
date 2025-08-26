package com.project.healthcare;

import java.sql.Date;

public class Doctor {
	private int dId;
	private String dName;
	private int exp;
	private String specialization;
	private Date dob;
	private String location;

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
		return "Doctor [dId=" + dId + ", dName=" + dName + ", exp=" + exp + ", specialization=" + specialization
				+ ", dob=" + dob + ", location=" + location + "]";
	}

	public Doctor(int dId, String dName, int exp, String specialization, Date dob, String location) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.exp = exp;
		this.specialization = specialization;
		this.dob = dob;
		this.location = location;
	}

	public int getExp() {
		return exp;
	}

	public String getSpecialization() {
		return specialization;
	}

	public Date getDob() {
		return dob;
	}

	public String getLocation() {
		return location;
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

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
