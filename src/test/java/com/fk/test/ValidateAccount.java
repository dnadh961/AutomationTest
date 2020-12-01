package com.fk.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ae.pages.AuthenticationPage;
import com.ae.pages.CreateAccountPage;
import com.ae.pages.MyStore;
import com.ixigo.Browser;
import com.ixigo.Configuration;
import com.ixigo.SUT;

public class ValidateAccount {

	@Test
	public void testCreateAccount(){
		SUT testEnv = new SUT();
		Browser browser = testEnv.getBrowser();
		Configuration config = testEnv.getConfiguration();
		browser.open();
		MyStore homePage = browser.getHomePage();
		AuthenticationPage authenticationPage = homePage.signIn();
		authenticationPage.enterEmailAddress(config.getEmail());
		CreateAccountPage createAccountPage = authenticationPage.createAccount();
		createAccountPage.setTitle(1);
		createAccountPage.enterFirstName(config.getFirstName());
		createAccountPage.enterLastName(config.getLastName());
		createAccountPage.enterPassword(config.getPassword());
		createAccountPage.setDateOfBirth(1, 2, 2000);
		createAccountPage.setAddress(config.getFirstName(), config.getLastName(), config.getAddress(),
				"Woking", "1", "12345", "21", "07528016936", config.getAddress());
		createAccountPage.register();
		Assert.assertTrue(createAccountPage.verifyElement(By.xpath("//h1[text()='My account']")));
	}
}
