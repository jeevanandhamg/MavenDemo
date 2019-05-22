package com.cognizant.message.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.message.model.MessageDetails;
import com.cognizant.message.model.UserDetails;
import com.cognizant.message.service.IMessage;

@Controller
public class MessageController {

	public MessageController() {
		// TODO Auto-generated constructor stub
	}

	@Resource(name = "messageService")
	IMessage messageService;

	//Integer  id;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String uname, String pass, HttpServletRequest request) {
		UserDetails ud = new UserDetails();
		ud.setPass(pass);
		ud.setUname(uname);
		// LoginService service2=LoginService.getLoginService();

		String s = null;

		int dblogin = messageService.connect(ud);
		ud.setId(dblogin);
		if (dblogin != 0) {

			//id = dblogin;
			 HttpSession session=request.getSession(); 
			   session.setAttribute("id",dblogin);
			  // id=(Integer) session.getAttribute("id");
			s = "redirect:/app/login3";

		}
		System.out.println("ud :" + ud);
		return s;
	}

	@RequestMapping(value = "/login3", method = RequestMethod.GET)
	public ModelAndView login3(HttpServletRequest request,HttpSession session) {
		// int uid=ud.getId();
		// request.setAttribute("userid","1");
	   
		// id = (Integer) session.getAttribute("userid");
		System.out.println("id :" + (Integer) session.getAttribute("id"));
		List<UserDetails> li = messageService.getUserDetails((Integer) session.getAttribute("id"));
		ModelAndView modelAndView = new ModelAndView("Message");
		System.out.println("List :" + li);
		modelAndView.addObject("userList", li);

		return modelAndView;

	}

	//Integer toid;

	@RequestMapping(value = "/msg", method = RequestMethod.POST)
	public ModelAndView msg(int toid,HttpSession session) {
		session.setAttribute("toid", toid);
		System.out.println((Integer) session.getAttribute("id"));
		List<MessageDetails> md = messageService.getMessages((Integer) session.getAttribute("id"), (Integer)session.getAttribute("toid"));
		ModelAndView modelAndView = new ModelAndView("Send");
		System.out.println(md);
		modelAndView.addObject("messageList", md);
		modelAndView.addObject("fid", (Integer) session.getAttribute("id"));
		modelAndView.addObject("tid", (Integer)session.getAttribute("toid"));
		return modelAndView;
	}

	@RequestMapping(value = "/sending", method = RequestMethod.POST)
	public  String sending(MessageDetails md, String msg,HttpSession session){
		
		messageService.sendMessage(md, (Integer) session.getAttribute("id"), (Integer)session.getAttribute("toid"), msg);
		String s = "redirect:/app/send";
		return s;
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public ModelAndView send(MessageDetails md, String msg,HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("Send");
		//messageService.sendMessage(md, (Integer) session.getAttribute("id"), (Integer)session.getAttribute("toid"), msg);
		List<MessageDetails> li = messageService.getMessages((Integer) session.getAttribute("id"),(Integer)session.getAttribute("toid"));
		modelAndView.addObject("messageList", li);
		modelAndView.addObject("fid", (Integer) session.getAttribute("id"));
		modelAndView.addObject("tid",(Integer)session.getAttribute("toid"));
		return modelAndView;
	}

}
