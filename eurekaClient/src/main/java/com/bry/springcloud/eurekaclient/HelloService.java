package com.bry.springcloud.eurekaclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloService {
	private static Logger log = LoggerFactory.getLogger(HelloService.class);

	@Value("${eureka.instance.hostname}")
	String server;

	@Value("${server.port}")
	String port;

	@Value("${greeter}")
	String greeter;

	@RequestMapping("/hello")
	public String sayHello(String name) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			log.info("HelloService.sayHello()-> current user =" + authentication.getName());
		}
		return "Hello " + name + " from " + server + ":" + port + ", I am " + greeter;
	}

	@RequestMapping("/getName")
	public String getName() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			log.info("HelloService.getName()-> current user =" + authentication.getName());
		}

		return "Hello I am Bruce, from " + server + ":" + port + ", I am " + greeter;
	}

}
