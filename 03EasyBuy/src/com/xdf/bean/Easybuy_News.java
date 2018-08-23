package com.xdf.bean;

import java.util.Date;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-24上午11:22:03
 * 
 * 新闻的实体类
 */
public class Easybuy_News {
	private int id;// 新闻编号
	private String title;// 新闻标题
	private String content;// 新闻内容
	private Date createTime;// 新闻创建时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Easybuy_News() {
		super();
	}

	public Easybuy_News(int id, String title, String content, Date createTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Easybuy_News [id=" + id + ", title=" + title + ", content="
				+ content + ", createTime=" + createTime + "]";
	}

}
