package blog.main.dao;

import java.util.List;

import blog.main.entity.Blog;
import blog.main.entity.Category;
import blog.main.entity.Tag;
import blog.main.entity.User;

public interface BlogDAO {

	public List<Blog> getBlogList();
	
	public void saveBlog(Blog blog);
	
	public Blog getBlog(int id);
	
	public List<Blog> searchBlog(String searchTerm);
	
	public List<Blog> getMostVisitedBlogs();
	
	public List<Blog> getBlogsWithCategory(Category category);
	
	public List<Blog> get3MostRecentImportantPosts();
	
	public List<Blog> get12MostRecentBlogs(int page);
	
	public List<Blog> getBlogsForUser(User user);
	
	public void increaseViews(Blog blog);
	
	public void deleteBlog(int id);
	
}
