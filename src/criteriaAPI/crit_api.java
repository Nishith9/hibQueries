package criteriaAPI;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import criteriaAPI.UserDetails;

public class crit_api {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*Deprecated
		  Criteria criteria = session.createCriteria(UserDetails.class);
		  List<UserDetails> users = criteria.list();
		 */
		
		// Create CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();
		  
		// Create CriteriaQuery		
		CriteriaQuery<UserDetails> criteria = builder.createQuery(UserDetails.class);		
		criteria.from(UserDetails.class);
		
		//Criterion ct1 = Restrictions.ge("userId",2);
		
		//criteria.add(ct1);
		
		
		List<UserDetails> users = session.createQuery(criteria).getResultList();
		session.getTransaction().commit();
		session.close();		
		
		//System.out.println("Size of list: " +users.size());
		
		for(UserDetails u: users)
			System.out.println(u.getUserName());

	}

}
