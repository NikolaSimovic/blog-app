package blog.main.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.dao.CommentDAO;
import blog.main.entity.Comment;

@Repository
@Transactional
public class CommentDAOImpl implements CommentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Comment> getCommentList() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Comment> query = session.createQuery("from Comment", Comment.class);
		List<Comment> commentList = query.getResultList();
		 
		return commentList;
	}

	@Override
	public List<Comment> getCommentsForBlog(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Comment> query = session.createQuery("select c from Comments where b.idBlog = :id ORDER BY c.id DESC");
		query.setParameter("id", id);
		List<Comment> comments = query.getResultList();
		
		return comments;
	}

	@Override
	public void saveComment(Comment comment) {
		
		Session session = sessionFactory.getCurrentSession();	
		session.save(comment);	
		
	}

	@Override
	public Comment getComment(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Comment comment = session.get(Comment.class, id);
		
		return comment;
	}

	@Override
	public void deleteComment(int id) {
		Session session = sessionFactory.getCurrentSession();
		Comment c = session.get(Comment.class, id);
		
		session.delete(c);
		
	}

	@Override
	public void disableComment(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Comment comment = session.get(Comment.class, id);
		comment.setDisabled(true);
		session.saveOrUpdate(comment);	
		
	}
	

}
