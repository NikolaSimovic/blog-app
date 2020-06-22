package blog.main;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.main.dao.BlogDAO;
import blog.main.dao.CategoryDAO;
import blog.main.dao.MessageDAO;
import blog.main.dao.TagDAO;
import blog.main.dao.UserDAO;
import blog.main.entity.Blog;
import blog.main.entity.Category;
import blog.main.entity.Comment;
import blog.main.entity.Message;
import blog.main.entity.Tag;
import blog.main.entity.User;

@Controller
@RequestMapping("/")
public class BlogController {
	
	@Autowired
	private BlogDAO blogDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private TagDAO tagDAO;
	
	@RequestMapping("/blog-post")
	public String getBlogPost(@RequestParam int id,Model model) {
		
		model.addAttribute("categories", categoryDAO.getCategoryList());
		model.addAttribute("tags", tagDAO.getTagList());
		model.addAttribute("mostViewedBlogs", blogDAO.getMostVisitedBlogs());
		
		Blog b = blogDAO.getBlog(id);
		
		blogDAO.increaseViews(b);
		
		
		model.addAttribute("blog", b);
		model.addAttribute("comment", new Comment());
		
		//model.addAttribute("related", productDAO.getProductListByCategory(p.getCategory().getId()));
		
		return "front/blog-post";
	}
	
	@RequestMapping("/blog-author")
	public String getBlogsFromAuthor(@RequestParam int id,Model model) {
		
		User user = userDAO.getUser(id);
		
		model.addAttribute("categories", categoryDAO.getCategoryList());
		model.addAttribute("tags", tagDAO.getTagList());
		model.addAttribute("mostViewedBlogs", blogDAO.getMostVisitedBlogs());
	
		model.addAttribute("user", user);
		model.addAttribute("userBlogs", blogDAO.getBlogsForUser(user));
		
		return "front/blog-author";
	}
	
	@RequestMapping("/blog-category")
	public String getBlogsForCategory(@RequestParam int id,Model model) {
		
		model.addAttribute("categories", categoryDAO.getCategoryList());
		model.addAttribute("tags", tagDAO.getTagList());
		model.addAttribute("mostViewedBlogs", blogDAO.getMostVisitedBlogs());
		
		Category category = categoryDAO.getCategory(id);
	
		model.addAttribute("category", category);
		model.addAttribute("blogs", blogDAO.getBlogsWithCategory(category));
		
		return "front/blog-category";
	}
	
	@RequestMapping("/blog-tag")
	public String getBlogsForTag(@RequestParam int id,Model model) {
		
		model.addAttribute("categories", categoryDAO.getCategoryList());
		model.addAttribute("tags", tagDAO.getTagList());
		model.addAttribute("mostViewedBlogs", blogDAO.getMostVisitedBlogs());
		
		Tag tag = tagDAO.getTagWithBlogs(id);
		
	
		model.addAttribute("tag", tag);
		model.addAttribute("blogs", tag.getBlogs());
		
		return "front/blog-tag";
	}
	
	@RequestMapping("/blog-search")
	public String getBlogsForSearchTRerm(@RequestParam String searchTerm,Model model) {
		
		model.addAttribute("categories", categoryDAO.getCategoryList());
		model.addAttribute("tags", tagDAO.getTagList());
		model.addAttribute("mostViewedBlogs", blogDAO.getMostVisitedBlogs());
		
		List<Blog> blogs = blogDAO.searchBlog(searchTerm);
		
	
		model.addAttribute("searchTerm", searchTerm);
		model.addAttribute("blogs", blogs);
		
		return "front/blog-search";
	}

}
