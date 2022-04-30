package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Flight_PK implements Serializable{

	
	public Flight_PK() {
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int flightNo;
	protected Date depatureDate;
	protected String travelClass;
	
	
	public Flight_PK(int flightNo, Date depatureDate, String travelClass) {
		
		this.flightNo = flightNo;
		this.depatureDate = depatureDate;
		this.travelClass = travelClass;
	}
	@Override
	public int hashCode() {
		return Objects.hash(depatureDate, flightNo, travelClass);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight_PK other = (Flight_PK) obj;
		return Objects.equals(depatureDate, other.depatureDate) && flightNo == other.flightNo
				&& Objects.equals(travelClass, other.travelClass);
	}
}
