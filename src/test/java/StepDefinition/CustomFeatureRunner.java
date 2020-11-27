package StepDefinition;

import Helpers.Base;
import cucumber.runtime.Runtime;
import cucumber.runtime.junit.ExecutionUnitRunner;
import cucumber.runtime.junit.FeatureRunner;
import cucumber.runtime.junit.JUnitReporter;
import cucumber.runtime.junit.ScenarioOutlineRunner;
import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.CucumberScenario;
import cucumber.runtime.model.CucumberScenarioOutline;
import cucumber.runtime.model.CucumberTagStatement;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.List;

public class CustomFeatureRunner extends FeatureRunner {

    @SuppressWarnings("rawtypes")
    private final List<ParentRunner> children = new ArrayList<>();
    private final CucumberFeature cucumberFeature;
    private final Runtime runtime;
    private final JUnitReporter jUnitReporter;

    public CustomFeatureRunner(CucumberFeature cucumberFeature, Runtime runtime, JUnitReporter jUnitReporter)
            throws InitializationError {
        super(cucumberFeature, runtime, jUnitReporter);
        this.cucumberFeature = cucumberFeature;
        this.runtime = runtime;
        this.jUnitReporter = jUnitReporter;
        buildFeatureElementRunners();
    }

    @SuppressWarnings("rawtypes")
    protected List<ParentRunner> getChildren() {
        return children;
    }

    @SuppressWarnings("rawtypes")
    protected void runChild(ParentRunner child, RunNotifier notifier) {
        child.run(notifier);
    }

    public void run(RunNotifier notifier) {
        jUnitReporter.uri(cucumberFeature.getPath());
        jUnitReporter.feature(cucumberFeature.getGherkinFeature());
        super.run(notifier);
        jUnitReporter.eof();
    }


    @SuppressWarnings("rawtypes")
    private void buildFeatureElementRunners() {
        for (CucumberTagStatement cucumberTagStatement : cucumberFeature.getFeatureElements()) {
            try {
                ParentRunner featureElementRunner;
                String scenarioName;
                if (cucumberTagStatement instanceof CucumberScenario) {
                    scenarioName = ((CucumberScenario) cucumberTagStatement).getGherkinModel().getName();
                    featureElementRunner = new ExecutionUnitRunner(runtime, (CucumberScenario) cucumberTagStatement, jUnitReporter);
                } else {
                    scenarioName = ((CucumberScenarioOutline) cucumberTagStatement).getGherkinModel().getName();
                    featureElementRunner = new ScenarioOutlineRunner(runtime, (CucumberScenarioOutline) cucumberTagStatement , jUnitReporter);
                }

                // skip scenario if not in Excel
                if (Base.listForExecution.contains(scenarioName)) {
                    children.add(featureElementRunner);
                }
            } catch (InitializationError e) {
            }}}}