
package net.avh4.platform;

import com.google.inject.AbstractModule;

public class TestingModule extends AbstractModule {

    private final MockTimeProvider timeProvider = new MockTimeProvider();

    @Override
    protected void configure() {
        bind(UI.class).to(LoggingUI.class);
        bind(TimeProvider.class).toInstance(timeProvider);
    }

    public void setMockDate(int year, int month, int date) {
        timeProvider.setDate(year, month, date);
    }

}
