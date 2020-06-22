package blog.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.main.dao.BlogDAO;
import blog.main.dao.CategoryDAO;
import blog.main.dao.CommentDAO;
import blog.main.dao.MessageDAO;
import blog.main.dao.TagDAO;
import blog.main.entity.Blog;
import blog.main.entity.Comment;
import blog.main.entity.Message;

@Controller
@RequestMapping("/")
public class CommentController {
	
	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private BlogDAO blogDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private TagDAO tagDAO;
	
	@PostMapping("/save-comment")
	public String saveMessage(@ModelAttribute("comment") Comment comment, @RequestParam int id, Model model) {
		
		comment.setIdBlog(id);
		
		commentDAO.saveComment(comment);
		
		model.addAttribute("latestBlogs", blogDAO.get12MostRecentBlogs(0));
		model.addAttribute("categories", categoryDAO.getCategoryList());
		model.addAttribute("tags", tagDAO.getTagList());
		model.addAttribute("mostViewedBlogs", blogDAO.getMostVisitedBlogs());
		
		return "front/blog-page";
	}

}
