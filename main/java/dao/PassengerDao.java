package dao;

import java.util.List;

import model.Passenger;
import model.PassengerIDProof;

public interface PassengerDao {
	  public void savePassenger (Passenger passenger);
	    public List<Passenger> showAllPassengers();
	    public Passenger getPassenger(String emailId);
		public  void savePassengerIDProof(PassengerIDProof passengerIDProof);
		
}
