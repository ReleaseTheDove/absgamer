package com.abs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abs.dao.ArticleMapper;
import com.abs.entity.Article;
import com.abs.entity.Category;
import com.abs.service.ArticleService;
import com.abs.service.CategoryService;
import com.abs.viewentity.IndexArticleView;

@Service("articleService")
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
	private CategoryService categoryService;
    
	@Override
	public List<IndexArticleView> getIndexArticles() {
		List<Category> catetegoryList = categoryService.selectAll();
		List<IndexArticleView> viewList = new ArrayList<IndexArticleView>(); 
		IndexArticleView view = null;
		for(Category category : catetegoryList) {
			view = new IndexArticleView();
			view.setCategoryid(category.getId());
			view.setCategoryname(category.getName());
			view.setArticles(articleMapper.selectIndexArticleByType(category.getId()));
			viewList.add(view);
		}
		return viewList;
	}

	@Override
	public List<Article> getPage(int cid, int page, int pagesize) {
		return articleMapper.getPage(cid, (page-1)*pagesize, pagesize);
	}

	@Override
	public int getPageCount(int cid) {
		return articleMapper.getPageCount(cid);
	}

}
