package com.abs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abs.entity.Game;
import com.abs.service.GameService;
import com.abs.util.Constans;
import com.abs.util.ResponseEntity;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/game")
@Api(value="/api/game", description = "游戏列表")  
public class GameController {
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/list")
	@ResponseBody
	@ApiOperation(value = "获取游戏列表", httpMethod = "GET", notes = "获取游戏列表")
    public ResponseEntity getGames() {
		ResponseEntity rep = new ResponseEntity();
		rep.setCode(Constans.SUCCESS);
		rep.setMessage("success");
		rep.setData(gameService.getGameList());
		return rep;
    }
}
