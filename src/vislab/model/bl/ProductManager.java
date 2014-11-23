package vislab.model.bl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import vislab.model.db.Product;
import vislab.model.sf.HibernateUtil;

/**
 * class für ProduktObjekte
 */

public class ProductManager {

	public Product getProductByPrimaryKey(String primaryKey) {
		/* a Hibernate session */
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		Product product = (Product) session.get(Product.class, primaryKey);
		session.getTransaction().commit();
		return product;
	}
	
	public boolean existProductWithCategory(String category) {
		/* a Hibernate session */
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		List products = session.createCriteria(Product.class)
			    .add( Restrictions.like("category", category) )
			    .list();
		session.getTransaction().commit();
		return !(products == null || products.isEmpty());
	}

	public void deleteProduct(Product product) {
		/* a Hibernate session */
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		session.delete(product);
		session.getTransaction().commit();
	}

	public void saveProduct(Product product) {
		/* a Hibernate session */
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
	}
}
