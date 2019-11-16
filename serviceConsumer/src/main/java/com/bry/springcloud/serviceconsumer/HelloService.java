package com.bry.springcloud.serviceconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eurekaClient",fallback = HelloServiceHystrix.class)
public interface HelloService {

	@RequestMapping(value ="/hello",method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "name") String name) ;

}
