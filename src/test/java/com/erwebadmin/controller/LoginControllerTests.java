package com.erwebadmin.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.erwebadmin.selenium.SeleniumConfig;

public class LoginControllerTests {

	private SeleniumConfig config;

	@Before
	public void setup() {
		config = new SeleniumConfig();
	}

	@Test
	public void loginTest() {
		config.login();
		assertThat(config.getDriver().getTitle(), is("ERWebAdmin"));
	}

	@After
	public void teardown() {
		config.getDriver().close();
	}
}
