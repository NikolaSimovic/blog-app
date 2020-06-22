package blog.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagData;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.main.dao.BlogDAO;
import blog.main.dao.CategoryDAO;
import blog.main.dao.MessageDAO;
import blog.main.dao.SlideDAO;
import blog.main.dao.TagDAO;
import blog.main.entity.Category;
import blog.main.entity.Message;
import blog.main.entity.Slide;
import blog.main.entity.Blog;
import blog.main.entity.Tag;

@Controller
@RequestMapping("/administration")
public class AdministrationController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private TagDAO tagDAO;
	
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private SlideDAO slideDAO;

	
	@RequestMapping("/slide-list")
	public String getSlideList(Model model) {
		
		List<Slide> list = slideDAO.getSlideList();
		
		model.addAttribute("slideList", list);
		
		return "slide-list";
	}
  
	@RequestMapping("/blog-list")
	public String getBlogList(Model model) {
		
		List<Blog> list = blogDAO.getBlogList();
		
		model.addAttribute("blogList", list);
		
		return "blog-list";
	}

	@RequestMapping("/blog-form")
	public String getBlogForm(Model model) {
	
		Blog blog = new Blog();
		
		List<Category> categoryList = categoryDAO.getCategoryList();
		
		List<Tag> taqList = tagDAO.getTagList();
		
		model.addAttribute("blog", blog);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("tagList", taqList);
		return "blog-form";
	}
	
	@RequestMapping("/blog-save")
	public String saveBlog(@Valid @ModelAttribute Blog blog , BindingResult result , Model model) {
		
		if (result.hasErrors()) {
			
			List<Category> categoryList = categoryDAO.getCategoryList();
			
			List<Tag> tagList = tagDAO.getTagList();
			
			
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("tagList", tagList);
			
		
			return "blog-form";
		}
		
		Category category = categoryDAO.getCategory(blog.getCategory().getId());
		
		List<Integer> ids = new ArrayList<Integer>();
		
		for (Tag taq : blog.getTags()) {
			
			ids.add(Integer.parseInt(taq.getName()));
			
		}
		
		
		
		List<Tag> tags = tagDAO.getTagsById(ids);
		
		blog.setCategory(category);
		blog.setTags(tags);
		blogDAO.saveBlog(blog);
		
		return "redirect:/administration/blog-list";
	}
	

	@RequestMapping("/blog-form-update")
	public String getBlogUpdateForm(@RequestParam int id, Model model) {
		
		Blog blog  = blogDAO.getBlog(id);
		model.addAttribute("blog" , blog);
		
		List<Category> categoryList = categoryDAO.getCategoryList();
		List<Tag> tagList = tagDAO.getTagList();
	
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("tag", tagList);
		
		return "blog-form";
	}
	
	 
	
	@RequestMapping("/blog-delete")
	public String deleteProduct(@RequestParam int id ) {
		
		 blogDAO.deleteBlog(id);
		 
		 return "redirect:/administration/blog-list";
	}

	//Category!!!!!!!!!!!!!!!!!!!!!!!!
	
	@RequestMapping("/category-list")
	public String getCategoryList (Model model) {
		
        
		System.out.println("Category list method");
		
		List<Category> list = categoryDAO.getCategoryList();
		
		System.out.println(list.toString());
		
		model.addAttribute("categoryList", list); 
		
		return "category-list";
		
	}
	
	@RequestMapping("/category-form")
	public String getCategoryForm(Model model) {
		
		Category category = new Category();//kreir objekat
		
		model.addAttribute("category" , category);
		
		return "category-form";
		
	}
	
	@RequestMapping("/category-form-update")
	public String getCategoryUpdateForm(@RequestParam int id, Model model) {
		
		Category category = categoryDAO.getCategory(id);
		model.addAttribute("category" , category);
		
		return "category-form";
	}
	
	
	@RequestMapping("/category-save")
	public String saveCategory(@Valid  @ModelAttribute Category category , BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "category-form ";
		}
		 
		categoryDAO.saveCategory(category);
		return "redirect:/administration/category-list";
	}
	
	@RequestMapping("/category-delete")
	public String deleteCategory(@RequestParam int id) {
		
		categoryDAO.deleteCategory(id);
		
		return "redirect:/administration/category-list";
	}
	
	//taq!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	@RequestMapping("/tag-list")
	public String getTagList(Model model) {
		
		List<Tag> tagList = tagDAO.getTagList();
		
		model.addAttribute("tagList", tagList);
		
		return "tag-list";
	}
	
	@RequestMapping("/tag-form")
	public String getTaqForm(Model model) {
		
		Tag tag= new Tag();
		
		model.addAttribute("tag", tag);
		
		return "tag-form";
	}
	
	
	@RequestMapping("/tag-save")
	public String saveTaq(@Valid @ModelAttribute Tag tag , BindingResult result) {
		
		if (result.hasErrors()) {
		
			return "tag-form";
		}
		
		tagDAO.saveTag(tag);
		
		return "redirect:/administration/tag-list";
	}
	
	
	@RequestMapping("/tag-delete")
	public String deleteTaq(@RequestParam int id) {
		
		tagDAO.deleteTag(id);
		
		return "redirect:/administration/tag-list";
	}
	
	@RequestMapping("/tag-form-update")
	public String getTaqUpdateForm(@RequestParam int id, Model model) {
		
		Tag tag = tagDAO.getTag(id);
		model.addAttribute("tag" , tag);
		
		return "tag-form";
	}
	
	
}
