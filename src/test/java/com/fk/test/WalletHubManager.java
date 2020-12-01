package com.fk.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WalletHubManager {

	private static WebDriver driver;
	private static final String browserName = "chrome";
	
	private static final int rating = 5;
	private static final String content = "hi";
	private static final String username = "manjeera.k1213@gmail.com";
	private static final String password = "Invalid1!";

	public static void main(String[] args) {
		initializeDriver();
		doLogin();
		selectStar();
		writeReview();
		doClose();
	}
	
	private static void doLogin() {
		driver.get("https://wallethub.com/profile/test_insurance_company/");
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("em")).sendKeys(username);
		driver.findElement(By.name("pw")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	}

	private static void writeReview() {
		driver.findElement(By.xpath("//span[text()='Please select your policy']")).click();
		driver.findElement(By.linkText("Health")).click();
		driver.findElement(By.xpath("//span[text()='"+rating+"']")).click();
		driver.findElement(By.name("review")).sendKeys(content);
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
	}

	private static void selectStar() {
		WebElement stars = driver.findElement(By.cssSelector("span[class^='wh-rating']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(stars).build().perform();
		driver.findElement(By.xpath("//a[text()='"+rating+"']")).click();
	}

	private static void doClose() {
		driver.close();
		driver.quit();
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
