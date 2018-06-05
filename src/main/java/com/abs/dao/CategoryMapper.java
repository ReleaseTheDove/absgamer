package com.abs.dao;

import com.abs.entity.Category;
import tk.mybatis.mapper.common.Mapper;

public interface CategoryMapper extends Mapper<Category> {
	public Category getCategoryById(int cid);
}