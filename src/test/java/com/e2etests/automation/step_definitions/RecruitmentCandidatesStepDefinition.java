package com.e2etests.automation.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.e2etests.automation.page_objects.RecruitmentCandidatesPage;
import com.e2etests.automation.utility.Setup;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecruitmentCandidatesStepDefinition {
	
	private RecruitmentCandidatesPage recruitmentCandidatesPage;
	
	public RecruitmentCandidatesStepDefinition() {
		this.recruitmentCandidatesPage = new RecruitmentCandidatesPage();
	}
	
	@When("Je clique sur le module Recruitment")
	public void jeCliqueSurLeModuleRecruitment() {
		recruitmentCandidatesPage.clickOnRecruitMod();	    
	}
	
	/* Delete Candidates */
	
	@When("Je saisis le nom du candidat dans le champ Candidate Name {string}")
	public void jeSaisisLeNomDuCandidatDansLeChampCandidateName(String cand_Name) {
		recruitmentCandidatesPage.fillCandidateName(cand_Name);
	}
	
	@When("Je clique sur le bouton Search afin de lancer la recherche du candidat")
	public void jeCliqueSurLeBoutonSearchAfinDeLancerLaRechercheDuCandidat() {
		recruitmentCandidatesPage.clickOnBtnSearch();	   
	}
	
	@When("Je clique sur le checkbox qui correspond au candidat selectionne")
	public void jeCliqueSurLeCheckboxQuiCorrespondAuCandidatSelectionne() {
		recruitmentCandidatesPage.clickOnCheckbox();
	 
	}
	
	@When("Je clique sur le bouton Delete afin de supprimer le candidat de la liste")
	public void jeCliqueSurLeBoutonDeleteAfinDeSupprimerLeCandidatDeLaListe() {
		recruitmentCandidatesPage.clickOnDeleteCandidate();	   
	}
	
	@When("Je clique sur le bouton OK dans la boite de dialogue qui s affiche")
	public void jeCliqueSurLeBoutonOKDansLaBoiteDeDialogueQuiSAffiche() {
		recruitmentCandidatesPage.clickOnBtnDialog();	
	}
	
	@Then("Je verifie que le candidat selectionne a ete bien supprime de la liste {string}")
	public void jeVerifieQueLeCandidatSelectionneAEteBienSupprimeDeLaListe(String name) {
		WebElement candidate_Name = Setup.driver.findElement(By.xpath("//*[contains(text(),name)]"));
		boolean result1 = candidate_Name.isDisplayed();
		System.out.println(result1);
	   
	}
	
	/* Add Candidates */
	
	@When("Je clique sur le bouton Add afin d ajouter un nouveau candidat")
	public void jeCliqueSurLeBoutonAddAfinDAjouterUnNouveauCandidat() {
		recruitmentCandidatesPage.clickOnBtnAdd();
	   
	}
	
	@Then("Je me suis redirigee vers la page {string}")
	public void jeMeSuisRedirigeeVersLaPage(String message_add) {
		String message = RecruitmentCandidatesPage.add_Cand_Page.getText();
		Assert.assertTrue(message.contains(message_add));
	}
	
	@When("Je sais le prenom du candidat dans le champ First Name {string}")
	public void jeSaisLePrenomDuCandidatDansLeChampFirstName(String first_Name) {
		recruitmentCandidatesPage.fillFirstName(first_Name);
	}
	
	@When("Je saisis le deuxieme nom dans le champ Middle Name {string}")
	public void jeSaisisLeDeuxiemeNomDansLeChampMiddleName(String middle_Name) {
		recruitmentCandidatesPage.fillMiddleName(middle_Name);
	}
	
	@When("Je saisis le nom dans le champ Last Name {string}")
	public void jeSaisisLeNomDansLeChampLastName(String last_Name) {
		recruitmentCandidatesPage.fillLastName(last_Name);
	}
	
	@When("Je saisis l E-mail du nouveau candidat dans le champ E-mail {string}")
	public void jeSaisisLEMailDuNouveauCandidatDansLeChampEMail(String cand_Email) {
		recruitmentCandidatesPage.fillCandidateEmail(cand_Email);
	}
	
	@When("Je sais le numero de contact dans le champ Contact No {string}")
	public void jeSaisLeNuméroDeContactDansLeChampContactNo(String cand_Contact) {
		recruitmentCandidatesPage.fillCandidateContactNo(cand_Contact);
	}
	
	@When("Je saisis le titre de poste tout en utilisant la liste deroulante Job Vacancy {string}")
	public void jeSaisisLeTitreDePosteToutEnUtilisantLaListeDeroulanteJobVacancy(String job_Vacancy) {
		recruitmentCandidatesPage.selectJobVacancyFromDropDownList(job_Vacancy);
	}
	
	@When("Je fait joindre le curriculum vitae du candidat dans le champ Resume {string}")
	public void jeFaitJoindreLeCurriculumVitaeDuCandidatDansLeChampResume (String filePath) {
		recruitmentCandidatesPage.attachCandidateResume(filePath);	   
	}
	
	@When("Je saisis des mots cles dans le champ Keywords {string}")
	public void jeSaisisDesMotsClesDansLeChampKeywords(String cand_Keywords) {
		recruitmentCandidatesPage.fillCandidateKeywords(cand_Keywords);   
	}
	
	@When("Je saisis un commentaire dans le champ Comment {string}")
	public void jeSaisisUnCommentaireDansLeChampComment(String cand_comment) {
		recruitmentCandidatesPage.fillCandidateComment(cand_comment);
	}
	
	@When("Je saisis la date d application dans le champ Date of Application {string}")
	public void jeSaisisLaDateDApplicationDansLeChampDateOfApplication(String application_Date) {
		recruitmentCandidatesPage.fillApplicationDate(application_Date);
	}
	
	@When("Je clique sur le chekbox afin de confirmer le consentement de conserver les données")
	public void jeCliqueSurLeChekboxAfinDeConfirmerLeConsentementDeConserverLesDonnées() {
		recruitmentCandidatesPage.clickOnCheckboxConsentData();
	}
	
	@When("Je clique sur le bouton Save afin de sauvegarder les donnees saisies")
	public void jeCliqueSurLeBoutonSaveAfinDeSauvegarderLesDonneesSaisies() {
		recruitmentCandidatesPage.clickOnBtnSaveCandidateData();
	}
	
	@Then("Je verifie que le candidat a ete bien ajoute a la liste {string}")
	public void jeVerifieQueLeCandidatAEteBienAjouteALaListe(String message_confirm) {
		String message = RecruitmentCandidatesPage.confirm_Msg.getText();
		Assert.assertTrue(message.contains(message_confirm));
	}

	@When("Je clique sur le bouton Back pour que je puisse ajouter un nouveau candidat")
	public void jeCliqueSurLeBoutonBackPourQueJePuisseAjouterUnNouveauCandidat() {
	    recruitmentCandidatesPage.clickOnBtnBack();
	}
}
