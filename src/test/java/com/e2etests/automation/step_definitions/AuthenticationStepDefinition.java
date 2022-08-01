package com.e2etests.automation.step_definitions;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2etests.automation.page_objects.AuthenticationPage;
import com.e2etests.automation.utility.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationStepDefinition {
	public WebDriverWait wait;

	private AuthenticationPage authenticationPage;
	static Logger logger = Logger.getLogger(AuthenticationStepDefinition.class);

	public AuthenticationStepDefinition() {
		this.authenticationPage = new AuthenticationPage();
	}

	/* Login */

	@Given("Je me connecte a l application OrangeHRM")
	public void jeMeConnecteALApplicationOrangeHRM() {
		PropertyConfigurator.configure("src/main/java/Log4j.properties");
		authenticationPage.goToURL();
		logger.info("Je me connecte a l application OrangeHRM");
	}

	@When("Je saisis le username {string}")
	public void jeSaisisLeUsername(String username) {
		authenticationPage.fillUsername(username);
		logger.info("Je saisis le username");
	}

	@When("Je saisis le mot de passe {string}")
	public void jeSaisisLeMotDePasse(String password) {
		authenticationPage.fillPassword(password);
		logger.info("Je saisis le mot de passe");
	}

	@When("Je clique sur le bouton login")
	public void jeCliqueSurLeBoutonLogin() {
		authenticationPage.clickOnbtnLogin();
		logger.info("Je clique sur le bouton login");
	}

	@Then("Je me redirige vers la page home {string}")
	public void jeMeRedirigeVersLaPageHome(String msg) {
		String message = AuthenticationPage.homePage.getText();
		Assert.assertTrue(message.contains(msg));
		logger.info("Je me redirige vers la page home");
	}

	/* Use of Buzz's module */

	@When("Je clique sur le module Buzz")
	public void jeCliqueSurLeModuleBuzz() {
		authenticationPage.clickOnModBuzz();
	}

	@When("Je cree une mise a jour de statut dans le champ dont le placeholder est What s on your mind ? {string}")
	public void jeCreeUneMiseAJourDeStatutDansLeChampDontLePlaceholderEstWhatSOnYourMind(String userStatus) {
		authenticationPage.writeStatus(userStatus);
	}

	@When("Je clique sur le bouton Post")
	public void jeCliqueSurLeBoutonPost() {
		authenticationPage.clickOnBtnStatus();
	}

	@Then("Je verifie que mon statut est bien affiche sur la page {string}")
	public void jeVerifieQueMonStatutEstBienAfficheSurLaPage(String userStatus) {
		List<WebElement> statusWebElement = Setup.driver.findElements(By.xpath("//*[contains(text(),userStatus)]"));
		if (statusWebElement.size() != 0) {
			System.out.println("The user 's status has been displayed");
		} else {
			System.out.println("The user's status has not been displayed");
		}
	}

	/* Use of Upload Images module */

	@When("Je clique sur le module Upload Images")
	public void jeCliqueSurLeModuleUploadImages() {
		authenticationPage.clickOnUploadImageMod();	
	}
	
	@When("J ecris une breve description de l image a telecharger {string}")
	public void jEcrisUneBreveDescriptionDeLImageATelecharger(String imagDescrip) {
		authenticationPage.writeImageDescription(imagDescrip);
	}
	
	@When("Je clique sur le bouton Upload Images et je vais entrer l image {string}")
	public void jeCliqueSurLeBoutonUploadImagesEtJeVaisEntrerLImage(String imageFile) throws InterruptedException {
		authenticationPage.clickOnBtnUploadImage(imageFile);
		Thread.sleep(2000);
	}
	
	@When("Je clique sur le bouton Post du module Upload Images")
	public void jeCliqueSurLeBoutonPostDuModuleUploadImages() throws InterruptedException {
		authenticationPage.clickOnbtnPostImage();
		Thread.sleep(2000);
	}
	
	@Then("Je verifie que l image ainsi que sa description sont bien affichees {string}")
	public void jeVerifieQueLImageAinsiQueSaDescriptionSontBienAffichees(String imagDescrip) {
		List<WebElement> statusWebElement = Setup.driver.findElements(By.xpath("//*[contains(text(),imagDescrip)]"));
		if (statusWebElement.size() != 0) {
			System.out.println("The image description has been displayed");
		} else {
			System.out.println("The image description hasn't be displayed");
		}
	   
	}
	
	/* Use of share video's module */

	@When("Je clique sur le module Share Video")
	public void jeCliqueSurLeModuleShareVideo() {
		authenticationPage.clickOnShareVideoMod();
	}
	
	@When("Je copie l url de la video a partager {string}")
	public void jeCopieLUrlDeLaVideoAPartager(String urlVideo) {
		authenticationPage.fillUrlVideo(urlVideo);
	}
	
	@When("Je clique sur le bouton Save Video")
	public void jeCliqueSurLeBoutonSaveVideo() {
		//wait.until(ExpectedConditions.elementToBeClickable(AuthenticationPage.btnSaveVideo));
		authenticationPage.clickOnBtnSaveVideo();
	}
	
	@Then("Je verifie que la video est bien partagee {string}")
	public void jeVerifieQueLaVideoEstBienPartagee(String urlVideo) {
		List<WebElement> statusWebElement = Setup.driver.findElements(By.xpath("//*[contains(text(),urlVideo)]"));
		if (statusWebElement.size() != 0) {
			System.out.println("The video has been successfully shared");
		} else {
			System.out.println("The video has not been shared");
		}
	}

	/* Logout */

	@When("Je clique sur l icone logout")
	public void jeCliqueSurLIconeLogout() {
		authenticationPage.clickOnIconLogout();
	}

	@When("Je clique sur le bouton logout")
	public void jeCliqueSurLeBoutonLogout() {
		WebDriverWait wait1 = new WebDriverWait(Setup.driver, Duration.ofSeconds(5));
		AuthenticationPage.btnLogout = wait1.until(ExpectedConditions.visibilityOf(AuthenticationPage.btnLogout));
		authenticationPage.clickOnbtnLogout();
	}

	@Then("Je verifie que je me suis redirigee vers la page d acceuil Orange HRM")
	public void jeVerifieQueJeMeSuisRedirigeeVersLaPageDAcceuilOrangeHRM() {
		boolean result = AuthenticationPage.btnLogin.isDisplayed();
		if (result == true) {
			System.out.println("You have been succeffully logged out");
		} else {
			System.out.println("Failure to log out");
		}

	}

}
