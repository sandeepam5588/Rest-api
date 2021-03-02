package org.project.restapi.model;

import javax.persistence.Embeddable;

@Embeddable
public class ContactDetail {
	private String phoneNumber;
	private String mobileNumber;
	private String street;
	private String city;
	private String state;
	private int pincode;
	public ContactDetail() {}
	public ContactDetail(String phoneNumber, String mobileNumber, String street, String city, String state,
			int pincode) {
		super();
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "ContactDetail [phoneNumber=" + phoneNumber + ", mobileNumber=" + mobileNumber + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	

}