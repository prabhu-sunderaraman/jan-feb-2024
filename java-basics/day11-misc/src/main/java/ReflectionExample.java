import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("Book"); //Type.GetType("Book") in C#
        System.out.println(cls.getName());
        System.out.println(cls.getSimpleName());
        System.out.println(cls.getPackageName());
        System.out.println(cls.getSuperclass().getName());
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        for (Annotation annotation : cls.getAnnotations()) {
            if(annotation instanceof  Comment)   { //equivalent of instanceOf in C# is 'is'
                Comment comment = (Comment) annotation;
                System.out.println(comment.value());
            }
        }
        Constructor<String> constructor = cls.getConstructor(String.class);
        Object book = constructor.newInstance("Java");

    }
}
