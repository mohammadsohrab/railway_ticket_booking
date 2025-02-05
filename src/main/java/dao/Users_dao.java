package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Users;

public class Users_dao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	
	static Users_dao dao=new Users_dao();
	public static Users_dao getInstance(){
		return dao;
	}
	
	public void save(Users user) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}

	

	public Users find(int userId) {
		// TODO Auto-generated method stub
		return manager.find(Users.class,userId);
	}



	public void update(Users users) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.merge(users);
		transaction.commit();
		
	}

	
	
}
