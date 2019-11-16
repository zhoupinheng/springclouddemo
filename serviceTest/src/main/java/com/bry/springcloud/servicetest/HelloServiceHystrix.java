package com.bry.springcloud.servicetest;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceHystrix implements HelloService {

	public String getName() {
		return "Hello I am EE, Error  occurred! This is default message";
	}
}