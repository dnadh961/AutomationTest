package com.ixigo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ae.util.WaitHandler;

public class SUT{
	
	private WebDriver driver = null;
	private Configuration config = null;
	private Browser browser = null;
	private WaitHandler waitHandler = null;
	
	public SUT() {
		initializeDriver();
	}
	
	public void terminate(){
		driver.quit();
	}

	private void initializeDriver() {
		String browserName = getConfiguration().getBrowserName();
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
	}

	public Browser getBrowser() {
		if(browser==null){
			browser = new Browser(this);
		}
		return browser;
	}

	public Configuration getConfiguration() {
		if(config == null){
			config = new Configuration();
		}
		return config;
	}
	
	public WaitHandler handleWaits(){
		if(waitHandler == null){
			waitHandler = new WaitHandler(this);
		}
		return waitHandler;
	}
	
	public WebDriver getDriver(){
		return driver;
	}
}
