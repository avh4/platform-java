
package net.avh4.platform;

import java.util.Date;

public class RealTimeProvider implements TimeProvider {

    @Override
    public Date getDate() {
        return new Date();
    }

}
