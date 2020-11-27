package StepDefinition;

import Helpers.Base;
import Utility.ExcelDataForTests;
import Utility.Log;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Hooks {
    String FeatureName ="";
    String ScName ="";

    @Before
    public void beforeHookFunction(Scenario scenario) throws IOException {
        Base.CreateDriver();
        ScName = scenario.getName();
        FeatureName = Utility.ExcelDataForTests.ReadExcelByKey("testdata/listForExecution.xlsx","TestName",ScName,"Feature");
        Base.datamap = ExcelDataForTests.getDataFromExcel("testdata/"+FeatureName+".xlsx","Sheet1");
        //datamap = ExcelDataForTests.setMapData("testdata/" + FeatureName + ".xlsx", "Sheet1");
        Log.info("*********************************************************************************************");
        Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!! Scenario \""+ScName+"\" started.!!!!!!!!!!!!!!!!!!!!!!!!");
        Log.info("*********************************************************************************************");
    }

    @After
    public void afterHookFunction(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                String strDate = new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(Calendar.getInstance().getTime());
                Base.getScreenshot(Base.driver, "testdata/Screen_"+ScName+"_"+strDate+".png");
                Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!! Test Scenario \""+ScName+"\" failed.!!!!!!!!!!!!!!!!!!!!!!!!");
                Utility.ExcelDataForTests.WriteTestResult(ScName, "FAILED","Screen_"+scenario.getName()+"_" + strDate + ".png");
                Log.info("FAILED!");
                Base.CloseDriver();
            } catch (Exception e) {
                Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!! Screenshot for scenario \""+scenario.getName()+"\" failed.!!!!!!!!!!!!!!!!!!!!!!!!");
                Utility.ExcelDataForTests.WriteTestResult(ScName, "FAILED","failed");
                Log.info("Exception: "+e+".");
                Log.info("FAILED!");
                Base.CloseDriver();
            }
        }
        else{
            Log.info("!!!!!!!!!!!!!!!!!!!!!!!!!! TestScenario \""+ScName+"\" finished successfully.!!!!!!!!!!!!!!!!!!!!!!!!");
            Utility.ExcelDataForTests.WriteTestResult(ScName, "PASSED","");
            Log.info("PASSED!");
            Base.CloseDriver();
        }
    }
}