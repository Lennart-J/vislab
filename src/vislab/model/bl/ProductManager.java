package vislab.model.bl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import vislab.model.db.Category;
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
			    .add( Restrictions.like("Category.name", category) )
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

	public List<Product> searchProduct(String name, String description,
			String category, String minPrice, String maxPrice) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class);
		addLikeRestriction(criteria, "name", name);
		addLikeRestriction(criteria, "description", "%"+description+"%");
		addLikeRestriction(criteria, "Category.name", category);
		addGtRestriction(criteria, "price", minPrice);
		addLtRestriction(criteria, "price", maxPrice);

		List<Product> products = criteria.list();
		session.getTransaction().commit();
		return products;
	}

	private void addLikeRestriction(Criteria criteria,
			String propertyName, Object value) {
		if (value != null && !value.equals("")) {
			criteria.add(Restrictions.like(propertyName, value));
		}
	}
	

	private void addGtRestriction(Criteria criteria,
			String propertyName, Object value) {
		if (value != null && !value.equals("")) {
			criteria.add(Restrictions.gt(propertyName, Double.parseDouble(value.toString())));
		}
	}

	private void addLtRestriction(Criteria criteria,
			String propertyName, Object value) {
		if (value != null && !value.equals("")) {
			criteria.add(Restrictions.lt(propertyName, Double.parseDouble(value.toString())));
		}
	}
}
