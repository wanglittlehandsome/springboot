package com.bestway.program.common.utils;

import java.io.Serializable;

/**
 * 
 * 说明：分页工具类
 * 
 * @author J.
 * @version 1.0
 * @date 2017年7月3日
 */
public class Pagination implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_PAGE_SIZE = 5;

	private Integer page;// 页数

	private Integer size;// 每页显示数量

	/**
	 * 分页空构造方法,为Spring预留
	 */
	public Pagination() {
		// 为Spring 保留空构造函数
	}

	/**
	 * 分页构造方法,使用默认Size
	 * 
	 * @param page
	 */
	public Pagination(Integer page) {
		this.page = page;
	}

	/**
	 * 自定义分页信息
	 * 
	 * @param page
	 * @param size
	 */

	public Pagination(Integer page, Integer size) {
		this.page = page;
		this.size = size;
	}

	/**
	 * @Title: getNowPage
	 * @Description: (获得当前页)
	 * @return
	 */
	public int getNowPage() {
		return page == null || page <= 0 ? 1 : page;
	}

	/**
	 * @Title: getPageSize
	 * @Description: (获得每显示条数)
	 * @return
	 */
	public int getPageSize() {
		return size == null || size <= 0 ? DEFAULT_PAGE_SIZE : size;
	}

	/**
	 * @Title: getStartNumber
	 * @Description: (获得每页的开始记录)
	 * @return
	 */
	public int getStartNumber() {
		return (getNowPage() - 1) * getPageSize();
	}

	// get set
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getPage() {
		return page;
	}

	public Integer getSize() {
		return size;
	}

}
