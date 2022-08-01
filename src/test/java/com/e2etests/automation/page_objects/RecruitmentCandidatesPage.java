package com.e2etests.automation.page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.e2etests.automation.utility.Setup;

public class RecruitmentCandidatesPage {

	/* @FindBy WebElement */
	
	/* Delete Candidates */
	@FindBy(how = How.ID, using = "menu_recruitment_viewRecruitmentModule")
	public static WebElement recruit_Mod;

	@FindBy(how = How.ID, using = "candidateSearch_candidateName")
	public static WebElement cand_Name;

	@FindBy(how = How.ID, using = "btnSrch")
	public static WebElement btnSearch;

	@FindBy(how = How.ID, using = "ohrmList_chkSelectAll")
	public static WebElement checkbox;

	@FindBy(how = How.ID, using = "btnDelete")
	public static WebElement btnDelete;

	@FindBy(how = How.ID, using = "dialogDeleteBtn")
	public static WebElement btnDialog;
	
	/* Add Candidates */
		
	@FindBy(how = How.ID, using = "btnAdd")
	public static WebElement btnADD;
	
	@FindBy(how = How.ID, using = "addCandidateHeading")
	public static WebElement add_Cand_Page;
	
	@FindBy(how = How.ID, using = "addCandidate_firstName")
	public static WebElement first_Name;
	
	@FindBy (how = How.ID, using="addCandidate_middleName")
	public static WebElement middle_Name;
	
	@FindBy (how = How.ID, using="addCandidate_lastName")
	public static WebElement last_Name;
	
	@FindBy (how = How.ID, using="addCandidate_email")
	public static WebElement cand_Email;
	
	@FindBy (how = How.ID, using ="addCandidate_contactNo")
	public static WebElement cand_Contact;
	
	@FindBy (how = How.ID, using ="addCandidate_vacancy")
	public static WebElement jobVacancy_DropDownList;
	
	@FindBy (how = How.ID, using="addCandidate_resume")
	public static WebElement cand_Resume;
	
	@FindBy (how = How.ID, using="addCandidate_keyWords")
	public static WebElement cand_Keywords;
	
	@FindBy (how = How.ID, using="addCandidate_comment")
	public static WebElement cand_comment;
	
	@FindBy (how = How.ID, using="addCandidate_appliedDate")
	public static WebElement application_Date;
	
	@FindBy (how = How.ID, using="addCandidate_consentToKeepData")
	public static WebElement checkbox_ConsentData;
	
	@FindBy (how = How.ID, using="btnSave")
	public static WebElement btnSav;
	
	@FindBy (how = How.XPATH, using ="//*[contains(text(),'Status: Application Initiated')]")
	public static WebElement confirm_Msg;
	
	@FindBy (how = How.ID, using="btnBack")
	public static WebElement btnBackk;
	
	public RecruitmentCandidatesPage() {
		PageFactory.initElements(Setup.driver, this);
	}
		
	/* Create Methods */

	/* Delete Candidates */

	public void clickOnRecruitMod() {
		recruit_Mod.click();
	}

	public void fillCandidateName(String txt_name) {
		cand_Name.sendKeys(txt_name);
	}

	public void clickOnBtnSearch() {
		btnSearch.click();
	}

	public void clickOnCheckbox() {
		checkbox.click();
	}

	public void clickOnDeleteCandidate() {
		btnDelete.click();
	}

	public void clickOnBtnDialog() {
		JavascriptExecutor execute = (JavascriptExecutor)Setup.driver;
		execute.executeScript("arguments[0].click();", btnDialog);
	}
	
	/* Add Candidates */
	
	public void clickOnBtnAdd () {
		btnADD.click();
	}
	
	public void fillFirstName (String txt_firstName) {
		first_Name.sendKeys(txt_firstName);
	}
	
	public void fillMiddleName (String txt_middleName) {
		middle_Name.sendKeys(txt_middleName);
	}
	
	public void fillLastName (String txt_lastName) {
		last_Name.sendKeys(txt_lastName);
	}
	
	public void fillCandidateEmail (String email) {
		cand_Email.sendKeys(email);
	}
	
	public void fillCandidateContactNo (String contact_No) {
		cand_Contact.sendKeys(contact_No);
	}
	
	public void selectJobVacancyFromDropDownList (String job_Vacancy) {
		Select select = new Select(jobVacancy_DropDownList);
		select.selectByVisibleText(job_Vacancy);
	}
	
	public void attachCandidateResume (String file_Path) {
		cand_Resume.sendKeys(file_Path);
	}
	
	public void fillCandidateKeywords (String keywords) {
		cand_Keywords.sendKeys(keywords);
	}
	
	public void fillCandidateComment (String txt_comment) {
		cand_comment.sendKeys(txt_comment);
	}
	
	public void fillApplicationDate (String appli_Date) {
		application_Date.clear();
		application_Date.sendKeys(appli_Date);
	}
	
	public void clickOnCheckboxConsentData() {
		JavascriptExecutor execute = (JavascriptExecutor)Setup.driver;
		execute.executeScript("arguments[0].click();", checkbox_ConsentData);
	}
	
	public void clickOnBtnSaveCandidateData () {
		btnSav.click();
	}
	
	public void clickOnBtnBack() {
		btnBackk.click();
	}
		

}
