package com.abs.entity;

import java.util.Date;
import javax.persistence.*;

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章类型
     */
    private Integer categoryid;

    /**
     * 文章来源
     */
    @Column(name = "article_origin")
    private String articleOrigin;

    /**
     * 作者
     */
    private String author;

    /**
     * 浏览量
     */
    @Column(name = "browse_count")
    private Integer browseCount;

    /**
     * 创建时间
     */
    private Date createdatetime;

    /**
     * 文章内容
     */
    private String content;

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
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取文章类型
     *
     * @return categoryid - 文章类型
     */
    public Integer getCategoryid() {
        return categoryid;
    }

    /**
     * 设置文章类型
     *
     * @param categoryid 文章类型
     */
    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * 获取文章来源
     *
     * @return article_origin - 文章来源
     */
    public String getArticleOrigin() {
        return articleOrigin;
    }

    /**
     * 设置文章来源
     *
     * @param articleOrigin 文章来源
     */
    public void setArticleOrigin(String articleOrigin) {
        this.articleOrigin = articleOrigin;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取浏览量
     *
     * @return browse_count - 浏览量
     */
    public Integer getBrowseCount() {
        return browseCount;
    }

    /**
     * 设置浏览量
     *
     * @param browseCount 浏览量
     */
    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    /**
     * 获取创建时间
     *
     * @return createdatetime - 创建时间
     */
    public Date getCreatedatetime() {
        return createdatetime;
    }

    /**
     * 设置创建时间
     *
     * @param createdatetime 创建时间
     */
    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    /**
     * 获取文章内容
     *
     * @return content - 文章内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文章内容
     *
     * @param content 文章内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}