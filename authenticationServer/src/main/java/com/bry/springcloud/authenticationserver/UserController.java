package com.bry.springcloud.authenticationserver;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Principal getUser(Principal principal) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			logger.info("UserController.getUser()-> current user =" + authentication.getName());
		}

		if (principal != null) {
			logger.info("UserController.getUser() : " + principal.toString());
		}
		return principal;
	}
}