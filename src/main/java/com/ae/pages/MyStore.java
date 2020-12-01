package com.ae.pages;

import org.openqa.selenium.By;

import com.ixigo.SUT;

public class MyStore extends BasePage{
	
	public MyStore(SUT testEnv) {
		super(testEnv);
	}
	
	private static final String signIn_linkText = "Sign in";
	
	
	public AuthenticationPage signIn(){
		click(By.linkText(signIn_linkText));
		return new AuthenticationPage(testEnv);
	}
	
}
