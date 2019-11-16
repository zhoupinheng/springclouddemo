package com.bry.springcloud.servicetest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {
	private static Logger log = LoggerFactory.getLogger(TestService.class);

	@Autowired
	HelloService helloService;

	@RequestMapping("/getname")
	public String getName() {
		log.info("TestService.sayHello()-> ");
		return helloService.getName();
	}

}
