package com.epam.training.javasecurity.mvc;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.training.javasecurity.data.Message;
import com.epam.training.javasecurity.data.MessageRepository;
import com.epam.training.javasecurity.data.User;
import com.epam.training.javasecurity.data.UserRepository;
import com.epam.training.javasecurity.security.CurrentUser;
import com.epam.training.javasecurity.security.CustomUserDetails;

@Controller
@RequestMapping("/")
public class MessageController {
    private MessageRepository messageRepository;
    private UserRepository userRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView list() {
        Iterable<Message> messages = messageRepository.findAllToCurrentUser();
        return new ModelAndView("messages/inbox", "messages", messages);
    }

	private User findActualUser(CustomUserDetails currentUser) {		
        User user = userRepository.findByEmail(currentUser.getUsername());
		return user;	
	}
    

    @RequestMapping(value = "{id}", method=RequestMethod.GET)
    public ModelAndView view(@PathVariable Long id, @CurrentUser CustomUserDetails currentUser) {
        Message message = messageRepository.findOne(id);
        if (message.getTo().getId() != currentUser.getId()) {
        	throw new AccessDeniedException("Access denied");
        }
        return new ModelAndView("messages/show", "message", message);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Message message, RedirectAttributes redirect) {
        messageRepository.delete(message);
        redirect.addFlashAttribute("globalMessage", "Message removed successfully");
        return "redirect:/";
    }

    @RequestMapping(params="form", method=RequestMethod.GET)
    public String createForm(@ModelAttribute MessageForm messageForm) {
        return "messages/compose";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String create(@Valid MessageForm messageForm, BindingResult result, RedirectAttributes redirect, HttpSession session, 
    		@CurrentUser CustomUserDetails currentUser) {
        User to = userRepository.findByEmail(messageForm.getToEmail());
        if(to == null) {
            result.rejectValue("toEmail", "toEmail", "User not found");
        }
        if(result.hasErrors()) {
            return "messages/compose";
        }

        Message message = new Message();
        message.setSummary(messageForm.getSummary());
        message.setText(messageForm.getText());
        message.setTo(to);
        message.setFrom(findActualUser(currentUser));
        message.setPriority(messageForm.getPriority());
        message = messageRepository.save(message);
        
        redirect.addFlashAttribute("globalMessage", "Message added successfully");
        return "redirect:/";
    }
}
