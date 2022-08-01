package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.AdminPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminStepDefinition {
	
	private AdminPage adminPage;
	
	public AdminStepDefinition() {
		this.adminPage = new AdminPage();
	}
	
	@When("Je clique sur le bouton admin")
	public void jeCliqueSurLeBoutonAdmin() {
		adminPage.clickOnAdminModule();
	}
	
	@When("Je saisis {string} dans le champ Username")
	public void jeSaisisDansLeChampUsername(String name) {
		adminPage.fillUserNameAdmin(name);    
	}
	
	@When("Je clique sur le bouton Search")
	public void jeCliqueSurLeBoutonSearch() {
		adminPage.clickOnSearchBtn();
	}
	
	@Then("Je verifie la presence de l utilisateur dans le tableau")
	public void jeVerifieLaPresenceDeLUtilisateurDansLeTableau() {
	   
	}




}
