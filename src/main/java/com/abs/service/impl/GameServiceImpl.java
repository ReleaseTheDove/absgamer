package com.abs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abs.dao.GameMapper;
import com.abs.entity.Game;
import com.abs.service.GameService;

@Service("gameService")
public class GameServiceImpl extends BaseServiceImpl<Game> implements GameService {
	@Autowired
	private GameMapper gameMapper;
	
    public List<Game> getGameList() {
    	return gameMapper.getGameList();
    }
}
