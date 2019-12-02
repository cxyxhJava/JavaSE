package test2;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:42 2019-11-28
 * @ Description：插入式注解处理器
 * @ Modified By：
 */
@SupportedAnnotationTypes(value = {"test2.SourceTest"})
@SupportedSourceVersion(value = SourceVersion.RELEASE_8)
public class SourceTestAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("Log in AnnotationProcessor.process");
        for (TypeElement typeElement : annotations) {
            System.out.println(typeElement);
        }
        System.out.println(roundEnv);
        return true;
    }
}
