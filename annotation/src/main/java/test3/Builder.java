package test3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:54 2019-12-02
 * @ Description：
 * @ Modified By：
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface Builder {

}