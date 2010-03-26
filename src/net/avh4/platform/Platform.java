
package net.avh4.platform;

import java.util.Date;
import java.util.GregorianCalendar;

public class Platform implements Runnable {

    private final Date mockDate;

    private final UI ui;

    protected Platform(Date time, UI ui) {
        mockDate = time;
        this.ui = ui;
    }

    public Platform(UI ui) {
        this(null, ui);
    }

    public static void main(String[] args) {
        new Platform(new SwingUI()).run();
    }

    @Override
    public void run() {
        for (String url : getEmailReviewUrls().split("\n")) {
            ui.browseUrl(url);
        }
    }

    public String getEmailReviewUrls() {
        return createGmailLink(0) + createGmailLink(-1) + createGmailLink(-2) + createGmailLink(-3)
                + createGmailLink(-4);
    }

    private String createGmailLink(int year_offset) {
        GregorianCalendar now = new GregorianCalendar();
        now.setTime(getDate());
        int end_date = now.get(GregorianCalendar.DAY_OF_MONTH);
        now.add(GregorianCalendar.DATE, -1);
        int start_date = now.get(GregorianCalendar.DAY_OF_MONTH);
        final int year = 2010 + year_offset;
        return "https://mail.google.com/mail/?shva=1#search/after%3A" + year + "%2F3%2F"
                + start_date + "+before%3A" + year + "%2F3%2F" + end_date
                + "+label%3AInbox+OR+label%3Aotherinbox\n";
    }

    private Date getDate() {
        if (mockDate != null) {
            return mockDate;
        }
        return new Date();
    }

}
