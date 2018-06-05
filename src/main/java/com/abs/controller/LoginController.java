package com.abs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abs.entity.User;
import com.abs.service.UserService;
import com.abs.util.Constans;
import com.abs.util.MD5Util;
import com.abs.util.ResponseEntity;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/admin")
@Api(value="/api/admin", description = "后台登录") 
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/adminlogin")
	@ResponseBody
	@ApiOperation(value = "管理员登录", httpMethod = "POST", notes = "管理员登录")
    public ResponseEntity login(@RequestParam(value="username",required=true) String username, @RequestParam(value="password",required=true)String password, HttpSession session) {
    	String suser = (String)session.getAttribute("user");
    	if (suser == null) {
    		User user = new User();
    		user.setUsername(username);
    		user.setPassword(MD5Util.getMD5String(password));
    		User u = userService.selectOne(user);
    		if (u != null) {
    			session.setAttribute("user", u.getUsername());
    			ResponseEntity resp = new ResponseEntity();
    			resp.setCode(Constans.SUCCESS);
    			resp.setMessage("success");
    			resp.setData("");
    			return resp;
    		} else {
    			ResponseEntity resp = new ResponseEntity();
    			resp.setCode(Constans.USER_OR_PASSWORD_error);
    			resp.setMessage("用户名或密码错误");
    			resp.setData("");
    			return resp;
    		}
    	} else {
    		ResponseEntity resp = new ResponseEntity();
			resp.setCode(Constans.SUCCESS);
			resp.setMessage("success");
			resp.setData("");
			return resp;
    	}
    }
	
	@RequestMapping("/changepsw")
	@ResponseBody
	@ApiOperation(value = "修改密码", httpMethod = "POST", notes = "修改密码")
    public ResponseEntity changePsw(@RequestParam(value="username",required=true) String username, @RequestParam(value="password",required=true)String password,@RequestParam(value="newpsw",required=true) String newpsw, HttpSession session) {
		ResponseEntity resp = new ResponseEntity();
		String suser = (String)session.getAttribute("user");
		if (suser == null) {
			resp.setCode(Constans.FAIL);
			resp.setMessage("未登陆");
			resp.setData("");
			return resp;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(MD5Util.getMD5String(password));
		User u = userService.selectOne(user);
		if (u != null) {
			user = new User();
			user.setId(u.getId());
			user.setPassword(newpsw);
			userService.update(user);
			resp.setCode(Constans.SUCCESS);
			resp.setMessage("success");
			resp.setData("");
			return resp;
		} else {
			resp.setCode(Constans.USER_OR_PASSWORD_error);
			resp.setMessage("用户名或密码错误");
			resp.setData("");
			return resp;
		}
	}
}
