package com.abs.service;

import java.util.List;

public interface BaseService<T> {
	public int save(T t);
	public List<T> select(T t);
	public T selectOne(T t);
	public List<T> selectAll();
	public int update(T t);
	public int delete(T t);
}
