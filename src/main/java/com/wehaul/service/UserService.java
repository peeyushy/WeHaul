package com.wehaul.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wehaul.model.Role;
import com.wehaul.model.User;

@Service
public class UserService implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Value("${webservicebaseurl}")
	private String WS_BASE_URL = null;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ClientService clientService;

	public User getUsersByUserId(String id) {

		ResponseEntity<User> clientResponse = restTemplate.exchange(WS_BASE_URL + "/wehaul/user/id/" + id,
				HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
				});

		return clientResponse.getBody();
	}

	public User getUserByUserName(String username) {

		ResponseEntity<User> clientResponse = restTemplate.exchange(WS_BASE_URL + "/wehaul/user/username/" + username,
				HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
				});

		return clientResponse.getBody();
	}

	public User getAdminOnlyUserByUserName(String username) {

		ResponseEntity<User> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/user/adminusername/" + username, HttpMethod.GET, null,
				new ParameterizedTypeReference<User>() {
				});

		return clientResponse.getBody();
	}

	public void deleteUser(String id) {
		restTemplate.delete(WS_BASE_URL + "/wehaul/user/id/" + id);
		return;
	}

	public void addUser(User user) {

		HttpEntity<User> request = new HttpEntity<>(user);
		ResponseEntity<User> response = restTemplate.exchange(WS_BASE_URL + "/wehaul/user/create", HttpMethod.POST,
				request, User.class);

		return;
	}

	public void updateUser(String id, User user) {
		user.setCreatedby(getUsersByUserId(id).getCreatedby());
		HttpEntity<User> request = new HttpEntity<>(user);
		ResponseEntity<User> response = restTemplate.exchange(WS_BASE_URL + "/wehaul/user/id/" + id, HttpMethod.PUT,
				request, User.class);

		return;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRolename().toString()));
		user.setAuthorities(grantedAuthorities);
		user.setClient(clientService.getClient(getClientidByUserName(username).toString()));
		log.info("Logged in user::" + username);
		return user;

	}

	public List<Role> getAllRoles() {

		ResponseEntity<List<Role>> clientResponse = restTemplate.exchange(WS_BASE_URL + "/wehaul/role/all/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Role>>() {
				});

		return clientResponse.getBody();
	}

	public User getLoggedinUserObj() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return (User) ((UserDetails) principal);
		}
		return null;
	}

	private Long getClientidByUserName(String username) {

		ResponseEntity<Long> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/user/getclientidbyusername/" + username, HttpMethod.GET, null,
				new ParameterizedTypeReference<Long>() {
				});

		return clientResponse.getBody();
	}
}