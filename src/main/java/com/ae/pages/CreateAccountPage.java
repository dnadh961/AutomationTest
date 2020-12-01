package com.ae.pages;

import org.openqa.selenium.By;

import com.ixigo.SUT;

public class CreateAccountPage extends BasePage{
	
	private static final String firstName_id = "customer_firstname";
	private static final String lastName_id = "customer_lastname";
	private static final String password_id = "passwd";

	public CreateAccountPage(SUT testEnv) {
		super(testEnv);
	}
	
	/**
	 * 
	 * @param index 1 for Mr and 2 for Mrs
	 */
	public void setTitle(int index){
		click(By.id("id_gender"+index));
	}
	
	public void enterFirstName(String firstName){
		findElement(By.id(firstName_id)).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName){
		findElement(By.id(lastName_id)).sendKeys(lastName);
	}
	
	public void enterPassword(String password){
		findElement(By.id(password_id)).sendKeys(password);
	}
	
	public void setDateOfBirth(int daysValue, int monthValue, int yearsValue){
		selectOption(By.id("days"), daysValue+"");
		selectOption(By.id("months"), monthValue+"");
		selectOption(By.id("years"), yearsValue+"");
	}
	
	public void setAddress(String firstName, String lastName, String address, String city, String stateValue,
			String zipCode, String countryValue, String mobile, String addressForFuture){
		findElement(By.id("firstname")).sendKeys(firstName);
		findElement(By.id("lastname")).sendKeys(lastName);
		findElement(By.id("address1")).sendKeys(address);
		findElement(By.id("city")).sendKeys(city);
		selectOption(By.id("id_state"), stateValue);
		findElement(By.id("postcode")).sendKeys(zipCode);
		selectOption(By.id("id_country"), countryValue);
		findElement(By.id("phone_mobile")).sendKeys(mobile);
		findElement(By.id("alias")).sendKeys(addressForFuture);
	}
	
	public void register(){
		click(By.id("submitAccount"));
		testEnv.handleWaits().waitForElementPresence(By.linkText("Sign out"));
	}

}
