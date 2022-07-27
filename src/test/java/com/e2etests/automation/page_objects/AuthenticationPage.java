package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utility.ConfigFileReader;
import com.e2etests.automation.utility.Setup; 

public class AuthenticationPage {
	private ConfigFileReader configFileReader;

	/* @FindBy WebElement */
	@FindBy(how = How.ID, using = "txtUsername")
	public static WebElement username;

	@FindBy(how = How.ID, using = "txtPassword")
	public static WebElement password;

	@FindBy(how = How.ID, using = "btnLogin")
	public static WebElement btnLogin;
	
	@FindBy(how = How.ID, using = "welcome")
	public static WebElement homePage;
	
	@FindBy(how = How.XPATH, using ="//*[contains(text(),'Logout')]")
	// "//*[@id='welcome-menu']/ul/li[3]/a"
	public static WebElement btnLogout;
	

	public AuthenticationPage() {
		PageFactory.initElements(Setup.driver, this);
		this.configFileReader = new ConfigFileReader();
	}

	/* Create Methods */
	public void fillUsername(String txt_username) {
		username.sendKeys(txt_username);
	}

	public void fillPassword(String txt_password) {
		password.sendKeys(txt_password);
	}

	public void clickOnbtnLogin() {
		btnLogin.click();
	}

	public void goToURL() {
		Setup.driver.get(configFileReader.getProperties("home.url"));

	}
	
	public void clickOnIconLogout() {
		homePage.click();
	}
	
	public void clickOnbtnLogout() {
		btnLogout.click();
	}

}
