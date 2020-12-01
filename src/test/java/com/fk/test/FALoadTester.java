package com.fk.test;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ae.pages.BasePage;
import com.ixigo.Browser;
import com.ixigo.SUT;

public class FALoadTester{

	@Test
	public void loadTest_8632() {
		String buildId = "platform-master-8632"; int backlogI = 1;
		clickLinks(buildId, backlogI);
	}
	
	@Test
	public void loadTest_8630() {
		String buildId = "platform-master-8630"; int backlogI = 3;
		clickLinks(buildId, backlogI);
	}
	
	@Test
	public void loadTest_8622() {
		String buildId = "platform-master-8622"; int backlogI = 4;
		clickLinks(buildId, backlogI);
	}
	
	@Test
	public void loadTest_8621() {
		String buildId = "platform-master-8621"; int backlogI = 7;
		clickLinks(buildId, backlogI);
	}
	
	@Test
	public void loadTest_8620() {
		String buildId = "platform-master-8620"; int backlogI = 8;
		clickLinks(buildId, backlogI);
	}
	
	@Test
	public void loadTest_8619() {
		String buildId = "platform-master-8619"; int backlogI = 9;
		clickLinks(buildId, backlogI);
	}
	
	@Test
	public void loadTest_8618() {
		String buildId = "platform-master-8618"; int backlogI = 10;
		clickLinks(buildId, backlogI);
	}
	
	private void clickLinks(String buildId, int backlogI) {
		SUT testEnv = new SUT();
		Browser browser = testEnv.getBrowser();
		browser.open("https://fa.pega.io/");
		BasePage loadTester = new BasePage(testEnv);
		loadTester.driver.navigate().to("https://fa.pega.io/profiles?buildId=" + buildId);
		loadTester.selectOption(By.id("bklogFilter"), backlogI);
		List<WebElement> profiles = loadTester.driver.findElements(By.cssSelector(".profiles a[class^='text']"));
		System.out.println(loadTester.driver.manage().getCookieNamed("Pega-RULES"));
		for(WebElement elmt : profiles) {
			elmt.click();
		}
		List<WebElement> analysisLinks = loadTester.driver.findElements(By.cssSelector("a.analysis-link"));
		int len = analysisLinks.size();
		for(int i=0; i<len; i++) {
			testEnv.handleWaits().waitForElementVisibility(By.cssSelector("a.analysis-link"));
			analysisLinks.get(i).click();
			testEnv.handleWaits().waitForElementNotVisible(By.cssSelector("img[alt='loading']"));
			loadTester.driver.navigate().back();
			loadTester.selectOption(By.id("bklogFilter"), backlogI);
			profiles = loadTester.driver.findElements(By.cssSelector(".profiles a[class^='text']"));
			for(WebElement elmt : profiles) {
				elmt.click();
			}
			analysisLinks = loadTester.driver.findElements(By.cssSelector("a.analysis-link"));
		}
	}
}
