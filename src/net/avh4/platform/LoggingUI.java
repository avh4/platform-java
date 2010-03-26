
package net.avh4.platform;

public class LoggingUI implements UI {

    @Override
    public void browseUrl(String url) {
        System.out.println("UI.browseUrl: " + url);
    }

}
