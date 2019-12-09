package com.bry.springcloud.authenticationserver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	Map<String, UserDetails> userMap = new HashMap<String, UserDetails>();

	public UserDetailsServiceImpl() {

		String pwd = new BCryptPasswordEncoder().encode("123456");

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("USER"));

		UserDetails client1 = new User("user_1", pwd, authorities);
		UserDetails client2 = new User("user_2", pwd, authorities);
		userMap.put("user_1", client1);
		userMap.put("user_2", client2);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = userMap.get(username);
		if (user != null) {
			return new User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
		} else {
			throw new UsernameNotFoundException("user not exist");
		}
	}

}
