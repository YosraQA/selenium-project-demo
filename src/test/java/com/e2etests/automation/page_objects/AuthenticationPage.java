package com.e2etests.automation.page_objects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Logout')]")
	public static WebElement btnLogout;

	@FindBy(how = How.ID, using = "menu_buzz_viewBuzz")
	public static WebElement modBuzz;

	@FindBy(how = How.ID, using = "createPost_content")
	public static WebElement userStatus;

	@FindBy(how = How.ID, using = "postSubmitBtn")
	public static WebElement btnPost;

	@FindBy(how = How.ID, using = "images-tab-label")
	public static WebElement uploadImagesMod;

	@FindBy(how = How.ID, using = "phototext")
	public static WebElement imagDescrip;
	
	@FindBy (how = How.ID, using="image-upload-button")
	public static WebElement btnUploadImag;
	
	@FindBy (how = How.ID, using="imageUploadBtn")
	public static WebElement btnPostImag;
	
	@FindBy (how = How.ID, using="video-tab-label")
	public static WebElement shareVideoMod;
	
	@FindBy (how = How.ID, using="createVideo_content")
	public static WebElement urlVideo;
	
	@FindBy (how = How.XPATH, using="//*[contains(text(),'Save Video')]")
	public static WebElement btnSaveVideo;

	
	public AuthenticationPage() {
		PageFactory.initElements(Setup.driver, this);
		this.configFileReader = new ConfigFileReader();
	}

	/* Create Methods */

	/* Login */
	public void goToURL() {
		Setup.driver.get(configFileReader.getProperties("home.url"));
	}

	public void fillUsername(String txt_username) {
		username.sendKeys(txt_username);
	}

	public void fillPassword(String txt_password) {
		password.sendKeys(txt_password);
	}

	public void clickOnbtnLogin() {
		btnLogin.click();
	}

	/* Use of Buzz's module */

	public void clickOnModBuzz() {
		modBuzz.click();
	}

	public void writeStatus(String txt_status) {
		userStatus.sendKeys(txt_status);
	}

	public void clickOnBtnStatus() {
		btnPost.click();
	}

	/* Use of Upload Images module */

	public void clickOnUploadImageMod() {
		uploadImagesMod.click();
	}

	public void writeImageDescription(String imag_descrip) {
		imagDescrip.sendKeys(imag_descrip);
	}
	
	public void clickOnBtnUploadImage (String imag_file) {
		btnUploadImag.click();
		StringSelection stringSelection = new StringSelection(imag_file);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void clickOnbtnPostImage () {
		btnPostImag.click();
	}
	
	/* Use of share video's module */
	
	public void clickOnShareVideoMod () {
		shareVideoMod.click();
	}
	
	public void fillUrlVideo (String video_url) {
		Actions action = new Actions(Setup.driver);
		action.keyDown(urlVideo, Keys.CONTROL).sendKeys(video_url).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void clickOnBtnSaveVideo ( ) {
		JavascriptExecutor execute = (JavascriptExecutor)Setup.driver;
		execute.executeScript("arguments[0].click();", btnSaveVideo);
	}

	/* Logout */

	public void clickOnIconLogout() {
		homePage.click();
	}

	public void clickOnbtnLogout() {
		btnLogout.click();
	}

}
