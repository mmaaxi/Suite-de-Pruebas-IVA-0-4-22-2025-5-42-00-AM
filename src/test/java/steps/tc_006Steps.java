package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.tc_006Page;

public class tc_006Steps {
    tc_006Page page = new tc_006Page();

    @Given("The user exports the report and opens the Excel file")
    public void the_user_exports_the_report_and_opens_the_excel_file() {
        page.exportReport();
        page.openExcelFile();
    }

    @Then("The column 'IVA 0%' should be present in the file")
    public void the_column_IVA_0_should_be_present_in_the_file() {
        Assert.assertTrue(page.isIVA0ColumnPresent());
    }

    @Then("The values in the 'IVA 0%' column should be correct")
    public void the_values_in_the_IVA_0_column_should_be_correct() {
        Assert.assertTrue(page.areIVA0ValuesCorrect());
    }
}