package blog.main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.main.dao.BlogDAO;
import blog.main.dao.CategoryDAO;
import blog.main.dao.MessageDAO;
import blog.main.dao.SlideDAO;
import blog.main.dao.TagDAO;
import blog.main.entity.Message;

@Controller
@RequestMapping("/")
public class FrontController {
	
	@Autowired
	private SlideDAO slideDAO;
	
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private TagDAO tagDAO;
	

	@RequestMapping({"/","/index-page"})
	public String getIndexPage(Model model) {
		model.addAttribute("slideList", slideDAO.getSlideList());
		model.addAttribute("importantBlogs", blogDAO.get3MostRecentImportantPosts());
		model.addAttribute("latestBlogs", blogDAO.get12MostRecentBlogs(0));
		return "front/index-page";
	}
	
	
	@RequestMapping("/blog-page")
	public String getBlogPage(Model model, @RequestParam int page) {
		model.addAttribute("categories", categoryDAO.getCategoryList());
		model.addAttribute("tags", tagDAO.getTagList());
		model.addAttribute("mostViewedBlogs", blogDAO.getMostVisitedBlogs());
		model.addAttribute("latestBlogs", blogDAO.get12MostRecentBlogs(page));
		return "front/blog-page";
	}
	
	@RequestMapping("/contact-page")
	public String getContactPage(Model model) {
		model.addAttribute("message", new Message());
		return "front/contact-page";
	}
}