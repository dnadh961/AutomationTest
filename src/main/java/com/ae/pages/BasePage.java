package com.ae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ixigo.SUT;

public class BasePage {
	
	protected SUT testEnv = null;
	public WebDriver driver = null;
	
	public BasePage(SUT testEnv) {
		this.testEnv = testEnv;
		this.driver = testEnv.getDriver();
	}

	public WebElement findElement(By by){
		testEnv.handleWaits().waitForElementPresence(by);
		return driver.findElement(by);
	}
	
	public void selectOption(By by, String value){
		WebElement elmt = findElement(by);
		new Select(elmt).selectByValue(value);
	}
	
	public void selectOption(By by, int index){
		WebElement elmt = findElement(by);
		new Select(elmt).selectByIndex(index);
	}
	
	public void click(By by){
		findElement(by).click();
		testEnv.handleWaits().waitForPageLoaded();
	}
	
	public boolean verifyElement(By by){
		boolean isPresent = true;
		try{
			driver.findElement(by);
		}catch(NoSuchElementException e){
			isPresent = false;
		}
		return isPresent;
	}
}
