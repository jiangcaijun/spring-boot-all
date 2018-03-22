package com.joe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLogApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(SpringBootLogApplicationTests.class);

	@Test
	public void contextLoads() {
		logger.info("info级别的日志");
		logger.warn("warn级别的日志");
		logger.error("error级别的日志");
	}

}
