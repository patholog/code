package com.pathology.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PageBean implements Serializable {
private int pageNum;
private int lastPage;
private int nextPage;
private int maxPage;
private int rowsPage;
private int rowsCount;
public int getPageNum() {
	return pageNum;
}
public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}
public int getLastPage() {
	return lastPage;
}
public void setLastPage(int lastPage) {
	this.lastPage = lastPage;
}
public int getNextPage() {
	return nextPage;
}
public void setNextPage(int nextPage) {
	this.nextPage = nextPage;
}
public int getMaxPage() {
	return maxPage;
}
public void setMaxPage(int maxPage) {
	this.maxPage = maxPage;
}
public int getRowsPage() {
	return rowsPage;
}
public void setRowsPage(int rowsPage) {
	this.rowsPage = rowsPage;
}
public int getRowsCount() {
	return rowsCount;
}
public void setRowsCount(int rowsCount) {
	this.rowsCount = rowsCount;
}
}
