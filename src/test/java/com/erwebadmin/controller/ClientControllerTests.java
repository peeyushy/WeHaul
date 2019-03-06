package com.erwebadmin.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.erwebadmin.selenium.SeleniumConfig;

public class ClientControllerTests {

	private SeleniumConfig config;

	@Before
	public void setup() {
		config = new SeleniumConfig();
	}

	@Test
	public void addTransporterTest() throws IOException {
		config.login();
		Reader in = new FileReader("src/test/resources/static/data/MumbaiTransporters.csv");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(in);
		for (CSVRecord record : records) {
			String compname = record.get("COMPANYNAME").trim();
			String address = record.get("ADDRESS").trim();
			String contactno = record.get("CONTACTNO").trim();			
			System.out.println(compname + "," + address + "," + contactno);
			config.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			config.menuClick("T-A");
			config.getDriver().findElement(By.name("clientname")).sendKeys(compname);
			config.getDriver().findElement(By.name("contactno")).sendKeys(contactno);
			config.getDriver().findElement(By.name("address")).sendKeys(address);
			Select dropdown = new Select(config.getDriver().findElement(By.name("city")));
			dropdown.selectByVisibleText("Mumbai");
			if (contactno.equals("CHECK")) {
				config.getDriver().findElement(By.name("active")).click();
			}
			config.getDriver().findElement(By.name("saveBtn")).click();
		}
		assertThat(config.getDriver().getTitle(), is("ERWebAdmin"));
	}

	@After
	public void teardown() {
		// Remove test data
		config.getDriver().close();
	}

}
