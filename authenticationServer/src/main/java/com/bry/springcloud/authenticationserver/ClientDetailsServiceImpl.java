package com.bry.springcloud.authenticationserver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.util.StringUtils;

public class ClientDetailsServiceImpl implements ClientDetailsService {

	Map<String, ClientDetails> clientMap = new HashMap<String, ClientDetails>();

	public ClientDetailsServiceImpl() {

		String pwd = new BCryptPasswordEncoder().encode("123456");

		BaseClientDetails client1 = new BaseClientDetails("client_1", "order", "server", "client_credentials,refresh_token", "client");
		client1.setClientSecret(pwd);
		BaseClientDetails client2 = new BaseClientDetails("client_2", "order", "select", "password,refresh_token", "client");
		client2.setClientSecret(pwd);
		clientMap.put("client_1", client1);
		clientMap.put("client_2", client2);
	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

		ClientDetails client = clientMap.get(clientId);

		if (client != null) {
			BaseClientDetails newClient = new BaseClientDetails(client.getClientId(), StringUtils.collectionToCommaDelimitedString(client.getResourceIds()),
					StringUtils.collectionToCommaDelimitedString(client.getScope()), StringUtils.collectionToCommaDelimitedString(client.getAuthorizedGrantTypes()),
					StringUtils.collectionToCommaDelimitedString(client.getAuthorities()));
			newClient.setClientSecret(client.getClientSecret());
			return newClient;
		} else {
			throw new ClientRegistrationException("Client not exists");
		}

	}

}
