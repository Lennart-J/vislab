package vislab.model.bl;

import org.hibernate.Session;

import vislab.model.db.Customer;
import vislab.model.sf.HibernateUtil;

/**
 * class für BenutzerObjekte
 */

public class CustomerManager {

	public Customer getCustomerByPrimaryKey(String primaryKey) {
		/* a Hibernate session */
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, primaryKey);
		session.getTransaction().commit();
		return customer;
	}

	public void saveCustomer(Customer customer) {
		/* a Hibernate session */
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
	}

}
