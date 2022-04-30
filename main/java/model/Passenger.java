package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Passenger {

	@Id
    @GeneratedValue
	private Long passenger_Id;
	
	
	@OneToOne
	private User user;
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	private String emailId;
	
	
	@OneToOne
	//(cascade=CascadeType.ALL)
	//@JoinColumn(name="IdProof_no")
	private PassengerIDProof idProof ;

	private String firstName;
	
	private String lastName;
	
	
	private String gender;
	
	
	
	private String dob;
	
	
	private String phoneNum;
	
	
	private String address;
	
	private String country;

	/*
	 * private String bookingRef;
	 * 
	 * public String getBookingRef() { return bookingRef; }
	 * 
	 * 
	 * public void setBookingRef(String bookingRef) { this.bookingRef = bookingRef;
	 * }
	 */

	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Long getPassenger_Id() {
		return passenger_Id;
	}


	public void setPassenger_Id(Long passenger_Id) {
		this.passenger_Id = passenger_Id;
	}


	

	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public PassengerIDProof getIdProof() {
		return idProof;
	}


	public void setIdProof(PassengerIDProof idProof) {
		this.idProof = idProof;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	
}
