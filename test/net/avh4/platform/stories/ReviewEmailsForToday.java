
package net.avh4.platform.stories;

import net.avh4.platform.steps.ReviewEmailsForTodaySteps;

import org.jbehave.scenario.MostUsefulConfiguration;
import org.jbehave.scenario.Scenario;
import org.jbehave.scenario.errors.PendingErrorStrategy;

public class ReviewEmailsForToday extends Scenario {

    private static class LocalConfiguration extends MostUsefulConfiguration {
        @Override
        public PendingErrorStrategy forPendingSteps() {
            return PendingErrorStrategy.FAILING;
        }
    }

    public ReviewEmailsForToday() {
        super(new LocalConfiguration(), new ReviewEmailsForTodaySteps());
    }

}
