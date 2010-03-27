
package net.avh4.platform.stories;

import net.avh4.platform.steps.ReviewEmailsForTodaySteps;

import org.jbehave.scenario.MostUsefulConfiguration;
import org.jbehave.scenario.Scenario;
import org.jbehave.scenario.errors.PendingErrorStrategy;
import org.jbehave.scenario.finegrained.junit.monitoring.JUnitReportingRunner;
import org.jbehave.scenario.finegrained.junit.monitoring.UseConfiguration;
import org.jbehave.scenario.finegrained.junit.monitoring.UseSteps;
import org.jbehave.scenario.reporters.ScenarioReporter;
import org.junit.runner.RunWith;

@RunWith(JUnitReportingRunner.class)
@UseSteps(ReviewEmailsForTodaySteps.class)
@UseConfiguration(ReviewEmailsForToday.LocalConfiguration.class)
public class ReviewEmailsForToday extends Scenario {

    public static class LocalConfiguration extends MostUsefulConfiguration {
        @Override
        public PendingErrorStrategy forPendingSteps() {
            return PendingErrorStrategy.FAILING;
        }
    }

    public ReviewEmailsForToday(final ScenarioReporter reporter) {
        super(new LocalConfiguration() {
            @Override
            public ScenarioReporter forReportingScenarios() {
                return reporter;
            }
        }, new ReviewEmailsForTodaySteps());
    }

}
