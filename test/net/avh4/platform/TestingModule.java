
package net.avh4.platform;

import static org.mockito.Mockito.mock;

import com.google.inject.AbstractModule;

public class TestingModule extends AbstractModule {

    private final MockTimeProvider timeProvider = new MockTimeProvider();

    private final UI mockUi = mock(UI.class);

    @Override
    protected void configure() {
        bind(UI.class).toInstance(mockUi);
        bind(TimeProvider.class).toInstance(timeProvider);
    }

    public void setMockDate(int year, int month, int date) {
        timeProvider.setDate(year, month, date);
    }

    public UI getUi() {
        return mockUi;
    }

}
