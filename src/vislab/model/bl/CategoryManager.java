package vislab.model.bl;

import org.hibernate.Session;

import vislab.model.db.Category;
import vislab.model.sf.HibernateUtil;

/**
 * class für BenutzerObjekte
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
}
