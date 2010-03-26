
package net.avh4.platform;

import static junit.framework.Assert.assertEquals;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.junit.Before;
import org.junit.Test;

public class EmailReviewTest {

    private Platform p;

    private TestingModule module;

    @Before
    public void setUp() {
        module = new TestingModule();
        Injector injector = Guice.createInjector(module);
        p = injector.getInstance(Platform.class);
    }

    @Test
    public void seeEmailsForToday() {
        module.setMockDate(2010, 3, 25);
        assertEquals(
                "https://mail.google.com/mail/?shva=1#search/after%3A2010%2F3%2F24+before%3A2010%2F3%2F25+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2009%2F3%2F24+before%3A2009%2F3%2F25+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2008%2F3%2F24+before%3A2008%2F3%2F25+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2007%2F3%2F24+before%3A2007%2F3%2F25+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2006%2F3%2F24+before%3A2006%2F3%2F25+label%3AInbox+OR+label%3Aotherinbox\n",
                p.getEmailReviewUrls());
    }

    @Test
    public void seeEmailsForToday2() {
        module.setMockDate(2010, 3, 26);
        assertEquals(
                "https://mail.google.com/mail/?shva=1#search/after%3A2010%2F3%2F25+before%3A2010%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2009%2F3%2F25+before%3A2009%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2008%2F3%2F25+before%3A2008%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2007%2F3%2F25+before%3A2007%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2006%2F3%2F25+before%3A2006%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox\n",
                p.getEmailReviewUrls());
    }

}
