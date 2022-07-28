package com.e2etests.automation.step_definitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2etests.automation.page_objects.AuthenticationPage;
import com.e2etests.automation.utility.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationStepDefinition {

	private AuthenticationPage authenticationPage;

	public AuthenticationStepDefinition() {
		this.authenticationPage = new AuthenticationPage();
	}

	/* Login */
	@Given("Je me connecte a l application OrangeHRM")
	public void jeMeConnecteALApplicationOrangeHRM() {
		authenticationPage.goToURL();
	}

	@When("Je saisis le username {string}")
	public void jeSaisisLeUsername(String username) {
		authenticationPage.fillUsername(username);
	}

	@When("Je saisis le mot de passe {string}")
	public void jeSaisisLeMotDePasse(String password) {
		authenticationPage.fillPassword(password);
	}

	@When("Je clique sur le bouton login")
	public void jeCliqueSurLeBoutonLogin() {
		authenticationPage.clickOnbtnLogin();
	}

	@Then("Je me redirige vers la page home {string}")
	public void jeMeRedirigeVersLaPageHome(String msg) {
		String message = AuthenticationPage.homePage.getText();
		Assert.assertTrue(message.contains(msg));
	}
	
	/* Logout */
	@When("Je clique sur l icone logout")
	public void jeCliqueSurLIconeLogout() {
		authenticationPage.clickOnIconLogout();	
	}

	@When("Je clique sur le bouton logout")
	public void jeCliqueSurLeBoutonLogout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Setup.driver,Duration.ofSeconds(5));
		AuthenticationPage.btnLogout = wait.until(ExpectedConditions.visibilityOf(AuthenticationPage.btnLogout));
		authenticationPage.clickOnbtnLogout();		
	}

}
