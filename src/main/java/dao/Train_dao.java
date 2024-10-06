package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import controller.BookTickets;
import dto.BookTicket;
import dto.Trains;


public class Train_dao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	static Train_dao dao=new Train_dao();
	public Train_dao(){
		
	}
	public static Train_dao getInstance(){
		return dao;
	}
	public String disp(String[]arr){
		String string="";
		for (int i = 0; i < arr.length; i++) {
			if(i==arr.length-1)
				string=string+arr[i];
			else
				string=string+arr[i]+",";
		}
		
		return string;
	}
	
	
	
	
	
	
	public void save(Trains trains) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.persist(trains);
		transaction.commit();
		
	}
	public List<Trains> fetchAll(){
		return manager.createQuery("select x from Trains x").getResultList();
	}
	public void deletetrain(int tnumber) {
		// TODO Auto-generated method stub
		Trains trains=manager.find(Trains.class,tnumber);
		transaction.begin();
		manager.remove(trains);
		transaction.commit();
	}
	public Trains fetch(int trainnumber){
		return manager.find(Trains.class, trainnumber);
	}
	public void update(Trains trains) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.merge(trains);
		transaction.commit();
	}
	public void save(BookTicket ticket) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.persist(ticket);
		transaction.commit();
		
	}
	public BookTicket fetchTicket(int pnr) {
		// TODO Auto-generated method stub
		return manager.find(BookTicket.class, pnr);
	}
	public void updateTicket(BookTicket tickets) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.merge(tickets);
		transaction.commit();
		
	}
}
