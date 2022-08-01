package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.SignInXlsxPage;
import com.e2etests.automation.utility.Constant;
import com.e2etests.automation.utility.ExcelUtils;

import io.cucumber.java.en.When;

public class SignInXlsxStepDefinition {
	
	private SignInXlsxPage signInXlsxPage;
	
	public SignInXlsxStepDefinition() {
		this.signInXlsxPage = new SignInXlsxPage();
	}
	
	
	@When("je m authentifie avec un fichier Excel")
	public void jeMAuthentifieAvecUnFichierExcel() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		signInXlsxPage.signInXlsx();
		ExcelUtils.setCellData("pass", 1, 3);
	}	

}
