package com.abs.service;

import java.util.List;

import com.abs.entity.Article;
import com.abs.viewentity.IndexArticleView;

public interface ArticleService extends BaseService<Article>{
    public List<IndexArticleView> getIndexArticles();
    public List<Article> getPage(int cid, int page, int pagesize);
    public int getPageCount(int cid);
}
