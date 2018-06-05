package com.abs.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abs.entity.Article;
import com.abs.service.ArticleService;
import com.abs.util.Constans;
import com.abs.util.ResponseEntity;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/article")
@Api(value = "/api/article", description = "文章类接口")
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/index")
	@ResponseBody
	@ApiOperation(value = "首页获取文章", httpMethod = "GET", notes = "首页获取文章")
	public ResponseEntity getIndexArticles() {
		ResponseEntity rep = new ResponseEntity();
		rep.setCode(Constans.SUCCESS);
		rep.setMessage("success");
		rep.setData(articleService.getIndexArticles());
		return rep;
	}

	@RequestMapping("/page")
	@ResponseBody
	@ApiOperation(value = "分页获取文章", httpMethod = "GET", notes = "分页获取文章")
	public ResponseEntity getPageArticles(@RequestParam(value = "cid", required = true) int cid,
			@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "pagesize", required = true) int pagesize) {
		ResponseEntity rep = new ResponseEntity();
		rep.setCode(Constans.SUCCESS);
		rep.setMessage("success");
		rep.setData(articleService.getPage(cid, page, pagesize));
		return rep;
	}
	
	@RequestMapping("/{id}")
	@ResponseBody
	@ApiOperation(value = "获取指定文章", httpMethod = "GET", notes = "获取指定文章")
	public ResponseEntity getArticleById(@PathVariable("id") int id) {
		Article article = new Article();
		article.setId(id);
		Article searchArticle = articleService.selectOne(article);
		ResponseEntity rep = new ResponseEntity();
		if (searchArticle != null) {
			searchArticle.setBrowseCount(searchArticle.getBrowseCount()+1);
			articleService.update(searchArticle);
			
			rep.setCode(Constans.SUCCESS);
			rep.setMessage("success");
			rep.setData(searchArticle);
		} else {
			rep.setCode(Constans.FAIL);
			rep.setMessage("该文章不存在");
			rep.setData("");
		}
		return rep;
	}

	@RequestMapping("/pagecount")
	@ResponseBody
	@ApiOperation(value = "分页获取文章数目", httpMethod = "GET", notes = "分页获取文章数目")
	public ResponseEntity getPageArticles(@RequestParam(value = "cid", required = true) int cid) {
		ResponseEntity rep = new ResponseEntity();
		rep.setCode(Constans.SUCCESS);
		rep.setMessage("success");
		rep.setData(articleService.getPageCount(cid));
		return rep;
	}
	
	

	@RequestMapping("/addarticle")
	@ResponseBody
	@ApiOperation(value = "添加文章", httpMethod = "POST", notes = "添加文章")
	public ResponseEntity addArticle(@RequestParam(value = "content", required = true) String content,@RequestParam(value = "title", required = true) String title,@RequestParam(value = "cid", required = true) int cid, HttpSession session) {
		String suser = (String)session.getAttribute("user");
		ResponseEntity rep = new ResponseEntity();
		if (suser != null) {
			Article article = new Article();
			article.setCategoryid(cid);
			article.setTitle(title);
			article.setContent(content);
			article.setAuthor("admin");
			article.setCreatedatetime(new Date());
			articleService.save(article);
			
			rep.setCode(Constans.SUCCESS);
			rep.setMessage("success");
			rep.setData("");
		} else {
			rep.setCode(Constans.FAIL);
			rep.setMessage("未登陆");
			rep.setData("");
		}
		return rep;
	}
}
