package application.Model;

import Services.Oracle;
import application.Controller.ReserveTable;

public class Reservation {

	String Reservedfor;
	String Date;
	String Time;
	int ReservationID;
	ReserveTable t=new ReserveTable();
	Oracle oc=new Oracle();
	
	public Reservation(String reservedfor, String date, String time, int reservationID, ReserveTable tt) {
		super();
		Reservedfor = reservedfor;
		Date = date;
		Time = time;
		ReservationID = reservationID;
		t.setReserved(true);
		t.setTableid(tt.getTableid());
	}
	public String getReservedfor() {
		return Reservedfor;
	}
	public void setReservedfor(String reservedfor) {
		Reservedfor = reservedfor;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public int getReservationID() {
		return ReservationID;
	}
	public void setReservationID(int reservationID) {
		ReservationID = reservationID;
	}
	public ReserveTable getT() {
		return t;
	}
	public void setT(ReserveTable t) {
		this.t = t;
	}
	public void addReservedSeat() {
		oc.ReservedSeats(Reservedfor, Date, Time, Integer.toString(ReservationID), Integer.toString(t.getTableid()));
	}
	
}
