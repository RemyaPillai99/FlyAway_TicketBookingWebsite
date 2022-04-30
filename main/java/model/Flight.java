package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

/*## Flight details table 

- flight no (PRIMARY KEY)
- airline name
- fare
- source city
- destination city
- departure time from source
- arrival time to destination
- total_seats
- booked_seats
- seat_availibility (  total_seats - booked_seats )
- date of travel
- class (Economy / Business)

depatureDate	date
flightNo	int
travelClass	varchar(255)
bookedSeats	int
fare	float
flightDuration	int
totalSeats	int
airline_fk	int
destName	varchar(255)
sourceName	varchar(255)
*/
@Entity
@IdClass(Flight_PK.class)
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightNo;
	
	@Id
	@Temporal(TemporalType.DATE)
	private Date depatureDate;
	
	@Id
	private String travelClass;
	
	

	@ManyToOne
	@JoinColumn(name = "airline_fk")
	private Airline airlineName;

	

    @ManyToOne
    @JoinColumn(name = "sourceName", referencedColumnName = "name")
	private City source;

	

	//@OneToOne
	  
	
	  @ManyToOne
	  @JoinColumn(name = "destName", referencedColumnName = "name") 
	  private City dest;
	 

	

	// private Date arrivalDate;
	
	private int flightDuration;
	
	private float fare;

	private int totalSeats;
	private int bookedSeats;

	@Formula("totalSeats-bookedSeats")
	private int availableSeats;
	
	
	
	/*
	 * @Transient private Double priceWithTaxes;
	 * 
	 * @PostLoad private void onLoad() { this.priceWithTaxes = price * taxes; }
	 * 
	 */

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public Airline getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(Airline airlineName) {
		this.airlineName = airlineName;
	}

	public Date getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(Date depatureDate) {
		this.depatureDate = depatureDate;
	}

	public int getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(int flightDuration) {
		this.flightDuration = flightDuration;
	}

	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public long getavailableSeats() {
		return availableSeats;
	}

	public void setavailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	

	  public City getSource() {
		return source;
	}

	public void setSource(City source) {
		this.source = source;
	}

	public City getDest() {
		return dest;
	}

	public void setDest(City dest) {
		this.dest = dest;
	}

	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", depatureDate=" + depatureDate + ", travelClass=" + travelClass
				+ ", airlineName=" + airlineName + ", source=" + source + ", dest=" + dest + ", flightDuration="
				+ flightDuration + ", fare=" + fare + ", totalSeats=" + totalSeats + ", bookedSeats=" + bookedSeats
				+ ", availableSeats=" + availableSeats + "]";
	}

}
