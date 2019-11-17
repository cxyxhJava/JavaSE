import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 19:13 2019-11-15
 * @ Description：
 * @ Modified By：
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestUseCases {

    public int id();

    public String desc() default "默认值";

    float num() default 0.2f;

    double testDouble() default  3.1111;

    Class cls() default Object.class;

    //enum

    //Annotation

    //以上的数组

}
