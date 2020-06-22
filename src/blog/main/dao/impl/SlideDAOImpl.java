package blog.main.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import blog.main.dao.SlideDAO;
import blog.main.entity.Slide;

@Repository
@Transactional
public class SlideDAOImpl implements SlideDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Slide> getSlideList() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Slide> query = session.createQuery("from Slide", Slide.class);
		List<Slide> slideList = query.getResultList();
		 
		return slideList;
	}

	@Override
	public void saveSlide(Slide slade) {
		
		Session session = sessionFactory.getCurrentSession();	
		session.saveOrUpdate(slade);	
		
	}

	@Override
	public Slide getSlide(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Slide slide = session.get(Slide.class, id);
		
		return slide;
	}

	@Override
	public void deleteSlide(int id) {
		Session session = sessionFactory.getCurrentSession();
		Slide s = session.get(Slide.class, id);
		
		session.delete(s);
		
	}

	@Override
	public void disableSlide(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Slide slide = session.get(Slide.class, id);
		slide.setDisabled(true);
		session.saveOrUpdate(slide);	
		
	}

}
