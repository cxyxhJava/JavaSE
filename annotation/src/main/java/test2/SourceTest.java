package test2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:41 2019-11-28
 * @ Description：测试插入式注解用注解
 * @ Modified By：
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface SourceTest {
    public String value() default "默认值";
}
