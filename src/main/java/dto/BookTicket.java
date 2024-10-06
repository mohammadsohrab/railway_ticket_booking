package dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



import lombok.Data;
@Entity
@Data
public class BookTicket {
	@Id
	@GeneratedValue(generator = "pnr")
	@SequenceGenerator(initialValue = 4566541,allocationSize = 1,name = "pnr",sequenceName = "pnr")
	int pnr;
	int trainNumber;
	String source;
	String destination;
	int numberOfSeats;
	double amount;
	Date dateOfBooking;
	Date dateOfJourney;
	String status;
	String trainname;
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}
	@ManyToOne
	Users users;
	static BookTicket ticket;
	public static BookTicket getInstance(){
		return ticket;
	}
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public Date getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public static BookTicket getTicket() {
		return ticket;
	}
	public static void setTicket(BookTicket ticket) {
		BookTicket.ticket = ticket;
	}

}
