package blog.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.main.dao.MessageDAO;
import blog.main.entity.Message;

@Controller
@RequestMapping("/")
public class MessageController {
	
	@Autowired
	private MessageDAO messageDAO;
	
	@PostMapping("/send-email")
	public String saveMessage(@ModelAttribute("message") Message message) {
		
		messageDAO.saveMessage(message);
		
		return "front/contact-page";
	}

}
