import java.lang.reflect.Method;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        Class reflection = Reflection.class;


        Method[] methods = reflection.getDeclaredMethods();
        Arrays.stream(methods).filter(method->method.getName().startsWith("get") && method.getParameterCount()==0).
                forEach(e-> System.out.printf("%s will return class %s\n",e.getName(),e.getReturnType()));

        Arrays.stream(methods).filter(method->method.getName().startsWith("set") && method.getParameterCount()==1).
                forEach(e-> System.out.printf("%s will return class %s\n",e.getName(),e.getParameterTypes()[0].getName()));
    }
}
