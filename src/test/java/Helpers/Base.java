package Helpers;

import Utility.ExcelDataForTests;
import Utility.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Base {
    public static WebDriver driver;

    private static String getErrorMessage = "";
    public static String env;
    public static String testWebSite;
    protected static WebDriverWait waitVar=null;
    public static ArrayList<HashMap<String, String>> datamap = null;

    static {
        try {

            env = ExcelDataForTests.ReadExcelByKey("testdata/configuration.xlsx", "Active", "on", "Environment");
            testWebSite = ExcelDataForTests.ReadExcelByKey("testdata/configuration.xlsx", "Active", "on", "WebSite");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> listForExecution = Utility.ExcelDataForTests.GetListOfTestForExecution(
            "testdata/listForExecution.xlsx", "TestName", env);

    public static void CreateDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


    public static void OpenURL(String url) {
        driver.navigate().to(url);
        Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!! Navigate to url: " + url + " !!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public WebElement CreateElementById(String text) {
        WebElement element = null;
        try {
            element = driver.findElement(By.id(text));
            return element;
        } catch (Exception e) {
            Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!! Create WebElement by ID \"" + text + "\"  Exception: " + e + ".!!!!!!!!!!!!!!!!!!!!!!!!");
            return element;
        }
    }

    public WebElement CreateBySpanDataBind(String text) {
        WebElement element = driver.findElement(By.xpath("//span[@data-bind='" + text + "']"));
        return element;
    }

    public WebElement CreateByPDataBind(String text) {
        WebElement element = driver.findElement(By.xpath("//p[@data-bind='" + text + "']"));
        return element;
    }

    public WebElement CreateElementByName(String text) {
        WebElement element = driver.findElement(By.name(text));
        return element;
    }

    public WebElement CreateElementByLinkText(String text) {
        By xpath = By.xpath("//a[text()='" + text + "']");
        waitForElement(xpath,30);
        WebElement element = driver.findElement(By.xpath("//a[text()='" + text + "']"));
        return element;
    }

    public WebElement CreateElementByTableClass(String text) {
        WebElement element = driver.findElement(By.xpath("//table[@class='" + text + "']"));
        return element;

    }

    public WebElement CreateElementByText(String text) {
        By xpath = By.xpath("//*[text()='" + text + "']");
        waitForElement(xpath,30);
        WebElement element = driver.findElement(By.xpath("//*[text()='" + text + "']"));
        return element;
    }

    public WebElement CreateElementByText2(String text) {
        By xpath = By.xpath("//*[text()='" + text + "']");
        waitForElement(xpath,30);
        WebElement element = driver.findElement(By.xpath("(//*[text()='" + text + "'])[2]"));
        return element;
    }

    public WebElement CreateElementByTextAfterText(String text, String atext) {
        By xpath = By.xpath("//*[text()='" + text + "']/following::*[text()='" + atext + "']");
        waitForElement(xpath,30);
        WebElement element = driver.findElement(By.xpath("//*[text()='" + text + "']/following::*[text()='" + atext + "']"));
        return element;
    }

    public WebElement CreatePDataBindAfterText(String text, String atext) {
        By xpath = By.xpath("//*[text()='" + text + "']/following::*[text()='" + atext + "']");
        waitForElement(xpath,30);
        WebElement element = driver.findElement(By.xpath("//*[text()='" + atext + "']//following::p[@data-bind='" + text + "']"));
        return element;
    }

    public WebElement CreateDataBindAfterText(String text, String atext) {
        By xpath = By.xpath("//*[text()='" + atext + "']//following::*[@data-bind='" + text + "']");
        waitForElement(xpath,30);
        WebElement element = driver.findElement(By.xpath("//*[text()='" + atext + "']//following::*[@data-bind='" + text + "']"));
        return element;
    }

    public WebElement CreateClassAfterText(String text, String atext) {
        By xpath = By.xpath("//*[text()='" + atext + "']//following::*[@class='" + text + "']");
        waitForElement(xpath,30);
        WebElement element = driver.findElement(By.xpath("//*[text()='" + atext + "']//following::*[@class='" + text + "']"));
        return element;
    }

    public WebElement CreateTextAfterClass(String text, String atext) {
        By xpath = By.xpath("//*[@class='" + atext + "']//following::*[text()='" + text + "']");
        waitForElement(xpath,30);
        WebElement element = driver.findElement(By.xpath("//*[@class='" + atext + "']//following::*[text()='" + text + "']"));
        return element;
    }

    public WebElement CreateElementByTable(String text) {
        WebElement element = driver.findElement(By.xpath("//table[@class='" + text + "']"));
        return element;
    }

    public WebElement CreateElementByDivText(String text) {
        WebElement element = driver.findElement(By.xpath("//div[text()='" + text + "']"));
        return element;
    }

    public WebElement CreateElementByDivClass(String text) {
        WebElement element = driver.findElement(By.xpath("//div[@class='" + text + "']"));
        return element;
    }

    public WebElement CreateElementByClass(String text) {
        WebElement element = driver.findElement(By.xpath("//input[@class='" + text + "']"));

        return element;
    }

    public WebElement CreateElementByClass2(String text) {
        WebElement element = driver.findElement(By.xpath("(//input[@class='" + text + "'])[2]"));

        return element;
    }

    public WebElement CreateElementByClassS(String text) {
        WebElement element = driver.findElement(By.xpath("//*[@class='" + text + "']"));

        return element;
    }

    public WebElement CreateElelementBySpanClass(String text) {
        WebElement element = driver.findElement(By.xpath("//span[@class='" + text + "']"));
        return element;
    }

    public WebElement CreateNextElementBySpanClass(String text) {
        WebElement element = driver.findElement(By.xpath("//span[@class='" + text + "']/following-sibling::small"));
        return element;
    }

    public WebElement CreateNextElementBySpanClassSpan(String text) {
        WebElement element = driver.findElement(By.xpath("//*[@class='" + text + "']/span"));
        return element;
    }

    public WebElement CreateParentElementBySpanText(String text) {
        WebElement element = driver.findElement(By.xpath("//*[text()='" + text + "']/.."));
        return element;
    }

    public WebElement CreateElementByXPath(By xpath) {
        WebElement element = driver.findElement(xpath);
        return element;
    }

    public static void ClickOnElement(WebElement element, String elementname) throws Throwable {
        WaitForElement(element, elementname);
        element.click();
    }


    public static void EnterTextInElement(WebElement element, String columnName, String text) {
        element.sendKeys(text);
        Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!! Input field \"" + columnName + "\" is populated with \"" + text + "\" .!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    public static  void EnterText(WebElement element, String text){
        element.sendKeys(text);
    }

    public static void AssertIfDisplayed(WebElement element, String text) {
        assertTrue((element.isDisplayed()));
        Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!! WebElement \"" + text + "\" Asserted successfully.!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public static void AssertIfDisplayedValue(WebElement element, String text) {
        assertTrue((element.isDisplayed()));
        Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!! WebElement \"" + text + "\" Asserted successfully. Value \"" + element.getAttribute("value") + "\"!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    public static void AssertIfDisplayedText(WebElement element, String text) {
        assertTrue((element.isDisplayed()));
        Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!! WebElement \"" + text + "\" Asserted successfully. Text \"" + element.getText() + "\"!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public static void AssertIfTextIsEqual(WebElement element, String text) {
        assertTrue(element.getText().contentEquals(text));
        Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!! WebElement \"" + text + "\" Asserted successfully. Text \"" + element.getText() + "\"!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public static void CloseDriver() {
        driver.close();
    }

    public static void getScreenshot(WebDriver driver, String outputlocation) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(outputlocation));
    }

    public String getDataFromHashDatamap(String arg1, String columnName) {
        int index = Integer.parseInt(arg1) - 1;
        String myData = datamap.get(index).get(columnName);
        return myData;
    }
    public static void HoverElement(WebElement element) throws Throwable{
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

    }
    public static String GetText(WebElement element) throws  Throwable{
        String text = element.getText();
        return text;
    }
    public static void NewWindow() {
        String currentWindow = driver.getWindowHandle();//zamaptimo u kom smo prozoru trenutno
        Set<String> windowHandles = driver.getWindowHandles();//ovde uzmemo sve otvorene prozore, u nasem slucaju dva
        Log.info("Handles: " + windowHandles.size());
        for (String handle : windowHandles) //prolazimo kroz set jer nam niko ne garantuje da smo u
        // pravom prozoru, zato ga poredimo sa zakucanim
        {
            if (!handle.equals(currentWindow)) {
                driver.switchTo().window(handle);

            }
        }
        //driver.switchTo().window(currentWindow);
    }

    public static void WaitForElement(WebElement element, String elementName) throws InterruptedException {
        for (int i = 1; i <= 30; i++) {
            try {
                element.isDisplayed();
                break;
            } catch (NoSuchElementException e) {
                Thread.sleep(500);
                if (i == 30) {
                    getErrorMessage = e.getMessage().toString();
                    Log.info("Element " + elementName + "is not displayed!!!");
                    Log.info(getErrorMessage);
                }
            }
        }
    }


    public static void waitForElement(By ByElement, int time)
    {
        try {
            waitVar = new WebDriverWait(driver, time);
            waitVar.until(ExpectedConditions.presenceOfElementLocated(ByElement));
        }
        catch (Exception e){
            Log.info("Error "+e);
        }
    }
    public static void AssertColor() throws Throwable {
        WebElement element = driver.findElement(By.xpath("//div[@class='list-item row-1 selected']"));
        String color = element.getCssValue("background-color");
        Log.info("Boja je: " + color + "!!!!!!!!!!!!!!!!!!");
        assertTrue(element.getCssValue("background-color").contains("rgba(255, 253, 229, 1)"));

    }

    public void ScrollIntoView(WebElement element) throws Throwable {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(500);
    }

    public Double rate_of_exchange(String balanceBefore1, String balance1, String number1, String balanceAffter1) {
        Double balanceBefore = Double.parseDouble(balanceBefore1.replace(".", "").replace(",", "."));
        Double balanceAffter = Double.parseDouble(balanceAffter1.replace(".", "").replace(",", "."));
        Double balance = Double.parseDouble(balance1.replace(".", "").replace(",", "."));
        Double number = Double.parseDouble(number1.replace(".", "").replace(",", "."));
        Double pom = number * balance;
        Double result_exchange = balanceBefore - pom;
        Double result = balanceAffter - result_exchange;
        return result;

    }

    //if you know Name File
    public static boolean isFileDownloadName(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                //File has been found, it can now be deleted
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    //In last minute download file
    public static boolean isFileDownloadInLastMinute(String downloadPath) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].lastModified() > System.currentTimeMillis() - 60 * 1000) {
                //File has been found, it can now be deleted
                dirContents[i].delete();
                return true;
            }


        }
        return false;
    }

    //if you know starts name
    public static boolean isFileDownloadStartName(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().startsWith(fileName)) {
                //File has been found, it can now be deleted
                dirContents[i].delete();
                return true;
            }

        }
        return false;

    }

    //javascript za dropdown za ID

    public static void SelectTextInFieldByElementNameJavascript(String text, String columnName, String elementName) {
        JavascriptExecutor executor = (JavascriptExecutor) Base.driver;
        executor.executeScript("var sel = document.getElementById('" + elementName + "');\n" +
                "for(var i = 0; i < sel.options.length; i++) {\n" +
                "    if(sel.options[i].text == \"" + text + "\"){\n" +
                "        sel.selectedIndex = i;\n" +
                "    }\n" +
                "}");
    }

    //javascript za dropdown za className
    public static void SelectTextInFieldByElementClassNameJavascript(String text, String columnName, String elementName) throws Throwable {
        JavascriptExecutor executor = (JavascriptExecutor) Base.driver;
        executor.executeScript("var sel = document.getEelementsByClassName('" + elementName + "')[0];\n" +
                "for(var i = 0; i < sel.options.length; i++) {\n" +
                "    if(sel.options[i].text == \"" + text + "\"){\n" +
                "        sel.selectedIndex = i;\n" +
                "    }\n" +
                "}");
    }
/*
    public static void WaitForLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(driver1 -> {
            Object complete = ((JavascriptExecutor) driver1).executeScript("return document.readyState == \"complete\"");
            return (Boolean) complete;
        });
    }
    /*
// za jquery
 public static void WaitForLoad() throws Throwable  {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(driver1 -> {
            Object complete = ((JavascriptExecutor) driver1).executeScript("return JQuery.active == \"complete\"");
            return (Boolean)complete;
        });
    }
*/


    public static void CheckImage() throws Throwable {
        WebElement ImageFile = driver.findElement(By.xpath("//img[contains(@src,'iVBO')]"));

        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        if (!ImagePresent) {
            Log.info("Image not displayed.");
        } else {
            Log.info("Image displayed.");
        }
    }


}
