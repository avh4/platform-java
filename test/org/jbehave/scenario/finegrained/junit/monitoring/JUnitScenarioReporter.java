
package org.jbehave.scenario.finegrained.junit.monitoring;

import org.jbehave.scenario.definition.Blurb;
import org.jbehave.scenario.definition.ExamplesTable;
import org.jbehave.scenario.definition.StoryDefinition;
import org.jbehave.scenario.reporters.ScenarioReporter;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JUnitScenarioReporter implements ScenarioReporter {

    private final RunNotifier notifier;

    private Description currentScenario;

    private Description currentStep;

    private final Iterator<Description> scenarioDescriptions;

    private final Description storyDescription;

    List<Description> finishedDescriptions = new ArrayList<Description>();

    public JUnitScenarioReporter(RunNotifier notifier, Description storyDescription) {
        this.notifier = notifier;
        this.storyDescription = storyDescription;
        this.scenarioDescriptions = storyDescription.getChildren().iterator();
        this.currentScenario = this.scenarioDescriptions.next();
    }

    public void afterScenario() {
        notifier.fireTestFinished(currentScenario);
        if (scenarioDescriptions.hasNext()) {
            currentScenario = scenarioDescriptions.next();
            finishedDescriptions.clear();
        }
    }

    public void afterStory() {
        notifier.fireTestFinished(storyDescription);
    }

    public void beforeScenario(String title) {
        notifier.fireTestStarted(currentScenario);
    }

    public void beforeStory(Blurb blurb) {
        notifier.fireTestStarted(storyDescription);
    }

    public void failed(String step, Throwable e) {
        currentStep = getStepDescription(step);
        notifier.fireTestStarted(currentStep);
        notifier.fireTestFailure(new Failure(currentStep, e));
        finishedDescriptions.add(currentStep);
    }

    public void notPerformed(String step) {
    }

    public void pending(String step) {
    }

    public void successful(String step) {
        currentStep = getStepDescription(step);
        notifier.fireTestStarted(currentStep);
        notifier.fireTestFinished(currentStep);
        finishedDescriptions.add(currentStep);
    }

    private Description getStepDescription(String step) {
        for (Description description : currentScenario.getChildren()) {
            if (!finishedDescriptions.contains(description) && match(step, description)) {
                return description;
            }
        }
        throw new RuntimeException("Could not find description for: " + step);
    }

    private boolean match(String step, Description description) {
        return description.getDisplayName().startsWith(
                JUnitDescriptionGenerator.getJunitSafeString(step));
    }

    @Override
    public void afterExamples() {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterStory(boolean arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeExamples(List<String> arg0, ExamplesTable arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeStory(StoryDefinition arg0, boolean arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void example(Map<String, String> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void examplesTable(ExamplesTable arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void examplesTableRow(Map<String, String> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void givenScenarios(List<String> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void ignorable(String arg0) {
        // TODO Auto-generated method stub

    }

}
