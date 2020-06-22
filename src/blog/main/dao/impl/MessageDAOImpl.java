package blog.main.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.dao.MessageDAO;
import blog.main.entity.Message;

@Repository
@Transactional
public class MessageDAOImpl implements MessageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Message> getMessageList() {
		Session session = sessionFactory.getCurrentSession();
		Query<Message> query = session.createQuery("from Message", Message.class);
		List<Message> messageList = query.getResultList();
		 
		return messageList;
	}

	@Override
	@Transactional
	public void saveMessage(Message message) {
		
		Session session = sessionFactory.getCurrentSession();	
		session.save(message);	
		
	}

	@Override
	public Message getMessage(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Message message = session.get(Message.class, id);
		
		return message;
	}

	@Override
	@Transactional
	public void deleteMessage(int id) {
		Session session = sessionFactory.getCurrentSession();
		Message m = session.get(Message.class, id);
		
		session.delete(m);
		
	}

}
