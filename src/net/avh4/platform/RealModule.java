
package net.avh4.platform;

import com.google.inject.AbstractModule;

public class RealModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UI.class).to(SwingUI.class);
        bind(TimeProvider.class).to(RealTimeProvider.class);
    }

}
