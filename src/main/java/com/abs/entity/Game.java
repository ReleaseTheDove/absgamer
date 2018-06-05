package com.abs.entity;

import java.util.Date;
import javax.persistence.*;

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 游戏名称
     */
    private String gamename;

    /**
     * 评分
     */
    private String score;

    /**
     * 排行榜类型---0:单机排行  1:单机更新
     */
    private Byte type;

    private String gamerurl;

    private Date createdatetime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取游戏名称
     *
     * @return gamename - 游戏名称
     */
    public String getGamename() {
        return gamename;
    }

    /**
     * 设置游戏名称
     *
     * @param gamename 游戏名称
     */
    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    /**
     * 获取评分
     *
     * @return score - 评分
     */
    public String getScore() {
        return score;
    }

    /**
     * 设置评分
     *
     * @param score 评分
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * 获取排行榜类型---0:单机排行  1:单机更新
     *
     * @return type - 排行榜类型---0:单机排行  1:单机更新
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置排行榜类型---0:单机排行  1:单机更新
     *
     * @param type 排行榜类型---0:单机排行  1:单机更新
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * @return gamerurl
     */
    public String getGamerurl() {
        return gamerurl;
    }

    /**
     * @param gamerurl
     */
    public void setGamerurl(String gamerurl) {
        this.gamerurl = gamerurl;
    }

    /**
     * @return createdatetime
     */
    public Date getCreatedatetime() {
        return createdatetime;
    }

    /**
     * @param createdatetime
     */
    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }
}