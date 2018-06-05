package com.abs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abs.entity.Category;
import com.abs.service.CategoryService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/test")
@Api(value="/api/test", description = "测试api")  
public class TestController {
	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping("/json")
	@ResponseBody
	@ApiOperation(value = "根据用户名获取用户对象", httpMethod = "GET", response = Category.class, notes = "根据用户名获取用户对象")
    public Category getJson() {
		Category c = new Category();
		c.setId(1);
    	return categoryService.selectOne(c);
    }
	@RequestMapping("/postjson")
	@ResponseBody
	@ApiOperation(value = "测试对象", httpMethod = "POST", response = Category.class, notes = "获取测试对象")
    public Category postJson() {
		Category c = new Category();
		c.setId(1);
    	return categoryService.selectOne(c);
    }
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("sdfasdf");
		return "index";
	}
}
