package fi.zcode.neo4j.logger;

import java.lang.annotation.*;

/*
 * http://www.borislam.com/2012/07/inject-slf4j-logger-by-annotation.html
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Loggable {
    //for slf4j
}
