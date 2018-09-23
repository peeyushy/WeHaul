package com.erwebadmin.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.erwebadmin.model.User;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private RestTemplate restTemplate;

	public List<User> getUsersByClientId(String id) {

		ResponseEntity<List<User>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERMarketPlace/user/client/id/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});

		return clientResponse.getBody();
	}
	
	public User getUsersByUserId(String id) {

		ResponseEntity<User> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERMarketPlace/user/id/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<User>() {
				});

		return clientResponse.getBody();
	}
	
	public User getUsersByUserName(String username) {

		ResponseEntity<User> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERMarketPlace/user/username/" + username, HttpMethod.GET, null,
				new ParameterizedTypeReference<User>() {
				});

		return clientResponse.getBody();
	}


	public void deleteUser(String id) {
		restTemplate.delete("http://localhost:8081/ERMarketPlace/user/id/" + id);
		return;
	}

	public void addUser(User user) {

		HttpEntity<User> request = new HttpEntity<>(user);
		ResponseEntity<User> response = restTemplate.exchange("http://localhost:8081/ERMarketPlace/user/create",
				HttpMethod.POST, request, User.class);

		return;
	}

	public void updateUser(String id, User user) {
		user.setCreatedby(getUsersByUserId(id).getCreatedby());
		HttpEntity<User> request = new HttpEntity<>(user);
		ResponseEntity<User> response = restTemplate.exchange("http://localhost:8081/ERMarketPlace/user/id/" + id,
				HttpMethod.PUT, request, User.class);

		return;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getUsersByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		//for now hardcoded role need to change to reflect usertype as role
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        /*for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }*/
		grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);		
		
	}

}