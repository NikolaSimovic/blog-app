package blog.main.dao.impl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.dao.CategoryDAO;
import blog.main.entity.Category;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;//automatski uzima session i spring servlet a
	
	@Transactional
	@Override
	public List<Category> getCategoryList() {
		
		 Session session = sessionFactory.getCurrentSession();
		 Query<Category> query = session.createQuery("from Category", Category.class);
		 List<Category> categoryList = query.getResultList();
		
		return categoryList;
	}
     
	@Transactional
	@Override
	public void saveCategory(Category category) {
		
		Session session = sessionFactory.getCurrentSession();	
		session.saveOrUpdate(category);	
		
	}

	@Transactional
	@Override
	public Category getCategory(int id) {
		 
		Session session = sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id);
		
		return category;
	}

	@Transactional
	@Override
	public void deleteCategory(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Category where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}
	
	
	

}
