package com.epam.training.javasecurity.mvc;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView list(HttpSession session) {
        Iterable<Message> messages = messageRepository.findAllToCurrentUser((User)session.getAttribute("currentUser"));
        return new ModelAndView("messages/inbox", "messages", messages);
    }
    

    @RequestMapping(value = "{id}", method=RequestMethod.GET)
    public ModelAndView view(@PathVariable Long id) {
        Message message = messageRepository.findOne(id);
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
    public String create(@Valid MessageForm messageForm, BindingResult result, RedirectAttributes redirect, HttpSession session) {
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
        User actualUser = (User)session.getAttribute("currentUser");
        message.setFrom(actualUser);
        message.setPriority(messageForm.getPriority());
        message = messageRepository.save(message);
        
        redirect.addFlashAttribute("globalMessage", "Message added successfully");
        return "redirect:/";
    }
}
