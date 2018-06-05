package com.abs.viewentity;

import java.util.List;

import com.abs.entity.Article;

public class IndexArticleView {

	private String categoryname;
	private Integer categoryid;
	private List<Article> articles;
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
