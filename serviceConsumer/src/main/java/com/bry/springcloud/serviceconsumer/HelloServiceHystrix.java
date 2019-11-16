package com.bry.springcloud.serviceconsumer;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class HelloServiceHystrix implements HelloService {
	
	public String sayHello(@RequestParam(value = "name") String name) {
		return "Hello " + name + " Error  occurred! This is default message";
	}
}