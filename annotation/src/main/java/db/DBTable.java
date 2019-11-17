package db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 20:37 2019-11-15
 * @ Description：表注解
 * @ Modified By：
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {

    public String name() default ""; //表名

}
