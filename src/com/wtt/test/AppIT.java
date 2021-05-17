package com.wtt.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppIT {

	private WebDriver driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL("http://selenium.engazewell.com/wd/hub"),capabilities);
		System.out.println("connected...............");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void simpleTest() {
		driver.navigate().to("http://www.google.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "google");
	}



}
