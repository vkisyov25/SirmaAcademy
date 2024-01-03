import java.lang.reflect.Method;
import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) {
        Class reflection = Reflection.class;

        Method[] methods = reflection.getDeclaredMethods();

        //Arrays.stream(methods).filter(method -> method.getAnnotation(Author.class)).forEach();
        for (Method method:methods) {
            Author anotation = method.getAnnotation(Author.class);
            if(anotation!=null){
                System.out.printf("%s -> %s\n",method.getName(), anotation);
            }
        }
    }
}
