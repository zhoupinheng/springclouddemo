package com.bry.springcloud.servicetest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eurekaClient", fallback = HelloServiceHystrix.class)
public interface HelloService {

	@RequestMapping(value = "/getName", method = RequestMethod.GET)
	public String getName();

}
