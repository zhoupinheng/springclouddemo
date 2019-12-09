package com.bry.springcloud.serviceconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {
	private static Logger log = LoggerFactory.getLogger(TestService.class);

	@Autowired
	HelloService helloService;

	@RequestMapping("/testhello")
	public String sayHello(String name) {
		log.info("TestService.sayHello()-> name=" + name);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			log.info("TestService.sayHello()-> current user =" + authentication.getName());
		}

		return helloService.sayHello(name);
	}

	@RequestMapping("/hello")
	public String test(String name) {
		log.info("TestService.test()-> name=" + name);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			log.info("TestService.test()-> current user =" + authentication.getName());
		}

		return helloService.sayHello(name);
	}

}
