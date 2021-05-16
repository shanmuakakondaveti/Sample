package com.wtt.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumSample{  

	private WebDriver driver;  


	@BeforeSuite
	public void setupBeforeSuite(ITestContext context) {
		TestRunner testRunner = (TestRunner) context;
		testRunner.setOutputDirectory("D://SampleTestNgReports");
	}	


	@BeforeTest
	public void setUp() throws MalformedURLException {
		// declaration and instantiation of objects/variables  
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL("http://selenium.engazewell.com/wd/hub"), capabilities);
		System.out.println("driver loaded......");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void simpleTest() {
		// Launch website  
		driver.navigate().to("https://www.javatpoint.com"); 

		//enter text in search box
		WebElement element=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/ul/li[2]/a"));
		element.click();
		WebElement nextButton=driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div[1]/table/tbody/tr/td/div[1]/a"));
		String text = nextButton.getText();
		System.out.println("Simple test():"+text);
		Assert.assertEquals("Next", text);
	}


	@Test(priority = 1)
	public void testCheckBox() {
		driver.navigate().to("https://www.javatpoint.com");

		WebElement element=driver.findElement(By.xpath("//*[@id=\"link\"]/div/ul/li[3]/a"));
		element.click();
		WebElement element2=driver.findElement(By.xpath("//*[@id=\"city\"]/table/tbody/tr/td/h1"));
		String expectedText = element2.getText();
		System.out.println("checkBox():"+expectedText);
		Assert.assertEquals("Java Tutorial", expectedText);
		driver.navigate().refresh();
	}


	@Test
	public void checkLink() { 
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).submit();

		String expected = driver.findElement(By.xpath("/html/body/div[7]/div/div[9]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a/h3")).getText();
		String actual="Javatpoint: Tutorials List";
		System.out.println("checkLine():"+expected);
		Assert.assertEquals(actual, expected);

	}


}  

