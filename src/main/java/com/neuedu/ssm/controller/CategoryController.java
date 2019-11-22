package com.neuedu.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ssm.pojo.Category;
import com.neuedu.ssm.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@RequestMapping(value = "/findToTree",method = RequestMethod.GET)
	@ResponseBody
	public List<Category> findToTree() {
		return service.findToTree();
	}
	@RequestMapping(value = "/insertChild")
	public String insertChild(HttpServletRequest request) {
		int pid = Integer.parseInt(request.getParameter("categoryParentId"));
		String name = request.getParameter("categoryName");
		String desc = request.getParameter("categoryDescription");
		service.insertChild(name, desc, pid);
		return "category-list.html";
	}
}
