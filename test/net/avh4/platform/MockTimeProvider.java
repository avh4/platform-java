
package net.avh4.platform;

import java.util.Date;
import java.util.GregorianCalendar;

public class MockTimeProvider implements TimeProvider {

    private Date mockTime = null;

    @Override
    public Date getDate() {
        if (mockTime == null) {
            throw new IllegalStateException(
                    "Current time must be explicitly set before using MockTimeProvider");
        }
        return mockTime;
    }

    public void setDate(int year, int month, int date) {
        mockTime = new GregorianCalendar(year, month, date).getTime();
    }

}
