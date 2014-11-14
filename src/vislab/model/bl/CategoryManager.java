package vislab.model.bl;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

import vislab.model.db.Category;
import vislab.model.sf.HibernateUtil;

/**
   class für BenutzerObjekte

*/


public class CategoryManager {

  public Category getCategoryByPrimaryKey(int primaryKey) {
    /* a Hibernate session */
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    session.beginTransaction();
    Category category = (Category) session.get(Category.class, primaryKey);
    session.getTransaction().commit();
    return category;
  }
  
  public boolean isCategoryInTable(String name) {
	    /* a Hibernate session */
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    session.beginTransaction();
	    Query query = session.createQuery("from Category where NAME= :name");
	    query.setParameter("name", name);
	    List result = query.list();
	  
	    session.getTransaction().commit();
	    return !(result.isEmpty());
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
        session.getTransaction().commit();}


    }  



