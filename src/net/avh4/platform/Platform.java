
package net.avh4.platform;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.util.GregorianCalendar;

public class Platform implements Runnable {

    private final TimeProvider time;

    private final UI ui;

    @Inject
    protected Platform(TimeProvider time, UI ui) {
        this.time = time;
        this.ui = ui;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new RealModule());
        Platform p = injector.getInstance(Platform.class);
        p.run();
    }

    @Override
    public void run() {
        for (String url : getEmailReviewUrls().split("\n")) {
            ui.browseUrl(url);
        }
    }

    private String getEmailReviewUrls() {
        return createGmailLink(0) + createGmailLink(-1) + createGmailLink(-2) + createGmailLink(-3)
                + createGmailLink(-4);
    }

    private String createGmailLink(int year_offset) {
        GregorianCalendar now = new GregorianCalendar();
        now.setTime(time.getDate());
        int end_date = now.get(GregorianCalendar.DAY_OF_MONTH);
        now.add(GregorianCalendar.DATE, -1);
        int start_date = now.get(GregorianCalendar.DAY_OF_MONTH);
        final int year = 2010 + year_offset;
        return "https://mail.google.com/mail/?shva=1#search/after%3A" + year + "%2F3%2F"
                + start_date + "+before%3A" + year + "%2F3%2F" + end_date
                + "+label%3AInbox+OR+label%3Aotherinbox\n";
    }

}
