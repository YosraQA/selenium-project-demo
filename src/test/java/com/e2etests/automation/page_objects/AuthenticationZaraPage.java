package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utility.Setup;

public class AuthenticationZaraPage {

	/* @FindBy WebElement */
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'SE CONNECTER')]")
	public static WebElement btnSeConnecter;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Démarrer la session')]")
	public static WebElement pageMessage;

	@FindBy(how = How.NAME, using = "logonId")
	public static WebElement userEmail;

	@FindBy(how = How.NAME, using = "password")
	public static WebElement userPassword;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'sameh')]")
	public static WebElement userName;

	public AuthenticationZaraPage() {
		PageFactory.initElements(Setup.driver, this);
	}

	/* Create Methods */

	public void goToUrl(String url) {
		Setup.driver.get(url);
	}

	public void clickBtnSeConnecter() {
		btnSeConnecter.click();
	}

	public void fillUserEmail(String txt_Email) {
		userEmail.sendKeys(txt_Email);
	}

	public void fillUserPassword(String txt_Password) {
		userPassword.sendKeys(txt_Password);
	}

}
