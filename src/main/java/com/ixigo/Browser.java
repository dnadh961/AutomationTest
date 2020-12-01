package com.ixigo;

import org.openqa.selenium.WebDriver;

import com.ae.pages.MyStore;

public class Browser{
	
	private SUT testEnv = null;
	private WebDriver driver = null;
	private Configuration config = null;
	private MyStore myStore = null;
	
	public Browser(SUT testEnv) {
		this.testEnv = testEnv;
		this.driver = testEnv.getDriver();
		this.config = testEnv.getConfiguration();
	}

	public void open() {
		open(config.getInstanceURL());
	}

	public void close() {
		driver.close();
	}

	public void open(String url) {
		driver.get(url);
	}
	
	public MyStore getHomePage(){
		if(myStore==null){
			myStore = new MyStore(testEnv);
		}
		return myStore;
	}

}
