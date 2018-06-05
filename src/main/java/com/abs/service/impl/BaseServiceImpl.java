package com.abs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.abs.service.BaseService;

import tk.mybatis.mapper.common.Mapper;

public class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
    private Mapper<T> mapper;
    
    public int save(T t) {
    	return mapper.insertSelective(t);
    }
    public List<T> select(T t) {
    	return mapper.select(t);
    }
    public List<T> selectAll() {
    	return mapper.selectAll();
    }
    public T selectOne(T t) {
    	return mapper.selectOne(t);
    }
    public int update(T t) {
    	return mapper.updateByPrimaryKeySelective(t);
    }
    public int delete(T t) {
    	return mapper.deleteByPrimaryKey(t);
    }
}
