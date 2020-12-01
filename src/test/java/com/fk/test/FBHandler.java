package com.fk.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FBHandler {
	
	private static WebDriver driver;
	private static final String browserName = "chrome";
	private static final String statusMsg = "Hello World";
	
	private static final String username = "";
	private static final String password = "";

	public static void main(String[] args) {
		initializeDriver();
		doLogin();
		postStatus();
		doClose();
	}
	
	private static void doClose() {
		driver.close();
		driver.quit();
	}

	private static void postStatus() {
		driver.findElement(By.cssSelector("textarea[title^='Write something']")).click();
		driver.findElement(By.cssSelector("div[data-testid='status-attachment-mentions"
				+ "-input']")).sendKeys(statusMsg);
		driver.findElement(By.xpath("//span[text()='Share']")).click();
	}

	private static void doLogin() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.cssSelector("input[data-testid='royal_login_button']")).click();
	}

	private static void initializeDriver() {
		if("firefox".equals(browserName) || "".equals(browserName))
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if("chrome".equals(browserName))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); //To maximize the browser
			options.addArguments("--test-type");  //To get rid off 'ignore certificate errors' message           options.addArguments("--kiosk");  //To enable full screen mode
			options.addArguments("chrome.switches","--disable-extensions");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		else if("iexplore".equals(browserName))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
			capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
			System.setProperty("webdriver.ie.driver", "iedriver.exe");
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
}
