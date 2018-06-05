package com.abs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abs.dao.CategoryMapper;
import com.abs.entity.Category;
import com.abs.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
	@Override
	public Category getCategoryById(int cid) {
		return categoryMapper.getCategoryById(cid);
	}

}
