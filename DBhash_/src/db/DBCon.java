package db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class DBCon {

	public static void addUser(EntityManager manager, String user, String password) {
		User u=new User(user, BCrypt.hashpw(password, BCrypt.gensalt()));
		manager.getTransaction().begin();
		manager.persist(u);
		manager.getTransaction().commit();
	}

	public static boolean authorized(EntityManager manager, String user, String password) {
		Query query = manager.createNativeQuery("Select * FROM user;",User.class);
		List<User> result=query.getResultList();
		for(User u : result) 
			if(u.getUser().equals(user)) {
				return BCrypt.checkpw(password, u.getPassword());
			}
		return false;
	}
}
