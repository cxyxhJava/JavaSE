package test3;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:53 2019-12-02
 * @ Description：
 * @ Modified By：
 */
public class Person {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    @Builder
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Builder
    public void setName(String name) {
        this.name = name;
    }

}
