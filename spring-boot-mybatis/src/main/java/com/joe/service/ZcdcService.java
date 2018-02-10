package com.joe.service;

import com.joe.models.PageDo;
import com.joe.models.Zcdc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ZcdcService {

	/**
	 * 插入一个专项
	 * 
	 * @param zcdc
	 * @return
	 */
	int insert(Zcdc zcdc);

	/**
	 * 更新一个专项
	 * @param zcdc
	 * @return
	 */
	int update(Zcdc zcdc);

	int deleteByIdList(List<String> idList);

	Zcdc queryById(String id);

	void findDataGrid(PageDo zcdc);

	/**
	 * 生成编号，eg:20170922-001,默认三位，最高999，超过则从1000后往后累加
	 * @return
	 */
	String createZxCode();

	/**
	 * 结束专项
	 * @param idList
	 * @return
	 */
	int stopZX(List<String> idList);

	/**
	 * 测试事物
	 */
	void testTransactionManagement();
}
