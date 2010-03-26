
package net.avh4.platform;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import java.util.GregorianCalendar;

public class EmailReviewTest {

    @Test
    public void seeEmailsForToday() {
        Platform p = new Platform(new GregorianCalendar(2010, GregorianCalendar.MARCH, 25)
                .getTime(), null);
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
        Platform p = new Platform(new GregorianCalendar(2010, GregorianCalendar.MARCH, 26)
                .getTime(), null);
        assertEquals(
                "https://mail.google.com/mail/?shva=1#search/after%3A2010%2F3%2F25+before%3A2010%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2009%2F3%2F25+before%3A2009%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2008%2F3%2F25+before%3A2008%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2007%2F3%2F25+before%3A2007%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox\n"
                        + "https://mail.google.com/mail/?shva=1#search/after%3A2006%2F3%2F25+before%3A2006%2F3%2F26+label%3AInbox+OR+label%3Aotherinbox\n",
                p.getEmailReviewUrls());
    }

}
