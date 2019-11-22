package com.neuedu.ssm.service;

import java.util.List;

import com.neuedu.ssm.pojo.Category;
import com.neuedu.ssm.pojo.CategoryBean;

public interface CategoryService {
	void insertRoot(CategoryBean catbean);
	void insertChild(String name,String descr,int pid);
	List<Category> findAll();
	List<Category> findToTree();
	void delete(int id,int pid);
	Category findById(int id);
}
