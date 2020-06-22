package blog.main.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import blog.main.dao.TagDAO;
import blog.main.entity.Blog;
import blog.main.entity.Tag;

@Repository
@Transactional
public class TagDAOImpl implements TagDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Transactional
	@Override
	public List<Tag> getTagList() { 
		
		Session session = sessionFactory.getCurrentSession();
		
        Query<Tag> query = session.createQuery("from Tag", Tag.class);
		 
	    List<Tag> tagList=query.getResultList();
				 
		return tagList;
	}

	@Transactional
	@Override
	public void saveTag(Tag tag) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(tag);
	}

	
	
	@Transactional
	@Override
	public Tag getTag(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Tag tag =session.get(Tag.class, id);
		
		return tag;
	}
	
	

	@Transactional
	@Override
	public void deleteTag(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Tag where id=:id");
		
		query.setParameter("id", id);
		query.executeUpdate();
		
		
		
	}

	@Transactional
	@Override
	public List<Tag> getTagsById(List<Integer> ids) {
		 
		Session session = sessionFactory.getCurrentSession();
		
		Query<Tag> query = session.createQuery("select t from Tag t where t.id IN (:ids) ");		
		query.setParameter("ids", ids);
		
		List<Tag > tags = query.getResultList();
		
		
		return tags;
	}

	@Override
	public Tag getTagWithBlogs(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Tag tag =session.get(Tag.class, id);
		
		Hibernate.initialize(tag.getBlogs());
		
		for(Blog blog : tag.getBlogs()) {
			Hibernate.initialize(blog.getComments());
		}
		
		return tag;
	}
	
	

}
