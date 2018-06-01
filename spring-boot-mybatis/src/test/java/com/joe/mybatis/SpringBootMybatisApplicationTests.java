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
		for(int i = 0; i < 10; i++){
			System.out.println(zcdcService.queryById(i + ""));
		}
	}
}