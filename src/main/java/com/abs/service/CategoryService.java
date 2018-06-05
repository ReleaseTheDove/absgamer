package com.abs.service;

import com.abs.entity.Category;

public interface CategoryService extends BaseService<Category>{
    public Category getCategoryById(int cid);
}
