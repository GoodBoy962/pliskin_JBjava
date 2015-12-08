import java.lang.reflect.*;

/**
 * Created by aleksandrpliskin on 06.11.15.
 */
public class ReflectionTask10 {

    private static String modType(int mods) {
        if (Modifier.isPublic(mods)) {
            return "public ";
        } else if (Modifier.isAbstract(mods)) {
            return "abstract ";
        } else if (Modifier.isFinal(mods)) {
            return "final ";
        } else if (Modifier.isProtected(mods)) {
            return "protected ";
        } else if (Modifier.isStatic(mods)) {
            return "static ";
        } else if (Modifier.isPrivate(mods)) {
            return "private";
        } else return "smth else";
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("Task10");

        Object obj = clazz.newInstance();

        System.out.println("      НЕ   Привытные поля");
        Field[] fieldS = clazz.getFields();
        for (Field field : fieldS) {
            Class fieldType = field.getType();
            System.out.println("Имя: " + field.getName());
            System.out.println("Тип: " + fieldType.getName());
        }

        System.out.println("__________________________________________________________________");


        System.out.println("        Привытные поля");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            System.out.println("Имя: " + field.getName());
            System.out.println("Тип: " + fieldType.getName());
        }

        System.out.println("__________________________________________________________________");

        System.out.println("        НЕ   Привытные методы");
        Method[] methodS = clazz.getMethods();
        for (Method method : methodS) {
            if (modType(method.getModifiers()) != "private") {
                System.out.println("Имя: " + method.getName());
                System.out.println("Возвращаемый тип: " + method.getReturnType().getName());

                Class[] paramTypes = method.getParameterTypes();
                System.out.print("Типы параметров: ");
                for (Class paramType : paramTypes) {
                    System.out.print(" " + paramType.getName());
                }
                System.out.println();
            }
        }

        System.out.println("__________________________________________________________________");

        System.out.println("            Привытные методы");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (modType(method.getModifiers()) == "private") {
                System.out.println("Имя: " + method.getName());
                System.out.println("Возвращаемый тип: " + method.getReturnType().getName());

                Class[] paramTypes = method.getParameterTypes();
                System.out.print("Типы параметров: ");
                for (Class paramType : paramTypes) {
                    System.out.print(" " + paramType.getName());
                }
                System.out.println();
            }
        }

        System.out.println("__________________________________________________________________");

        System.out.println("           Конструкторы");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            System.out.println("Имя " + constructor.getName());
            System.out.println("Параметры ");
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }

        System.out.println("__________________________________________________________________");


        try {
            methods[0].invoke(obj, 10);
            System.out.println(methods[1].invoke(obj));
        } catch (Exception e) {
            methods[1].invoke(obj, 10);
            System.out.println(methods[0].invoke(obj));
        }
    }

}
