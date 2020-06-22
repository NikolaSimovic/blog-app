package blog.main.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.dao.UserDAO;
import blog.main.entity.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUserList() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User", User.class);
		List<User> userList = query.getResultList();
		 
		return userList;
	}

	@Override
	public void saveUser(User user) {
		
		Session session = sessionFactory.getCurrentSession();	
		session.saveOrUpdate(user);	
		
	}

	@Override
	public void updateUser(User user) {
		
		Session session = sessionFactory.getCurrentSession();	
		session.saveOrUpdate(user);	
		
	}

	@Override
	public User getUser(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User u = session.get(User.class, id);
		
		session.delete(u);
		
	}
 
	@Override
	public void disableUser(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		user.setDisabled(true);
		session.saveOrUpdate(user);	
		
	}

}
