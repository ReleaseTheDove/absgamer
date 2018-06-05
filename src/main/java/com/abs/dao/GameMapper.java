package com.abs.dao;

import java.util.List;

import com.abs.entity.Game;
import tk.mybatis.mapper.common.Mapper;

public interface GameMapper extends Mapper<Game> {
	public List<Game> getGameList();
}