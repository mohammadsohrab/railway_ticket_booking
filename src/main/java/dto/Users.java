package dto;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.Data;
@Entity
@Data
public class Users{
	@Id
	@GeneratedValue(generator="x")
	@SequenceGenerator(name="x",sequenceName="x",initialValue=1276453,allocationSize=1)
	int id;
	String first_name;
	String last_name;
	String password;
	long mobile;
	String mail;
	Date dob;
	String gender;
	@OneToMany
	List<BookTicket> tickets;
	public List<BookTicket> getTickets() {
		return tickets;
	}
	public void setTickets(List<BookTicket> tickets) {
		this.tickets = tickets;
	}
	public static Users getUsers() {
		return users;
	}
	public static void setUsers(Users users) {
		Users.users = users;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	int age;
	double wallet;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	
	static Users users=new Users();
	public static Users getInstance(){
		return users;
	}
	
}
