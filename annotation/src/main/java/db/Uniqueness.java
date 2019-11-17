package db;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 20:46 2019-11-15
 * @ Description：
 * @ Modified By：
 */

public @interface Uniqueness {
    Constraints constraints() default @Constraints;
}
