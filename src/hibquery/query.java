package hibquery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class query {
public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Query query = session.createQuery("from UserDetails where userid>2");
		
		/**Pagination**/
		Query query = session.createQuery("from UserDetails");
		query.setFirstResult(2); //starts from 3rd record
		//query.setMaxResults(2); 
		
		//List users = query.list();
		List<UserDetails> users = (List<UserDetails>) query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of list: " +users.size());
		
		/**SELECT**/
		for(UserDetails u: users)
			System.out.println(u.getUserName());
		
		
	}
}
