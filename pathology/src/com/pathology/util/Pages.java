package com.pathology.util;


public class Pages {

	private int total_rows;
	private int total_pages;
	private int current_page = 1;
	private int pageof_rows = 10;
	private int start_row;
	private String pageStr;
	private String formId;
	private String pageLimit;

	public Pages(){}
	
	public Pages(int total_rows, int current_page, int pageOf_rows){
		
		this.total_rows = total_rows;
		this.current_page = current_page;
		this.pageof_rows = pageOf_rows;
		//查询的起始行
		start_row = (current_page -1)*pageof_rows;
		//总页数
		if(this.total_rows % pageof_rows > 0){
			total_pages = total_rows/pageof_rows + 1;
		}else{
			total_pages = total_rows/pageof_rows;
		}
		//数据库查询限制条数
		StringBuilder pageLimit = new StringBuilder(" limit ").append(start_row).append(", ").append(pageof_rows); 
		this.pageLimit = pageLimit.toString();
	}
	
//	public Pages(int total_rows, String formId){
//		this(total_rows, formId, 1);
//	}
	

	/**
	 * 设置分页类信息
	 * @param total_rows
	 * @param formId
	 * @param currPage
	 */
	public Pages(int total_rows, String formId, int currPage, int pageOf_rows){
		
		//总行数
		this.total_rows = total_rows;
		this.pageof_rows = pageOf_rows;
		//总页数
		if(this.total_rows % pageof_rows > 0){
			total_pages = total_rows/pageof_rows + 1;
		}else{
			total_pages = total_rows/pageof_rows;
		}
		//当前页
		this.current_page = currPage;
		if(current_page > total_pages){
			current_page = total_pages;
		}
		//查询的起始行
		start_row = (current_page -1)*pageof_rows;
		
		//页面显示翻页按钮，传入参数为pageNum
		StringBuilder pageStr = new StringBuilder("");
		pageStr.append("<div id='pageDiv' align='center'>");
		if(current_page == 1){
			pageStr.append("<input type='button' disabled value='首页'>");
			pageStr.append("<input type='button' disabled value='上一页'>");
		}else{
			pageStr.append("<input type='button' value='首页' onclick=\"pagesubmit(").append("'"+formId+"'")
			.append(",")
			.append("1")
			.append(")\"")
			.append("/>");
			pageStr.append("<input type='button' value='上一页' onclick=\"pagesubmit(").append("'"+formId+"'")
			.append(",")
			.append(current_page-1)
			.append(")\"")
			.append("/>");
//			
//			pageStr.append("<input type='button' value='首页' onclick='").append(formId)
//			.append(".action=").append(formId).append(".action+\"?pageNum=").append(1)
//			.append("\";").append(formId).append(".submit();'>");
//			pageStr.append("<input type='button' value='上一页' onclick='").append(formId)
//			.append(".action=").append(formId).append(".action+\"?pageNum=").append(current_page-1)
//			.append("\";").append(formId).append(".submit();'>");
		}
		pageStr.append("当前第<label id='currPageLabel'>").append(current_page).append("</label>页");
		pageStr.append("&nbsp;&nbsp;总共<label id='totalPageLabel'>").append(total_pages).append("</label>页");
		pageStr.append("&nbsp;&nbsp;总共<label id='totalRowLabel'>").append(total_rows).append("</label>条记录");
		if(current_page >= total_pages){
			pageStr.append("<input type='button' disabled value='下一页'>");
			pageStr.append("<input type='button' disabled value='末页'>");
		}else{
			pageStr.append("<input type='button' value='下一页' onclick=\"pagesubmit(").append("'"+formId+"'")
			.append(",")
			.append(current_page+1)
			.append(")\"")
			.append("/>");
			pageStr.append("  <input type='button' value='末页' onclick=\"pagesubmit(").append("'"+formId+"'")
			.append(",")
			.append(total_pages)
			.append(")\"")
			.append("/>");
//			pageStr.append("<input type='button' value='下一页' onclick='").append(formId)
//			.append(".action=").append(formId).append(".action+\"?pageNum=").append(current_page+1)
//			.append("\";").append(formId).append(".submit();'>");
//			pageStr.append("<input type='button' value='末页' onclick='").append(formId)
//			.append(".action=").append(formId).append(".action+\"?pageNum=").append(total_pages)
//			.append("\";").append(formId).append(".submit();'>");
		}
		pageStr.append("</div>");
		this.pageStr = pageStr.toString();
		//System.out.println(" pageStr.toString()== "+pageStr.toString());
		//数据库查询限制条数
		StringBuilder pageLimit = new StringBuilder(" limit ").append(start_row).append(", ").append(pageof_rows); 
		this.pageLimit = pageLimit.toString();
	}
	
	public int getStart_row() {
		return start_row;
	}
	public void setStart_row(int start_row) {
		this.start_row = start_row;
	}
	public int getTotal_rows() {
		return total_rows;
	}
	public void setTotal_rows(int total_rows) {
		this.total_rows = total_rows;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public int getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}
	public int getPageof_rows() {
		return pageof_rows;
	}
	public void setPageof_rows(int pageof_rows) {
		this.pageof_rows = pageof_rows;
	}
	public String getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(String pageLimit) {
		this.pageLimit = pageLimit;
	}

	public String getPageStr() {
		return pageStr;
	}

	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}
}

