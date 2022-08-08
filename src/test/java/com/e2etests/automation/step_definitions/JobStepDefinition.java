package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_objects.JobPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobStepDefinition {
		private JobPage jobPage;

		public JobStepDefinition() {
			this.jobPage = new JobPage();
		}

		@When("Je clique sur le bouton job")
		public void jeCliqueSurLeBoutonJob() {
			jobPage.clickOnBtnJob();
		}

		@When("Je clique sur le bouton job titles")
		public void jeCliqueSurLeBoutonJobTitles() {
			jobPage.clickOnBtnJobTitle();
		}

		@When("Je clique sur le bouton Add")
		public void jeCliqueSurLeBoutonAdd() {
			jobPage.clickOnBtnAdd();
		}

		@Then("La page {string} s affiche")
		public void laPageSAffiche(String message_title) {
			String message = JobPage.addJobTitle.getText();
			Assert.assertTrue(message.contains(message_title));
		}

		@When("Je saisis le nom de metier dans le champ job title  {string}")
		public void jeSaisisLeNomDeMetierDansLeChampJobTitle(String job_title) {
			jobPage.fillJobTitle(job_title);
		}

		@When("Je saisis la description du metier dans le champ job description {string}")
		public void jeSaisisLaDescriptionDuMetierDansLeChampJobDescription(String job_description) {
			jobPage.fillJobDescription(job_description);
		}

		@When("Je fais joindre  un fichier du specification du metier dans le champ job specification {string}")
		public void jeFaisJoindreUnFichierDuSpecificationDuMetierDansLeChampJobSpecification(String job_specification) {
			jobPage.attachFileSpec(job_specification);
		}

		@When("Je saisis une note dans le champ note {string}")
		public void jeSaisisUneNoteDansLeChampNote(String note) {
			jobPage.fillJobNote(note);
		}

		@When("Je clique sur le bouton save")
		public void jeCliqueSurLeBoutonSave() {
			jobPage.clickOnBtnSave();
		}

		@Then("Je verifie que le metier a ete ajoute dans la liste {string}")
		public void jeVerifieQueLeMetierAEteAjouteDansLaListe(String jobTitle) {
			String newJob = JobPage.resultTable.getText();
			Assert.assertTrue(newJob.contains(jobTitle));
			System.out.println(" the new job has been successfully added");
		}
		

		@When("Je clique sur la case a cocher qui correspond au metier qu souhaite supprimer {string}")
		public void jeCliqueSurLaCaseACocherQuiCorrespondAuMetierQuSouhaiteSupprimer(String job_ToBeDeleted) {
			jobPage.clickOnJobToDelete(job_ToBeDeleted);
		}
		
		@When("Je clique sur le bouton Delete")
		public void jeCliqueSurLeBoutonDelete() {
			jobPage.clickOnBtnDelete();
		}
		
		@When("Je confirme la suppression du metier par un simple clic sur le bouton OK qui s affiche dans le boite de dialogue")
		public void jeConfirmeLaSuppressionDuMetierParUnSimpleClicSurLeBoutonOKQuiSAfficheDansLeBoiteDeDialogue() throws InterruptedException {
			jobPage.clickOnOKDialog();
		}
		
		@Then("Je verifie que le metier a ete bien supprime du tableau {string}")
		public void jeVerifieQueLeMetierAEteBienSupprimeDuTableau(String jobToDelete) {
			String result = JobPage.resultTable.getText();
			Assert.assertFalse(result.contains(jobToDelete));
			System.out.println("The selected job has been successfully deleted");
		}

	}
