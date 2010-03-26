
package net.avh4.platform;

import static org.mockito.Mockito.verify;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.junit.Before;
import org.junit.Test;

public class EmailReviewTest {

    private Platform p;

    private TestingModule module;

    private UI ui;

    @Before
    public void setUp() {
        module = new TestingModule();
        Injector injector = Guice.createInjector(module);
        p = injector.getInstance(Platform.class);
        ui = module.getUi();
    }

    @Test
    public void seeEmailsForToday() {
        module.setMockDate(2010, 3, 25);
        p.run();

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

    @Test
    public void seeEmailsForToday2() {
        module.setMockDate(2010, 3, 26);
        p.run();

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
