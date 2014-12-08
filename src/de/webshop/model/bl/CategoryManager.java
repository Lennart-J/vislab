package de.webshop.model.bl;

import java.util.List;

import org.hibernate.Session;

import de.webshop.model.db.Category;
import de.webshop.model.sf.HibernateUtil;

/**
 * class für KategorieObjekte
 */

public class CategoryManager {

	public Category getCategoryByPrimaryKey(String primaryKey) {
		/* a Hibernate session */
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		Category category = (Category) session.get(Category.class, primaryKey);
		session.getTransaction().commit();
		return category;
	}

	public void deleteCategory(Category category) {
		/* a Hibernate session */
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		session.delete(category);
		session.getTransaction().commit();
	}

	public void saveCategory(Category category) {
		/* a Hibernate session */
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
	}
	
	public List<Category> getAllCategories() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Category> categories = session.createCriteria(Category.class).list();
		session.getTransaction().commit();
		return categories;	
	}
}
