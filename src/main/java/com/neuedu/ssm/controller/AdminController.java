package com.neuedu.ssm.controller;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ssm.pojo.Admin;
import com.neuedu.ssm.service.AdminService;
@Controller
public class AdminController {
	@Autowired
	private AdminService service;
	
	@RequestMapping(value = "/listadmin",method = RequestMethod.GET)
	@ResponseBody
	public List<Admin> listadmin() {
		return service.findAll();
	}
	@RequestMapping(value = "/updateadmin",method = RequestMethod.GET)
	public String updateadmin(HttpServletRequest req) throws Exception {
		Admin user = new Admin();
		user.setId(Integer.parseInt(req.getParameter("id")));
		user.setAname(req.getParameter("aname"));
		user.setApwd(req.getParameter("apwd"));
		service.update(user);
//		response.sendRedirect("admin-list.html");
		return "redirect:admin-list.html";
	}
	@RequestMapping(value = "/addadmin")
	public String addadmin(HttpServletRequest req) {
		Admin user = new Admin();
		user.setAname(req.getParameter("aname"));
		user.setApwd(req.getParameter("apwd"));
		service.add(user);
		return "redirect:admin-list.html";
	}
	@RequestMapping(value = "/deleteAdmin")
	public String deleteAdmin(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		service.delete(id);
		return "redirect:admin-list.html";
	}
	@RequestMapping(value = "/login")
	@ResponseBody
	public Admin login(HttpServletRequest req) {
		String adminName = req.getParameter("adminName");
		String adminPassword = req.getParameter("adminPassword");
		return service.login(adminName, adminPassword);
	}
	@RequestMapping(value = "/checkName")
	@ResponseBody
	public String checkName(HttpServletRequest req) throws UnsupportedEncodingException {
		String adminName = req.getParameter("adminName");
		Admin admin = service.findByName(adminName);
		if(admin != null) {
			return URLEncoder.encode("不能注册","utf-8");
		}else {
			return URLEncoder.encode("可以注册","utf-8");
		}
	}
	@RequestMapping(value = "/register")
	public String register(HttpServletRequest req) {
		String adminName = req.getParameter("adminName");
		String adminPassword = req.getParameter("adminPassword");
		Admin admin = new Admin();
		admin.setAname(adminName);
		admin.setApwd(adminPassword);
		service.add(admin);
		return "index.html";
	}
	
}
