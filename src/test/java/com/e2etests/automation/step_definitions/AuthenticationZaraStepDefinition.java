package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_objects.AuthenticationZaraPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationZaraStepDefinition {
	
	private AuthenticationZaraPage authenticationZaraPage;
	
	public AuthenticationZaraStepDefinition () {
		this.authenticationZaraPage = new AuthenticationZaraPage();
	}
	
	@Given("Je me connecte sur l application Zara {string}")
	public void jeMeConnecteSurLApplicationZara(String url) {
	    authenticationZaraPage.goToUrl(url);
	}
	
	@When("Je clique sur se connecter")
	public void jeCliqueSurSeConnecter() throws InterruptedException {
		authenticationZaraPage.clickBtnSeConnecter();
		Thread.sleep(2000);
	}
	
	@Then("Je me redirige vers la page {string}")
	public void jeMeRedirigeVersLaPage(String string) {
	    String titlePage = AuthenticationZaraPage.pageMessage.getText();
	    Assert.assertEquals(titlePage, string);
	}
	
	@When("Je saisis l adresse mail {string}")
	public void jeSaisisLAdresseMail(String userEmail) {
	    authenticationZaraPage.fillUserEmail(userEmail);
	}
	
	@When("Je saisis le mot de passe de l utilisateur {string}")
	public void jeSaisisLeMotDePasseDeLUtilisateur(String userPassword) {
	    authenticationZaraPage.fillUserPassword(userPassword);
	}
	
	//@Then("Je me redirige vers mon compte zara {string}")
	//public void jeMeRedirigeVersMonCompteZara(String userName) {
		//String name = AuthenticationPage.username.getText();
		//Assert.assertEquals(name, userName);
	//}

}
