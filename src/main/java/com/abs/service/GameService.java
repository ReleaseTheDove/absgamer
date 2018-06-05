package com.abs.service;

import java.util.List;

import com.abs.entity.Game;

public interface GameService extends BaseService<Game>{
	public List<Game> getGameList();
}
