package db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 20:44 2019-11-15
 * @ Description：
 * @ Modified By：
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {

    String name() default "";

    Constraints constraints() default @Constraints;

}
