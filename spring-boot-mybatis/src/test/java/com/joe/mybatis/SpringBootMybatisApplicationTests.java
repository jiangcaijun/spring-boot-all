package com.joe.mybatis;

import com.joe.mybatis.model.PageDo;
import com.joe.mybatis.service.ZcdcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {

	@Autowired
	private ZcdcService zcdcService;

	@Test
	public void contextLoads() {
		PageDo pageDo = new PageDo();
		zcdcService.findDataGrid(pageDo);
		System.out.println(String.format("获取数据的条数：%s", pageDo.getTotal()));
		System.out.println(String.format("获取数据：%s", pageDo.getRows()));
	}
}