package com.e2etests.automation.page_objects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utility.Setup;

public class JobPage {
	
	/* @FindBy WebElement */

	/* Add Job */

	@FindBy(how = How.ID, using = "menu_admin_Job")
	public static WebElement btnJob;

	@FindBy(how = How.ID, using = "menu_admin_viewJobTitleList")
	public static WebElement btnJobTitle;

	@FindBy(how = How.ID, using = "btnAdd")
	public static WebElement btnAdd;

	@FindBy(how = How.ID, using = "saveHobTitleHeading")
	public static WebElement addJobTitle;

	@FindBy(how = How.ID, using = "jobTitle_jobTitle")
	public static WebElement jobTitleTxt;

	@FindBy(how = How.ID, using = "jobTitle_jobDescription")
	public static WebElement jobDescriptionTxt;

	@FindBy(how = How.ID, using = "jobTitle_jobSpec")
	public static WebElement jobSpecFile;

	@FindBy(how = How.ID, using = "jobTitle_note")
	public static WebElement jobNoteTxt;

	@FindBy(how = How.ID, using = "btnSave")
	public static WebElement btnSave;

	@FindBy(how = How.ID, using = "resultTable")
	public static WebElement resultTable;

	@FindBy(how = How.ID, using = "btnDelete")
	public static WebElement btnDelete;

	@FindBy(how = How.ID, using = "dialogDeleteBtn")
	public static WebElement btnOKDialog;

	@FindBy(how = How.ID, using = "successBodyDelete")
	public static WebElement mesgConfir;

	@FindBy(how = How.XPATH, using = "//input[@name='chkSelectRow[]']")
	public static List<WebElement> List_chekboxes;

	@FindBy(how = How.TAG_NAME, using = "tr")
	public static List<WebElement> rows;

	public JobPage() {
		PageFactory.initElements(Setup.driver, this);
	}
	
	/* Create Methods */

	/* Add Job */

	public void clickOnBtnJob() {
		btnJob.click();
	}

	public void clickOnBtnJobTitle() {
		btnJobTitle.click();
	}

	public void clickOnBtnAdd() {
		btnAdd.click();
	}

	public void fillJobTitle(String job_title) {
		jobTitleTxt.sendKeys(job_title);
	}

	public void fillJobDescription(String job_description) {
		jobDescriptionTxt.sendKeys(job_description);
	}

	public void attachFileSpec(String job_specification) {
		jobSpecFile.sendKeys(job_specification);
	}

	public void fillJobNote(String note) {
		jobNoteTxt.sendKeys(note);
	}

	public void clickOnBtnSave() {
		btnSave.click();
	}

	/* Delete Job */
	JavascriptExecutor execute = (JavascriptExecutor) Setup.driver;

	public void clickOnJobToDelete(String job_To_Delete) {

		for (int i = 1; i <= rows.size() - 1; i++) {
			if (rows.get(i).getText().equalsIgnoreCase(job_To_Delete)) {
				execute.executeScript("arguments[0].click();", List_chekboxes.get(i - 1));
			}

		}
	}

	public void clickOnBtnDelete() {
		btnDelete.click();
	}

	public void clickOnOKDialog() {
		btnOKDialog.click();
	}

}
