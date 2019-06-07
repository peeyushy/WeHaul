package com.wehaul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	String[] publicresources = new String[] { "/", "/index", "/login", "/signin", "/logout", "/css/**",
			"/font-awesome/**", "/img/**", "/js/**", "/noauth/**" };

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().antMatchers(publicresources).permitAll().anyRequest(
	 * ).authenticated().and().httpBasic()
	 * .and().logout().permitAll().and().formLogin().loginProcessingUrl("/signin").
	 * permitAll().and().logout() .logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout")).logoutSuccessUrl("/signin"); }
	 */

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(publicresources).permitAll().anyRequest().authenticated()
				.and().formLogin().successForwardUrl("/home").loginPage("/login").failureUrl("/login?error=true")
				.permitAll().and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true)
				.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}