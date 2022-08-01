package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utility.ExcelUtils;
import com.e2etests.automation.utility.Setup;

public class SignInXlsxPage {
	
	/* @FindBy WebElement */
	@FindBy(how = How.ID, using = "txtUsername")
	public static WebElement username;

	@FindBy(how = How.ID, using = "txtPassword")
	public static WebElement password;

	@FindBy(how = How.ID, using = "btnLogin")
	public static WebElement btnLogin;
	
	public SignInXlsxPage() {
		PageFactory.initElements(Setup.driver, this);
	}
	
	public void signInXlsx() throws Exception {
		
		// This is to get the values from Excel Sheet, passing parameters (Row Num, Col Num) to get celldata
		String sUsername = ExcelUtils.getCellData(1, 1);
		String sPassword = ExcelUtils.getCellData(1, 2);
		
		username.sendKeys(sUsername);
		password.sendKeys(sPassword);
		btnLogin.click();
		
		
	}

}
