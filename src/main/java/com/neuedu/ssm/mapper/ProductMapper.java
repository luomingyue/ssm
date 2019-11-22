package com.neuedu.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.ssm.pojo.Product;


@Repository
public interface ProductMapper {
	List<Product> findAll();
}
