package blog.main.dao;

import java.util.List;

import blog.main.entity.Slide;

public interface SlideDAO {
	
	public List<Slide> getSlideList();
	
	public void saveSlide(Slide slade);
	
	public Slide getSlide(int id);
	
	public void deleteSlide(int id);
	
	public void disableSlide(int id);

}
