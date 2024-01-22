import java.lang.reflect.Method;

public class readMethodSpec {


    public static int add(int num1, int num2) {
        return num1 + num2;
    }


    
    public static void main(String[] args) {
        try {
            Method method = readMethodSpec.class.getMethod("add", int.class, int.class);

            System.out.println("Method name: " + method.getName());
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Parameters: " + method.getParameterCount());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
