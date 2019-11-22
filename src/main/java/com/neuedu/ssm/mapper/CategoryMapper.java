package com.neuedu.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.ssm.pojo.Category;
import com.neuedu.ssm.pojo.CategoryBean;


@Repository
public interface CategoryMapper {
	void insertRoot(CategoryBean catbean);
	void insertChild(Category category);
	List<Category> findAll();
	List<Category> findToTree();
	void delete(int id,int pid);
	int findParentGradeByPid(int pid);
	void updateParent(int pid);
	Category findById(int id);
}
