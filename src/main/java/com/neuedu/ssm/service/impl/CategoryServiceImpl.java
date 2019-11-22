package com.neuedu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.ssm.mapper.CategoryMapper;
import com.neuedu.ssm.pojo.Category;
import com.neuedu.ssm.pojo.CategoryBean;
import com.neuedu.ssm.service.CategoryService;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper mapper;
	public CategoryServiceImpl() {}
	public CategoryServiceImpl(CategoryMapper mapper) {
		this.mapper = mapper;
	}
	public CategoryMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(CategoryMapper mapper) {
		this.mapper = mapper;
	}
	public void insertRoot(String name, String descr) {
		mapper.insertRoot(new CategoryBean(name,descr));

	}

	public void insertChild(String name, String descr, int pid) {
		int grade = mapper.findParentGradeByPid(pid);
		mapper.insertChild(new Category(name,descr,pid,grade+1));
		mapper.updateParent(pid);
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> findToTree() {
		return mapper.findToTree();
	}

	public void delete(int id, int pid) {
		// TODO Auto-generated method stub

	}
	public void insertRoot(CategoryBean catbean) {
		// TODO Auto-generated method stub
		
	}
	public Category findById(int id) {
		
		return mapper.findById(id);
	}

}
