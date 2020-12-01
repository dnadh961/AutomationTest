package com.fk.test;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.ae.pages.AuthenticationPage;
import com.ae.pages.CreateAccountPage;
import com.ae.pages.MyStore;
import com.ixigo.Browser;
import com.ixigo.Configuration;
import com.ixigo.SUT;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAccountSteps {
	
	private SUT testEnv;
	private Browser browser;
	private Configuration config;
	private AuthenticationPage authenticationPage;
	private CreateAccountPage createAccountPage;
	
	
	@Before("@TC-100")
	public void setup(){
		testEnv = new SUT();
		browser = testEnv.getBrowser();
		config = testEnv.getConfiguration();
	}

	@Given("^user opens automation practice url in the browser$")
	public void user_opens_automation_practice_url_in_the_browser() {
		browser.open();
	}

	@When("^user clicks on Sign in link$")
	public void user_clicks_on_Sign_in_link() {
		MyStore homePage = browser.getHomePage();
		authenticationPage = homePage.signIn();
	}

	@When("^enters email address$")
	public void enters_email_address() {
		authenticationPage.enterEmailAddress(config.getEmail());
	}

	@When("^clicks on create account$")
	public void clicks_on_create_account() {
		createAccountPage = authenticationPage.createAccount();
	}

	@When("^sets Title$")
	public void sets_Title() {
		createAccountPage.setTitle(1);
	}

	@When("^sets FirstName$")
	public void sets_FirstName() {
		createAccountPage.enterFirstName(config.getFirstName());
	}

	@When("^sets LastName$")
	public void sets_LastName() {
		createAccountPage.enterLastName(config.getLastName());
	}

	@When("^sets Password$")
	public void sets_Password() {
		createAccountPage.enterPassword(config.getPassword());
	}

	@When("^sets Date of birth$")
	public void sets_Date_of_birth() {
		createAccountPage.setDateOfBirth(1, 2, 2000);
	}

	@When("^sets Address$")
	public void sets_Address() {
		createAccountPage.setAddress(config.getFirstName(), config.getLastName(), config.getAddress(),
				"Woking", "1", "12345", "21", "07528016936", config.getAddress());
	}

	@When("^clicks on Register button$")
	public void clicks_on_Register_button() {
		createAccountPage.register();
	}

	@Then("^user should see My Account page$")
	public void user_should_see_My_Account_page() {
		Assert.assertTrue(createAccountPage.verifyElement(By.xpath("//h1[text()='My account']")));
	}


}
