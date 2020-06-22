package blog.main.dao;

import java.util.List;

import blog.main.entity.Tag;

public interface TagDAO {
	
	public List<Tag> getTagList();
	
	public void saveTag(Tag tag);
	
	public Tag getTag(int id);
	
	public Tag getTagWithBlogs(int id);
	
	public void deleteTag(int id);
	
	public List<Tag> getTagsById(List<Integer>ids);
	

}
