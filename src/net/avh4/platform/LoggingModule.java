
package net.avh4.platform;

import com.google.inject.AbstractModule;

public class LoggingModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UI.class).to(LoggingUI.class);
        bind(TimeProvider.class).to(RealTimeProvider.class);
    }

}
