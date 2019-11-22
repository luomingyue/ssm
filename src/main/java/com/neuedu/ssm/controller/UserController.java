package com.neuedu.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ssm.pojo.User;
import com.neuedu.ssm.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/listuser",method = RequestMethod.GET)
	@ResponseBody
	public List<User> list() {
		return service.findAll();
	}
	@RequestMapping(value = "/updateMember")
	public String updateMember(HttpServletRequest req) {
		User user = new User();
		user.setId(Integer.parseInt(req.getParameter("id")));
		user.setUserName(req.getParameter("username"));
		user.setUserPassword(req.getParameter("password"));
		user.setUserPhone(req.getParameter("phone"));
		user.setAddr(req.getParameter("addr"));
		service.update(user);
		return "redirect:member-list.html";
	}
	@RequestMapping(value = "/addMember")
	public String addMember(HttpServletRequest req) {
		User user = new User();
		user.setUserName(req.getParameter("username"));
		user.setUserPassword(req.getParameter("password"));
		user.setUserPhone(req.getParameter("phone"));
		user.setAddr(req.getParameter("addr"));
		service.add(user);
		return "redirect:member-list.html";
	}
	@RequestMapping(value = "/deleteMember")
	public String deleteMember(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		service.delete(id);
		return "redirect:member-list.html";
	}
}
