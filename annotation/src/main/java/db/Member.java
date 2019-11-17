package db;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 20:47 2019-11-15
 * @ Description：
 * @ Modified By：
 */
@DBTable(name = "Member")
public class Member {

    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30,constraints = @Constraints(primaryKey = true)) String handel;

    static int memberCount;


    public String getHandel(){
        return handel;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String toString(){
        return handel;
    }

    public Integer getAge(){
        return age;
    }
}
