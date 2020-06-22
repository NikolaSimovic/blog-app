package blog.main.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import blog.main.dao.BlogDAO;
import blog.main.entity.Blog;
import blog.main.entity.Category;
import blog.main.entity.Tag;
import blog.main.entity.User;

@Repository
@Transactional
public class BlogDAOImpl implements BlogDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Blog> getBlogList() {

		Session session = sessionFactory.getCurrentSession();
		Query<Blog> query = session.createQuery("from Blog", Blog.class);
		List<Blog> blogList = query.getResultList();
		for(Blog blog : blogList) {
			Hibernate.initialize(blog.getComments());
		}
		
		 
		return blogList;
	}

	@Transactional
	@Override
	public void saveBlog(Blog blog) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(blog);
		
	}

	@Transactional
	@Override
	public Blog getBlog(int id) {
		
		Session session = sessionFactory.getCurrentSession(); 
		Blog blog = session.get(Blog.class, id);
		Hibernate.initialize(blog.getTags());
		Hibernate.initialize(blog.getComments());
		
		return blog;
	}

	@Transactional
	@Override
	public void deleteBlog(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Blog p = session.get(Blog.class, id);
		
		session.delete(p);
	}

	@Override
	public List<Blog> searchBlog(String searchTerm) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Blog> query = session.createQuery("select b from Blog b where b.title like :searchTerm OR b.description like :searchTerm OR b.body like :searchTerm");
		query.setParameter("searchTerm", "%"+searchTerm+"%");
		List<Blog> blogs = query.getResultList();
		for(Blog blog : blogs) {
			Hibernate.initialize(blog.getComments());
		}
		
		return blogs;
	}

	@Override
	public List<Blog> getMostVisitedBlogs() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Blog> query = session.createQuery("select b from Blog b where b.date >= current_date() -30 ORDER BY b.views DESC");
		query.setMaxResults(3);
		List<Blog> blogs = query.getResultList();
		for(Blog blog : blogs) {
			Hibernate.initialize(blog.getComments());
		}
		
		return blogs;
	}

	@Override
	public List<Blog> getBlogsWithCategory(Category category) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Blog> query = session.createQuery("select b from Blog b where b.category = :category");
		query.setParameter("category", category);
		List<Blog> blogs = query.getResultList();
		for(Blog blog : blogs) {
			Hibernate.initialize(blog.getComments());
		}
		
		return blogs;
	}

	@Override
	public List<Blog> get3MostRecentImportantPosts() {
		Session session = sessionFactory.getCurrentSession();
		Query<Blog> query = session.createQuery("select b from Blog b where b.important = 1 ORDER BY b.date DESC");
		query.setMaxResults(3);
		List<Blog> blogs = query.getResultList();
		for(Blog blog : blogs) {
			Hibernate.initialize(blog.getComments());
		}
		
		return blogs;
	}

	@Override
	public List<Blog> get12MostRecentBlogs(int page) {
		Session session = sessionFactory.getCurrentSession();
		Query<Blog> query = session.createQuery("select b from Blog b ORDER BY b.date DESC");
		query.setFirstResult(page*4);
		query.setMaxResults(4);
		List<Blog> blogs = query.getResultList();
		for(Blog blog : blogs) {
			Hibernate.initialize(blog.getComments());
		}
		
		return blogs;
	}

	@Override
	public void increaseViews(Blog blog) {
		Session session = sessionFactory.getCurrentSession();
		int views = blog.getViews();
		Query query = session.createQuery("update Blog set views = :views where id = :blogId");
		query.setParameter("views", ++views);
		query.setParameter("blogId", blog.getId());
		query.executeUpdate();
		
	}

	@Override
	public List<Blog> getBlogsForUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		Query<Blog> query = session.createQuery("select b from Blog b where b.user = :user");
		query.setParameter("user", user);
		List<Blog> blogs = query.getResultList();
		for(Blog blog : blogs) {
			Hibernate.initialize(blog.getComments());
		}
		
		return blogs;
	}
	

}
