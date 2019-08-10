/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:27 2019-08-07
 * @ Description：
 * @ Modified By：
 */
public class Test {


    public static void main(String[] args){
        for (int i = 1; i < 10; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = i; j < 10; j++) {
                stringBuffer.append(i).append("*").append(j).append("=").append(i*j).append("\t");
            }
            System.out.println(stringBuffer.toString());
        }
    }


}
