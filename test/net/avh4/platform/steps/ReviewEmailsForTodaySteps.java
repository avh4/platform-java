
package net.avh4.platform.steps;

import static org.mockito.Mockito.verify;

import com.google.inject.Guice;
import com.google.inject.Injector;

import net.avh4.platform.Platform;
import net.avh4.platform.UI;
import net.avh4.platform.test.TestingModule;

import org.jbehave.scenario.annotations.BeforeScenario;
import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;

public class ReviewEmailsForTodaySteps extends Steps {

    private Platform p;

    private TestingModule module;

    private UI ui;

    @BeforeScenario
    public void setUp() {
        module = new TestingModule();
        Injector injector = Guice.createInjector(module);
        p = injector.getInstance(Platform.class);
        ui = module.getUi();
    }

    @When("I run Platform")
    public void runPlatform() {
        p.run();
    }

    @Given("today is 2010-03-$date")
    public void setMockDate(int date) {
        module.setMockDate(2010, 3, date);
    }

    @Then("I should see emails for 03-24 from 2006 to 2010")
    public void shouldSeeEmailsInBrowserForMarch24() {
        final String url1 = "https://mail.google.com/mail/?shva=1#search/after%3A2010%2F3%2F24+before%3A2010%2F3%2F25+label%3AInbox+OR+label%3Aotherinbox";
        final String url2 = "https://mail.google.com/mail/?shva=1#search/after%3A2009%2F3%2F24+before%3A2009%2F3%2F25+label%3AInbox+OR+label%3Aotherinbox";
        final String url3 = "https://mail.google.com/mail/?shva=1#search/after%3A2008%2F3%2F24+before%3A2008%2F3%2F25+label%3AInbox+OR+label%3Aotherinbox";
        final String url4 = "https://mail.google.com/mail/?shva=1#search/after%3A2007%2F3%2F24+before%3A2007%2F3%2F25+label%3AInbox+OR+label%3Aotherinbox";
        final String url5 = "https://mail.google.com/mail/?shva=1#search/after%3A2006%2F3%2F24+before%3A2006%2F3%2F25+label%3AInbox+OR+label%3Aotherinbox";
        verify(ui).browseUrl(url1);
        verify(ui).browseUrl(url2);
        verify(ui).browseUrl(url3);
        verify(ui).browseUrl(url4);
        verify(ui).browseUrl(url5);
    }

    @Then("I should see emails for 03-25 from 2006 to 2010")
    public void shouldSeeEmailsInBrowserForMarch25() {
        final String url1 = "https://mail.google.com/mail/?shva=1#search/after%3A2010%2F3%2F25+before%3A2010%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox";
        final String url2 = "https://mail.google.com/mail/?shva=1#search/after%3A2009%2F3%2F25+before%3A2009%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox";
        final String url3 = "https://mail.google.com/mail/?shva=1#search/after%3A2008%2F3%2F25+before%3A2008%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox";
        final String url4 = "https://mail.google.com/mail/?shva=1#search/after%3A2007%2F3%2F25+before%3A2007%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox";
        final String url5 = "https://mail.google.com/mail/?shva=1#search/after%3A2006%2F3%2F25+before%3A2006%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox";
        verify(ui).browseUrl(url1);
        verify(ui).browseUrl(url2);
        verify(ui).browseUrl(url3);
        verify(ui).browseUrl(url4);
        verify(ui).browseUrl(url5);
    }

}
