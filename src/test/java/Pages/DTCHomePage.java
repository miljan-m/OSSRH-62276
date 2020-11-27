package Pages;


import Helpers.Base;
import Utility.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DTCHomePage extends Base {

    By recaptcha = By.xpath("(//iframe)[1]");
    By inputEmail = By.xpath("//input[@name='email']");
    By transaction_details_button = By.xpath("//*[text()='Detalji transakcije']/following-sibling::button");
    By hover_checkbox = By.xpath("//*[@class='custom-checkbox-wrapper changeDebtorName col']");
    By hoveraccountinthelist= By.xpath("//i[@class='icon-list-1 tooltip']");
    By hoveraccountlist = By.xpath("//div[@class='list-item row-1'][1]//div[@class='col col-ls-11 col-ms-5 no-border button-col']//span[@class='big pointer']");
    By hoverchangebutton = By.xpath("//a[@data-bind='click: triggerGoToProfile']");
    By clickprint = By.xpath("//a//*[@class='icon-mail-1 tooltip']");
    By backtotop = By.xpath("//a[text()='Nazad na vrh']");
    By back = By.xpath("//a[@class='logout power-icon tooltip']");
    By savetransaction_part1=By.xpath("//div[@class='list-item row-1 selected'][1]//div[@class='col col-ls-11 col-ms-5 no-border button-col']//span[@class='big pointer']");
    By savetransaction_part2 = By.xpath("//div[@class='list-item row-1 selected'][1]//div[@class='col col-ls-11 col-ms-5 no-border button-col']//span[@class='big pointer']/following-sibling::span");
    By print_document = By.xpath("//span[@data-bind=\"text: S.Globalization.formatAmount($data.DebitAmount)\"]");
    By first_row_in_document = By.xpath("//body//div/table/tbody[@data-bind=\"foreach: $data[1]\"]/tr[1]//td[3]//span");
    By last_row_in_document = By.xpath("//tr[last()]//../td[last()]/../ancestor::td[last()]/div/table/tbody[2]/tr[last()]/td/table/tbody/tr/td[3]/span");
    By rate_of_exchange = By.xpath("//span[text()='Iznos u RSD']/following-sibling::span");
    By next_button = By.xpath("//*[contains(@class,'pagerButton ui-state-default next')]");
    By ime = By.xpath("//input[@name='name']");
    By amount = By.xpath("//input[@name='name']");

    public void openPage(String url) throws Throwable {
        OpenURL(url);
    }

    public void assertElementByid(String text) throws Throwable {
        WebElement element = CreateElementById(text);
        AssertIfDisplayed(element, text);
    }

    public void assertBySpanDataBind(String text) throws Throwable {
        WebElement element = CreateBySpanDataBind(text);
        AssertIfDisplayedText(element, text);
    }

    public void assertBySpanDataBindTextCompare(String elementName, String text) throws Throwable {
        WebElement element = CreateBySpanDataBind(elementName);
        AssertIfTextIsEqual(element, text);
    }

    public void assertByDataBindAfterTextTextCompare(String elementName, String text, String atext) throws Throwable {
        WebElement element = CreateDataBindAfterText(elementName, atext);
        AssertIfTextIsEqual(element, text);
    }

    public void assertElementByName(String text) throws Throwable {
        WebElement element = CreateElementByName(text);
        AssertIfDisplayed(element, text);

    }
    public void assertElementById(String text) throws Throwable {
        WebElement element = CreateElementById(text);
        AssertIfDisplayed(element,text);
    }

    public void assertElementByClass(String text) throws Throwable {
        WebElement element = CreateElementByClass(text);
        AssertIfDisplayed(element, text);
    }

    public void assertElementByClassValue(String text) throws Throwable {
        WebElement element = CreateElementByClass(text);
        AssertIfDisplayedValue(element, text);
    }

    public void clickInputWithName(String text) throws Throwable {
        WebElement element = CreateElementByName(text);
        ScrollIntoView(element);
        ClickOnElement(element, text);
    }

    public void ClearTextInput(String text) throws Throwable {
        WebElement element = CreateElementByClassS(text);
        element.clear();
    }

    public void enterTextInFieldByElementName(String text, String columName, String elementName) throws Throwable {
        WebElement element = CreateElementByName(elementName);
        ScrollIntoView(element);
        EnterTextInElement(element, columName, text);
    }

    public void selectTextInDropMenuWhitClick(String text, String columeName, String elementName) throws Throwable {
        WebElement element = CreateElementByClassS(elementName);
        //element.click();
        ClickOnElement(element,"DropMenu");
        WebElement webElement = CreateElementByText(text);
        ClickOnElement(webElement,"TextInDropMenu");
        //Base.WaitForElement(webElement, text);
        //webElement.click();
    }

    public void selectYearMonthInCalendar(String text, String columName, String elementName) throws Throwable {
        WebElement select = CreateElementByClassS(elementName);//ovo je class gde su sve godine
        ClickOnElement(select,"godine");
       // select.click();
        WebElement year = CreateElementByText(text); //ovo je *[text()='2019']
        ClickOnElement(year,"godina");
        //Base.WaitForElement(year, text);
        //year.click();
    }

    public void selectDayInCalendar(String text, String columName, String elementName) throws Throwable {
        //WebElement select
        WebElement day = CreateElementByLinkText(text);
        ClickOnElement(day,"dan");
       // day.click();
    }

    public void ClickButton(String text) throws Throwable {
        WebElement button = CreateElementByLinkText(text);
        ClickOnElement(button,"dugme");
        //button.click();
    }

    public void enterTextInFieldByClassName(String text, String columName, String elementName) throws Throwable {
        WebElement element = CreateElementByClass(elementName);
        ScrollIntoView(element);
        EnterTextInElement(element, columName, text);
    }

    public void enterTextInFieldByClassName2(String text, String columName, String elementName) throws Throwable {
        WebElement element = CreateElementByClass2(elementName);
        ScrollIntoView(element);
        EnterTextInElement(element, columName, text);
    }


    public void clickInputEmail() throws Throwable {
        WebElement element = CreateElementByXPath(inputEmail);
        ClickOnElement(element, "E-mail");
        //Thread.sleep(5000);
    }


    public void assertElementByHeaderText(String text) throws Throwable {
        WebElement element = CreateElementByText(text);
        ScrollIntoView(element);
        AssertIfDisplayed(element, text);
        Thread.sleep(1000);
    }

    public void assertElementByHeaderTextNoWait(String text) throws Throwable {
        WebElement element = CreateElementByText(text);
        ScrollIntoView(element);
        AssertIfDisplayed(element, text);
    }

    public void assertElementByDivText(String text) throws Throwable {
        WebElement element = CreateElementByDivText(text);
        ScrollIntoView(element);
        AssertIfDisplayed(element, text);
        Thread.sleep(5000);
    }

    public void assertPDataBindAfterText(String text, String atext) throws Throwable {
        WebElement element = CreatePDataBindAfterText(text, atext);
        ScrollIntoView(element);
        AssertIfDisplayedText(element, text);
    }

    public void assertClassAfterText(String text, String atext) throws Throwable {
        WebElement element = CreateClassAfterText(text, atext);
        ScrollIntoView(element);
        AssertIfDisplayedText(element, text);
    }

    public void assertTextAfterClass(String text, String atext) throws Throwable {
        WebElement element = CreateTextAfterClass(text, atext);
        ScrollIntoView(element);
        AssertIfDisplayedText(element, text);
    }

    public void clickOnElementByText(String text) throws Throwable {
        WebElement element = CreateElementByText(text);
        ScrollIntoView(element);
        ClickOnElement(element, text);
    }

    public void clickOnElementByText2(String text) throws Throwable {
        WebElement element = CreateElementByText2(text);
        ScrollIntoView(element);
        ClickOnElement(element, text);
    }

    public void clickOnElementByTextAfterText(String text, String atext) throws Throwable {
        WebElement element = CreateElementByTextAfterText(text, atext);
        ScrollIntoView(element);
        ClickOnElement(element, text);
    }

    public void clickOnElementByClass(String text) throws Throwable {
        WebElement element = CreateElementByClass(text);
        ScrollIntoView(element);
        ClickOnElement(element, text);
        Thread.sleep(5000);
    }

    public void clickOnElementByClass2(String text) throws Throwable {
        WebElement element = CreateElementByClass2(text);
        ScrollIntoView(element);
        ClickOnElement(element, text);
        Thread.sleep(5000);
    }

    public void waitForSeconds(String text) throws Throwable {
        int seconds=Integer.parseInt(text);
        Thread.sleep(seconds * 1000);
    }

    public void clickOnElementByClassS(String text) throws Throwable {
        WebElement element = CreateElementByClassS(text);
        ScrollIntoView(element);
        ClickOnElement(element, text);
        Thread.sleep(5000);
    }

    public void clickOnElementBySpanText(String text) throws Throwable {
        WebElement element = CreateParentElementBySpanText(text);
        Thread.sleep(5000);
        ClickOnElement(element, text);

    }

    public void clickOnElementByLinkText(String text) throws Throwable {
        WebElement element = CreateElementByLinkText(text);
        ClickOnElement(element, text);
        Thread.sleep(5000);
    }

    public void clickOnElementBySpanClass(String text) throws Throwable {
        WebElement element = CreateElementByClassS(text);
        ScrollIntoView(element);
        ClickOnElement(element, text);
        Thread.sleep(5000);
    }

    public void clickOnElementByParetnElemenet(String text) throws Throwable {

        WebElement element = CreateParentElementBySpanText(text);
        ScrollIntoView(element);
        ClickOnElement(element, text);
        Thread.sleep(5000);

    }

    public void clickOnElementByClassAfterText(String text, String atext) throws Throwable {
        WebElement element = CreateClassAfterText(text, atext);
        Thread.sleep(5000);
        ClickOnElement(element, text);

    }

    public void clickOnElementByTextAfterClass(String text, String atext) throws Throwable {
        WebElement element = CreateTextAfterClass(text, atext);
        Thread.sleep(5000);
        ClickOnElement(element, text);
    }

    public void hoverOnElementBySpanClass(String text) throws Throwable {
        //Actions actions = new Actions(driver);
        //ScrollIntoView(element);
        //actions.moveToElement(element).click().build().perform();
        WebElement element = CreateElementByClassS(text);
        HoverElement(element);
    }

    public void HoverButon() throws Throwable {

        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().build().perform();
        WebElement element = driver.findElement(transaction_details_button);
        HoverElement(element);

    }

    public void HoverCheckbox() throws Throwable {

        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().build().perform();
        WebElement element = driver.findElement(hover_checkbox);
        HoverElement(element);
    }
    public void HoverAccountInTheList() throws Throwable{

        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().build().perform();
        WebElement element = driver.findElement(hoveraccountinthelist);
        HoverElement(element);
    }

    public void HoverAccountList() throws Throwable{
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().build().perform();
        WebElement element = driver.findElement(hoveraccountlist);
        HoverElement(element);

    }
    public void HoverChangeButton() throws Throwable {
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().build().perform();
        WebElement element = driver.findElement(hoverchangebutton);
        HoverElement(element);
    }

    public void ClickPrint() throws Throwable {
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().build().perform();
        WebElement element = driver.findElement(clickprint);
        HoverElement(element);
    }

    public void SingoutButtonBackToTop() throws Throwable {
        //Actions actions = new Actions(driver);
        WebElement nazad = driver.findElement(backtotop);
        ClickOnElement(nazad,"Idi na vrh");
        //nazad.click();
        WebElement element = driver.findElement(back);
        ScrollIntoView(element);
        //actions.moveToElement(element).click().build().perform();
        HoverElement(element);
    }

    public void SingoutButton() throws Throwable{
        //Actions actions = new Actions(driver);
        WebElement element = driver.findElement(back);
        ScrollIntoView(element);
        HoverElement(element);
        //actions.moveToElement(element).click().build().perform();
    }

    public String SaveTransactionAffterExchange() throws Throwable{
        WebElement element_part1 = driver.findElement(savetransaction_part1);
        WebElement element_part2 = driver.findElement(savetransaction_part2);
        String acount = GetText(element_part1) + GetText(element_part2);
        //String acount = element_part1.getText()+element_part2.getText();
        Log.info("!!!!!AvailableBalance affter exchange: "+acount+"!!!!!!!!!");
        return acount;

    }


    public String SaveTransactionBeforeExchange() throws Throwable{
        WebElement element_part1 = driver.findElement(savetransaction_part1);
        WebElement element_part2 = driver.findElement(savetransaction_part2);
        String acount = GetText(element_part1) + GetText(element_part2);
        //String acount = element_part1.getText()+element_part2.getText();
        Log.info("!!!!!AvailableBalance before exchange: "+acount+"!!!!!!!!!");
        return acount;
    }

    public String saveElementByClass(String text) throws Throwable {
        WebElement element = CreateElelementBySpanClass(text);
        WebElement element1 = CreateNextElementBySpanClass(text);
        String balance = GetText(element) + GetText(element1);
        //String balance = element.getText() + element1.getText();
        Log.info("!!!!!AvailableBalance before exchange: " + balance + "!!!!");
        return balance;

    }

    public String saveFirstAmoutInRow(String text) throws Throwable {
        WebElement table = CreateElementByTableClass(text);
        WebElement first_row = table.findElement(By.xpath("//tr[@data-row-index][1]//*[@class='value']"));
        String amount = GetText(first_row);
        //String amount = first_row.getText();
        Log.info("!!!!!!!!!Prva kolona u tabeli: " + amount + "!!!!!!!!!!!!");
        return amount;

    }

    public String saveLastAmoutInRow(String text) throws Throwable {
        WebElement table = CreateElementByTableClass(text);
        WebElement last_row = table.findElement(By.xpath("//tr[@data-row-index][last()]//*[@class='value']"));
        String amount = GetText(last_row);
        //String amount = first_row.getText();
        Log.info("!!!!!!!!!Zadnja kolona u tabeli i stranico: " + amount + "!!!!!!!!!!!!");
        return amount;

    }


    public void uploadPictureToelement(String elementName) throws Throwable{
        WebElement element = CreateElementByName(elementName);
        String picPath = System.getProperty("user.home") + "\\Desktop\\vejder.png";
        EnterText(element,picPath);
        // element.sendKeys(picPath);
    }

    public String SaveAmountPrintDocument() throws Throwable {
        //By.xpath("//span[@data-bind=\"text: S.Globalization.formatAmount($data.DebitAmount)\"]"
        WebElement document = driver.findElement(print_document);
       String amount = GetText(document);
       // String amount = document.getText();
        Log.info("!!!!!!!!!Prva kolona u tabeli: " + amount + "!!!!!!!!!!!!");
        return amount;
    }

    public String SaveRowPrintDocument() throws Throwable {
        NewWindow();
        WebElement first_row = driver.findElement(first_row_in_document);  //By.xpath("//body//div/table/tbody[@data-bind=\"foreach: $data[1]\"]/tr[1]//td[3]//span")
        String amount = GetText(first_row) + " RSD";
        Log.info("Prvi iznos u dokumentu " + amount + "!!!!!!!!");
        CloseDriver();
        //driver.switchTo().window(currentWindow);
        return amount;
    }

    public String SaveLastRowPrintDocument() throws Throwable {
        NewWindow();
        WebElement last_row = driver.findElement(last_row_in_document);//By.xpath("//tr[last()]//../td[last()]/../ancestor::td[last()]/div/table/tbody[2]/tr[last()]/td/table/tbody/tr/td[3]/span")
        String amount = GetText(last_row) + " RSD";
        Log.info("Zadnji iznos u dokumentu " + amount + "!!!!!!!!");
        CloseDriver();
        //driver.switchTo().window(currentWindow);
        return amount;
    }

    public  String SaveRateOfExchange() throws Throwable{

        WebElement element = driver.findElement(rate_of_exchange);//By.xpath("//span[text()='Iznos u RSD']/following-sibling::span")
        String rate_of_exchange = GetText(element);
        String rateOfExchange = rate_of_exchange.substring(0,rate_of_exchange.length()-4);
        Log.info("Kurs je: " +rateOfExchange+"!!!!!!!!!!!!!!!!!!!");
        return rateOfExchange;

    }

    public String saveElementBySpanClass(String text) throws Throwable{
        WebElement element = CreateElelementBySpanClass(text);
        String balance_pom = GetText(element);
        String balace = balance_pom.substring(0, balance_pom.length() - 4);
        Log.info("!!!!!!Rate of exchange: " + balace + "!!!!!!");
        return balace;
        //119,87 RSD iznos kursa
    }

    public void assertOnElementBySpanText(String text) throws Throwable {
        WebElement element = CreateParentElementBySpanText(text);
        AssertIfDisplayed(element, text);
        Thread.sleep(5000);
    }


    public void reCaptcha() throws Throwable {
        WebElement element = driver.findElement(recaptcha);
        ClickOnElement(element, "recaptcha");
        Thread.sleep(5000);
    }

    public void assertsFileDownload(String fileName) {
        String dirPath = System.getProperty("user.home");
        String downloadPath = dirPath + "\\Downloads";
        Log.info("Download path: " + downloadPath);
        Assert.assertTrue(Base.isFileDownloadStartName(downloadPath, fileName));
        //Assert.assertTrue(Base.isFileDownloadInLastMinute(downloadPath));
        // Log.info("Download path: "+downloadPath);
        //Assert.assertTrue( Base.isFileDownloadName(downloadPath,fileName));


    }

    //dropdown with JavaScript
    public void selectTextInFieldByElementNameJavascript(String text, String columnName, String elementName) throws Throwable {
        Base.SelectTextInFieldByElementClassNameJavascript(text, columnName, elementName);

    }

    public void clickButtonDropdownMenu(String text) throws Throwable {
        WebElement element = CreateElementByDivClass(text);
        ClickOnElement(element, text);
        //Thread.sleep(5000);

    }

    public void clickOptionDropdownMenu(String text) throws Throwable {
        WebElement element = CreateElementByText(text);  // npr //*[text()='254 - Uplata poreza i doprinosa po odbitku']
        ClickOnElement(element, text);
        Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!Input dropdown with: " + element + "!!!!!!!!!!!!!!!!!!!!!!!!");

    }

//    public void waitForLoad() throws Throwable {
  //      WaitForLoad();
   // }


    public void AssertValidationMessage(String text) throws Throwable {

        List<WebElement> validation_messages = driver.findElements(By.xpath("//*[@class='validationMessage']"));
        List<String> ocekivanePoruke = new ArrayList<String>(Arrays.asList(text.split("}")));

        for (WebElement element : validation_messages) {
            String message = GetText(element);
            //String message = element.getText();
            boolean removed = ocekivanePoruke.remove(message);
            if (removed) {
                Log.info("Prikazana je poruka koja je bila u ocekivanoj listi");
            } else {
                Log.info("Prikazana je poruka koju nismo ocekivali");
            }

            Assert.assertTrue(removed);
        }
        Assert.assertTrue(ocekivanePoruke.size() == 0);
    }

    public void AssertPictureOnPage() throws Throwable {
        CheckImage();

    }
    public void AssertDivStyle() throws Throwable {
        AssertColor();

    }


    public void selectLastAmout() throws Throwable {

        WebElement nextButton = CreateElementByXPath(next_button);//By.xpath("//*[contains(@class,'pagerButton ui-state-default next')]")
        ScrollIntoView(nextButton);
        while (!nextButton.getAttribute("class").contains("disabled")) {
            ClickOnElement(nextButton,"sledece dugme");
            //nextButton.click();
            //mozda ce morati ovo
            // nextButton = CreateElementByXPath(By.xpath("//*[contains(@class,'pagerButton ui-state-default next')]"));
        }
    }
/* public void selectTextInDropdownMenu(String text, String columName, String elementName) throws Throwable {

        WebElement select = CreateElementByClassS(elementName);
        AssertIfDisplayed(select, "select");
        WebElement number = CreateElementByText(text);
        AssertIfDisplayed(number, "opcija");
        //List<WebElement> options = select.findElements(By.id("dk1-listbox"));
        List<WebElement> options = select.findElements(By.className("dk-option"));


        for (WebElement option : options) {

            if (number.getText().equals(option.getText())) {
                option.click();


            }
        }


    }*/

}
