package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Trains {
	@Id
	int number;
	String name;
	int seats;
	String[]stations;
	String[]price;
	String[]days;
	String[]time;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String[] getStations() {
		return stations;
	}
	public void setStations(String[] stations) {
		this.stations = stations;
	}
	public String[] getPrice() {
		return price;
	}
	public void setPrice(String[] price) {
		this.price = price;
	}
	public String[] getDays() {
		return days;
	}
	public void setDays(String[] days) {
		this.days = days;
	}
	public String[] getTime() {
		return time;
	}
	public void setTime(String[] time) {
		this.time = time;
	}
	
	
	static Trains trains=new Trains();
	public static Trains getInstance(){
		return trains;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
