package StepDefinition;

import Helpers.Base;
import Pages.DTCHomePage;
import Utility.Log;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Steps {

    DTCHomePage hp = new DTCHomePage();
    Base b = new Base();
    String balanceBefore = "";
    String amount = "";
    String rateOfExchange = "";
    String balanceAffter = "";
    Double balanceRegular;
    String Regular = "";
    String Amount_in_table = "";
    String Amount_in_document = "";
    String Amount_in_table_last = "";

    @Given("^Open the Chrome and open \"([^\"]*)\" page$")
    public void open_Chrome_and_launch_the_application(String url) throws Throwable {
        hp.openPage(url);
    }

    @Given("^Open the Chrome and enter url from Excel \"([^\"]*)\" columName \"([^\"]*)\"$")
    public void open_the_Chrome_and_launch_the_application(String rowindex, String columname) throws Throwable {
        String url = b.getDataFromHashDatamap(rowindex, columname);
        hp.openPage(url);
    }

    @Given("^Open the Chrome and open page from configuration column \"([^\"]*)\"$")
    public void open_the_Chrome_and_launch_the_application_from_configuration(String configurationColumn) throws Throwable {
        String url = Base.testWebSite;
        hp.openPage(url);
    }

    @Then("^Assert by element id \"([^\"]*)\"$")
    public void assert_element_by_id(String text) throws Throwable {
        hp.assertElementByid(text);
    }

    @Then("^Assert by span data bind \"([^\"]*)\"$")
    public void assert_by_span_data_bind(String text) throws Throwable {
        hp.assertBySpanDataBind(text);
    }

    @Then("^Assert text from Excel \"([^\"]*)\" columnName \"([^\"]*)\" by span data bind \"([^\"]*)\"$")
    public void assert_text_from_excel_columnName_by_span_data_bind(String rowindex, String columnName, String elementName ) throws Throwable {
        String text = b.getDataFromHashDatamap(rowindex, columnName);
        hp.assertBySpanDataBindTextCompare(elementName, text);
    }
    @Then("^Assert text from Excel \"([^\"]*)\" columnName \"([^\"]*)\" by data bind \"([^\"]*)\" after text \"([^\"]*)\"$")
    public void assert_text_from_excel_columnName_by_data_bind_after_text(String rowindex, String columnName, String elementName, String aElementName ) throws Throwable {
        String text = b.getDataFromHashDatamap(rowindex, columnName);
        hp.assertByDataBindAfterTextTextCompare(elementName, text, aElementName);
    }

    @Then("^Click on input field by name \"([^\"]*)\"$")
    public void click_input_name(String text) throws Throwable {
        hp.clickInputWithName(text);
    }

    @Then("^Clear text in \"([^\"]*)\" input$")
    public void ClearTextInInput(String text) throws Throwable {
        hp.ClearTextInput(text);

    }

    @Then("^Enter text from Excel \"([^\"]*)\" columnName \"([^\"]*)\" in \"([^\"]*)\" input$")
    public void enter_text_in_input(String rowindex, String columnName, String elementName) throws Throwable {
        String text = b.getDataFromHashDatamap(rowindex, columnName);
        hp.enterTextInFieldByClassName(text, columnName, elementName);
        amount = text;

    }

    @Then("^Enter text from Excel \"([^\"]*)\" columnName \"([^\"]*)\" in \"([^\"]*)\" input field$")
    public void enter_text_in_input_field(String rowindex, String columnName, String elementName) throws Throwable {
        String text = b.getDataFromHashDatamap(rowindex, columnName);
        hp.enterTextInFieldByClassName2(text, columnName, elementName);
        amount = text;

    }

    @Then("^Select text from Excel \"([^\"]*)\" columnName \"([^\"]*)\" in \"([^\"]*)\" dropdownMenu$")
    public void select_text_in_dropdown(String rowindex, String columnName, String elementName) throws Throwable {
        String text = b.getDataFromHashDatamap(rowindex, columnName);
        // hp.selectTextInDropdownMenu(text, columnName, elementName);
        hp.selectTextInDropMenuWhitClick(text, columnName, elementName);

    }

    @Then("^Select option from Excel \"([^\"]*)\" columnName \"([^\"]*)\" in \"([^\"]*)\" dropdown menu JavaScript$")
    public void selectOptionInMenu(String row, String column, String elementName) throws Throwable {
        String text = b.getDataFromHashDatamap(row, column);
        hp.selectTextInFieldByElementNameJavascript(text, column, elementName);
    }

    @Then("^Enter text from Excel \"([^\"]*)\" columnName \"([^\"]*)\" in \"([^\"]*)\" field$")
    public void enter_text_in_field(String rowindex, String columnName, String elementName) throws Throwable {
        String text = b.getDataFromHashDatamap(rowindex, columnName);
        hp.enterTextInFieldByElementName(text, columnName, elementName);
    }

    @Then("^Click on input field Email$")
    public void click_input_email() throws Throwable {
        hp.clickInputEmail();
    }

    @Then("^Click on element by class \"([^\"]*)\"$")
    public void click_on_element_by_class(String text) throws Throwable {
        hp.clickOnElementByClass(text);
    }

    @Then("^Click on element by class \"([^\"]*)\" field$")
    public void click_on_element_by_class_field(String text) throws Throwable {
        hp.clickOnElementByClass2(text);
    }

    @Then("^Click on element by classS \"([^\"]*)\"$")
    public void click_on_element_by_classS(String text) throws Throwable {
        hp.clickOnElementByClassS(text);
    }

    @Then("^Click on element by parent element \"([^\"]*)\"$")
    public void click_on_element_by_parent_element(String text) throws Throwable {
        hp.clickOnElementByParetnElemenet(text);

    }

    @Then("^Click on element by text \"([^\"]*)\"$")
    public void click_on_element_by_text(String text) throws Throwable {
        hp.clickOnElementByText(text);
    }

    @Then("^Click on element by text \"([^\"]*)\" field$")
    public void click_on_element_by_text_field(String text) throws Throwable {
        hp.clickOnElementByText2(text);
    }

    @Then("^Wait for \"([^\"]*)\" seconds$")
    public void wait_for_seconds(String text) throws Throwable {
        hp.waitForSeconds(text);
    }

    @Then("^Click on element by text \"([^\"]*)\" after text \"([^\"]*)\"$")
    public void click_on_element_by_text_after_text(String text, String atext) throws Throwable {
        hp.clickOnElementByTextAfterText(text, atext);
    }

    @Then("^Click on link text \"([^\"]*)\"$")
    public void click_on_link_text(String text) throws Throwable {
        hp.clickOnElementByLinkText(text);
    }

    @Then("^Click on element by span text \"([^\"]*)\"$")
    public void click_on_element_by_span_text(String text) throws Throwable {
        hp.clickOnElementBySpanText(text);
    }
    @Then("^Click on element by class \"([^\"]*)\" after text \"([^\"]*)\"$")
    public void click_on_element_by_class_after_text(String text, String atext) throws Throwable {
        hp.clickOnElementByClassAfterText(text, atext);
    }

    @Then("^Click on element by text \"([^\"]*)\" after class \"([^\"]*)\"$")
    public void click_on_element_by_text_after_class(String text, String atext) throws Throwable {
        hp.clickOnElementByTextAfterClass(text, atext);
    }

    @Then("^Assert by span text \"([^\"]*)\"$")
    public void assert_on_element_by_span_text(String text) throws Throwable {
        hp.assertOnElementBySpanText(text);
    }

    @Then("^Assert by header text \"([^\"]*)\"$")
    public void assert_by_header_text(String text) throws Throwable {
        hp.assertElementByHeaderText(text);
    }

    @Then("^Assert by header text \"([^\"]*)\" without wait$")
    public void assert_by_header_text_without_wait(String text) throws Throwable {
        hp.assertElementByHeaderTextNoWait(text);
    }

    @Then("^Assert by p data bind \"([^\"]*)\" after text \"([^\"]*)\"$")
    public void assert_by_p_data_bind_after_text(String text, String atext) throws Throwable {
        hp.assertPDataBindAfterText(text, atext);
    }

    @Then("^Assert by class \"([^\"]*)\" after text \"([^\"]*)\"$")
    public void assert_by_class_after_text(String text, String atext) throws Throwable {
        hp.assertClassAfterText(text, atext);
    }

    @Then("^Assert by text \"([^\"]*)\" after class \"([^\"]*)\"$")
    public void assert_by_text_after_class(String text, String atext) throws Throwable {
        hp.assertTextAfterClass(text, atext);
    }

    @Then("^Assert by div text \"([^\"]*)\"$")
    public void assert_by_div_text(String text) throws Throwable {
        hp.assertElementByDivText(text);
    }

    @Then("^Assert element by name \"([^\"]*)\"$")
    public void assert_element_by_name(String text) throws Throwable {
        hp.assertElementByName(text);
    }

    @Then("^Assert by class \"([^\"]*)\"$")
    public void assert_element_by_class(String text) throws Throwable {
        hp.assertElementByClassValue(text);
    }

    @Then("^reCAPTCHA$")
    public void recaptcha() throws Throwable {
        hp.reCaptcha();
    }

    @Then("^Save transaction before exchange$")
    public void save_transaction_before_exchange() throws Throwable {
        balanceBefore = hp.SaveTransactionBeforeExchange();
        Log.info("!!!!!!!!!!!Available balance before exchange: " + balanceBefore + " !!!!!!!!!!!!!!!!!");

    }

    @Then("^Save transaction affter exchange$")
    public void save_transaction_affter_exchange() throws Throwable {
        balanceAffter = hp.SaveTransactionAffterExchange();
        Log.info("!!!!!!!!!!!Available balance affter exchange: " + balanceAffter + " !!!!!!!!!!!!!!!!!");

    }

    @Then("^Save transaction before exchange by class \"([^\"]*)\"$")
    public void save_element_by_class(String text) throws Throwable {
        balanceBefore = hp.saveElementByClass(text);
        Log.info("!!!!!!!!!!!Available balance before exchange: " + balanceBefore + " !!!!!!!!!!!!!!!!!");

    }

    @Then("^Save transaction affter exchange by class \"([^\"]*)\" and wait$")
    public void save_element_by_class_and_wait(String text) throws Throwable {
        balanceAffter = hp.saveElementByClass(text);
        Log.info("!!!!!!!!!!!Available balance affter exchange: " + balanceBefore + " !!!!!!!!!!!!!!!!!");
    }

    @Then("^Save transaction affter exchange by class \"([^\"]*)\"$")
    public void save_element_by_class_(String text) throws Throwable {
        balanceAffter = hp.saveElementByClass(text);
        Log.info("!!!!!!!!!!!Available balance affter exchange: " + balanceBefore + " !!!!!!!!!!!!!!!!!");
    }

   /* @Then("^Save transaction affter exchange by class \"([^\"]*)\"$")
    public void save_element_by_class_(String text) throws Throwable
    {
        balanceAffter = hp.saveElementByClass(text);
    }*/

    @Then("^Save rate of exchange$")
    public void save_rate_of_exchange() throws Throwable {
        rateOfExchange = hp.SaveRateOfExchange();

    }

    @Then("^Save rate of exchange by span class \"([^\"]*)\"$")
    public void save_element_by_span_class(String text) throws Throwable {
        rateOfExchange = hp.saveElementBySpanClass(text);

    }

    @Then("^Assert correct exchange$")
    public void assert_correct_exchange() throws Throwable {
        balanceRegular = b.rate_of_exchange(balanceBefore, rateOfExchange, amount, balanceAffter);
        if (Math.abs(balanceRegular) < 0.0001) //balanceRegular == 0.0
        {
            Log.info("!!!!!!!!!!!!!!!!Exchange TRUE!");
        } else {

            Log.info("!!!!!!!!!!!!!!Exchange FAILD!");
        }


    }

    @Then("^Assert file with name from Excel \"([^\"]*)\" columName \"([^\"]*)\"$")
    public void readDownload(String rowindex, String columName) throws Throwable {
        String fileName = b.getDataFromHashDatamap(rowindex, columName);
        hp.assertsFileDownload(fileName);
    }

    @Then("^Click on element by span class \"([^\"]*)\"$")
    public void click_on_element_by_span_class(String text) throws Throwable {
        hp.clickOnElementBySpanClass(text);
    }

    @Then("^Hover button by span class \"([^\"]*)\"$")
    public void hoverButton(String text) throws Throwable {
        hp.hoverOnElementBySpanClass(text);
    }

    @Then("^Enter text from Excel \"([^\"]*)\" columnName \"([^\"]*)\" in \"([^\"]*)\" calendar$")
    public void clickYearMonth(String rowindex, String columnName, String elementName) throws Throwable {
        String text = b.getDataFromHashDatamap(rowindex, columnName);
        hp.selectYearMonthInCalendar(text, columnName, elementName);

    }

    @Then("^Enter text from Excel \"([^\"]*)\" columnName \"([^\"]*)\" in \"([^\"]*)\" calendar by link$")
    public void clickDay(String rowindex, String columnName, String elementName) throws Throwable {
        String text = b.getDataFromHashDatamap(rowindex, columnName);
        //hp.selectYearMonthInCalendar(text, columnName, elementName);
        hp.selectDayInCalendar(text, columnName, elementName);

    }

    @Then("^Click on button \"([^\"]*)\" from dropdown menu$")
    public void ClickButtonDropdownMenu(String text) throws Throwable {

        hp.clickButtonDropdownMenu(text);
    }

    @Then("^Click on option from Excel \"([^\"]*)\" columnName \"([^\"]*)\" from dropdown menu$")
    public void ClickButtonDropDownMenu(String rowindex, String columnName) throws Throwable {

        String text = b.getDataFromHashDatamap(rowindex, columnName);
        hp.clickOptionDropdownMenu(text);
    }



    @Then("^Assert validation message from Excel \"([^\"]*)\" columName \"([^\"]*)\"$")
    public void ValidationMessage(String rowindex, String columnName) throws Throwable {
        String text = b.getDataFromHashDatamap(rowindex, columnName);
        hp.AssertValidationMessage(text);
    }

    @Then("^Click on element by link \"([^\"]*)\" text$")
    public void ClickButtonText(String text) throws Throwable {
        hp.ClickButton(text);
    }


    @Then("^Select last amount$")
    public void selectLastAmount() throws Throwable {
        hp.selectLastAmout();
    }


    @Then("^Save input amount the first row in table \"([^\"]*)\"$")
    public void SaveFisrtAmoutInTable(String text) throws Throwable {
        Amount_in_table = hp.saveFirstAmoutInRow(text);
    }

    @Then("^Save input amount the last row in table \"([^\"]*)\"$")
    public void SaveLastAmoutInTable(String text) throws Throwable {
        Amount_in_table_last = hp.saveLastAmoutInRow(text);

    }


    @Then("^Hover button$")
    public void HoverButton() throws Throwable {
        hp.HoverButon();

    }

    @Then("^Click on element Print$")
    public void ClickOnElement() throws Throwable {
        hp.ClickPrint();

    }

    @Then("^Save input amount in PrintDocument$")
    public void SaveAmountPrint() throws Throwable {
        hp.SaveAmountPrintDocument();

    }

    @Then("^Save row in Document$")
    public void SaveRowPrint() throws Throwable {
        Amount_in_document = hp.SaveRowPrintDocument();

    }

    @Then("^Save last row in Document$")
    public void SaveLastRowPrint() throws Throwable {
        Amount_in_document = hp.SaveLastRowPrintDocument();

    }

    @Then("^Hover checkbox$")
    public void hoverCheckbox() throws Throwable {
        hp.HoverCheckbox();

    }

    @Then("^Hover accounts in the list$")
    public void hover_account_in_the_list() throws Throwable {
        hp.HoverAccountInTheList();
    }

    @Then("^Hover account list$")
    public void hover_account_list() throws Throwable {
        hp.HoverAccountList();
    }

    @Then("^Assert amount equals$")
    public void AssertEquals() throws Throwable {
        if (Amount_in_table.equals(Amount_in_document)) {
            Log.info("Prvi iznosi su jednaki!!!!!");
        } else
            Log.info("Prvi iznosi nisu jednaki!!!!!!!!!!");
        if (Amount_in_table_last.equals(Amount_in_document)) {
            Log.info("Zadnji iznosi su jednaki!!!!!");
        } else
            Log.info("Zadnji iznosi nisu jednaki!!!!!!!!!!");
    }

    @Then("^Hover button change$")
    public void HoverChange() throws Throwable {
        hp.HoverChangeButton();

    }

    @Then("^Upload picture on element \"([^\"]*)\"$")
    public void assertValidationMessages(String elementName) throws Throwable {
        hp.uploadPictureToelement(elementName);
    }

    @Then("^Sing out button back to top$")
    public void SingOutButton_back_to_top() throws Throwable {
        hp.SingoutButtonBackToTop();

    }

    @Then("^Sing out button$")
    public void SingOutButton() throws Throwable {
        hp.SingoutButton();

    }

    @Then("^Assert picture on page$")
    public void PictureAssert() throws Throwable {
        hp.AssertPictureOnPage();

    }

    @Then("^Assert by div style$")
    public void DivStyle() throws Throwable {
        hp.AssertDivStyle();

    }
    /*@Then("^Assert validation messages from Excel \"([^\"]*)\" columnName from configuration column \"([^\"]*)\"$")
    public void assertValidationMessagesFromConfig(String rowindex, String configurationColumn) throws Throwable{
        String columnName = ExcelDataForTests.readDataFromExcelUsingColumnName(configurationColumn,"testdata/configuration.xlsx","Sheet1");
        String text = b.getDataFromHashDatamap(rowindex, columnName);
        hp.AssertValidationMessage(text);
    }
*/

}
