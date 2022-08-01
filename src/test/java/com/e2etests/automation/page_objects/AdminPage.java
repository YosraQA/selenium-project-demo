package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utility.Setup;

public class AdminPage {

	/* @FindBy WebElement */
	
	@FindBy(how = How.ID, using = "menu_admin_viewAdminModule")
	public static WebElement adminModule;

	@FindBy(how = How.ID, using = "searchSystemUser_userName")
	public static WebElement userName;

	@FindBy(how = How.ID, using = "searchBtn")
	public static WebElement searchBtn;

	@FindBy(how = How.ID, using = "resultTable")
	public static WebElement resultSearch;

	public AdminPage() {
		PageFactory.initElements(Setup.driver, this);
	}

	/* Create Methods */

	public void clickOnAdminModule() {
		adminModule.click();
	}

	public void fillUserNameAdmin(String txt_username) {
		userName.sendKeys(txt_username);
	}

	public void clickOnSearchBtn() {
		searchBtn.click();
	}

}
