package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BookingDetail {

	@Id
	@GeneratedValue
	private Long booking_Id;
	
	@OneToOne
	private Passenger passenger;
	
	@OneToOne
	private Flight flightId;
	
	private String refNo;

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public Long getBooking_Id() {
		return booking_Id;
	}

	public void setBooking_Id(Long booking_Id) {
		this.booking_Id = booking_Id;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlightId() {
		return flightId;
	}

	public void setFlightId(Flight flightId) {
		this.flightId = flightId;
	} 
	
	
}
