
package org.jbehave.scenario.finegrained.junit.monitoring;

import org.jbehave.scenario.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UseConfiguration {

    Class<? extends Configuration> value();

}
