package com.xdf.bean;

import java.util.Date;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-24����11:22:03
 * 
 * ���ŵ�ʵ����
 */
public class Easybuy_News {
	private int id;// ���ű��
	private String title;// ���ű���
	private String content;// ��������
	private Date createTime;// ���Ŵ���ʱ��

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
