package com.qhit.lh.gr3.powell.exam.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageBean<T> implements Serializable {
	
	private int currentIndex;//当前页
	private int pageSize;//每页记录数
	private int totalNumber;//总记录数
	private int totalPage;//总页数
	private int nextIndex;//下一页
	private int preIndex;//上一页
	private List<T> Items;//当前页的数据记录
	
	public int getPageSize(){
		return pageSize;
	}
	

	public PageBean(int currentIndex, int pageSize, int totalNumber,
			List<T> items) {
		super();
		this.currentIndex = currentIndex;
		this.pageSize = pageSize;
		this.totalNumber = totalNumber;
		Items = items;
	}


	public PageBean() {
		pageSize = 10;
		Items = new ArrayList<>();
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		int size = this.totalNumber/this.pageSize;
		if(this.totalNumber%this.pageSize != 0){
			size = size + 1;
		}
		this.totalPage = size;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 当前页的下一页，如果当前页大于等于最后一页
	 * 那么下一页就是最后一页
	 * @return
	 */
	public int getNextIndex() {
		if(this.currentIndex >= this.getTotalPage()){
			this.nextIndex = this.currentIndex;
		}else{
			this.nextIndex = this.currentIndex + 1;
		}
		return nextIndex;
	}

	public void setNextIndex(int nextIndex) {
		this.nextIndex = nextIndex;
	}

	/**
	 * 当前页的上一页，如果当前页小于第一页那么上一页为一
	 * @return
	 */
	public int getPreIndex() {
		if(this.currentIndex <= 1){
			this.preIndex = 1;
		}else{
			this.preIndex = this.currentIndex-1;
		}
		return preIndex;
	}

	public void setPreIndex(int preIndex) {
		this.preIndex = preIndex;
	}

	public List<T> getItems() {
		return Items;
	}

	public void setItems(List<T> items) {
		Items = items;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
