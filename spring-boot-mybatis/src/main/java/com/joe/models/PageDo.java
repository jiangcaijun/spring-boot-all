package com.joe.models;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页类
 * @Autor jiangcaijun
 */
@Data
public class PageDo {

	private final static int PAGESIZE = 10; //默认显示的记录数

	//slect * from student limit 4 offset 9    注意：4表示返回4行，9表示从表的第十行开始
	private int limit;
	private int offset ;

	private int total = 0;
	private List rows; //显示的记录

	public static String DESC = "desc";
	public static String ASC = "asc";
	/*可用排序类型*/
	public static List<String> SORT = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;{
			this.add("desc");
			this.add("asc");
		}
	};
	public PageDo(){
		limit = PAGESIZE;
		offset = 0;
	}
	public PageDo(int limit, int offset){
		//计算当前页
		if (limit < 0) {
			this.limit = 1;
		} else {
			//当前页
			this.limit = limit;
		}
		//记录每页显示的记录数
		if (offset < 0) {
			this.offset = PAGESIZE;
		} else {
			this.offset = offset;
		}
	}
}