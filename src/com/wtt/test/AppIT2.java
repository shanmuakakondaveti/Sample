package com.wtt.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppIT2 {

	public static void main(String[] args) throws MalformedURLException {  

		// declaration and instantiation of objects/variables  

		WebDriver driver;
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setPlatform(Platform.WIN10);
		capabilities.setVersion("10.0");
		driver=new RemoteWebDriver(new URL("http://192.168.43.253:5555/grid/register"),capabilities);
		System.out.println("connected..........");

		// Launch website  
		driver.navigate().to("http://www.google.com/");  

		// Click on the search text box and send value  
		driver.findElement(By.id("lst-ib")).sendKeys("javatpoint tutorials");  

		// Click on the search button  
		driver.findElement(By.name("btnK")).click();  

	}  

}

