package com.qcloud.project.macaovehicle.web.vo;

import java.util.ArrayList;
import java.util.List;

public class DvrAreaVO {

	private long id;

	// 区域名称
	private String name;

	// 是否启用(1启用, 0不启用)
	private int status;

	private List<DvrDetailVO> list = new ArrayList<DvrDetailVO>();

	public DvrAreaVO() {

	}

	public DvrAreaVO(long id, String name, int status, List<DvrDetailVO> list) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.list = list;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public List<DvrDetailVO> getList() {
		return list;
	}

	public void setList(List<DvrDetailVO> list) {
		this.list = list;
	}

}
