package com.abs.dao;

import java.util.List;

import com.abs.entity.Article;
import com.abs.viewentity.IndexArticleView;

import tk.mybatis.mapper.common.Mapper;

public interface ArticleMapper extends Mapper<Article> {
	public List<Article> selectIndexArticleByType(int type);
	public List<Article> getPage(int cid, int offset, int size);
	public int getPageCount(int cid);
}