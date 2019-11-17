import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 19:16 2019-11-15
 * @ Description：
 * @ Modified By：
 */

public class TestUseCasesTracker {

    public static void trackUseCases(List<Integer> useCases,Class<?> cl){

        for (Method method: cl.getDeclaredMethods()){
            TestUseCases us = method.getAnnotation(TestUseCases.class);

            if (us!=null){
                System.out.println("id:"+us.id()+" desc:"+us.desc()+
                " class"+us.cls()
                        +" float:"+us.num()
                );
            }

            for (Integer useCase : useCases) {
                System.out.println("useCase:"+useCase);
            }
        }

    }

    public static void main(String[] args){
        List<Integer> useCases = new ArrayList<Integer>();

        Collections.addAll(useCases,47,48,49,50);

        trackUseCases(useCases,TestUtil.class);

    }

}
