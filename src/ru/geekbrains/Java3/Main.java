package ru.geekbrains.Java3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        int maxPriority = 10;
        try {
            start(TestedMethods.class, maxPriority);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static <T> void start (Class<T> testClass, int maxPriority) throws InvocationTargetException, IllegalAccessException {
        Method[] startEndMethods = new Method[2];
        try {
            startEndMethods = chekCountMethods(TestedMethods.class);
        }catch (RuntimeException e){
            System.out.println("По условию задачи Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре");
//            e.printStackTrace();
        }
        startEndMethods[0].invoke(null);
        Method[] methods = testClass.getDeclaredMethods();
        for (int i = 1; i <= maxPriority; i++) {
            for (Method method: methods) {
                if (method.isAnnotationPresent(Test.class)){
                    if (method.getAnnotation(Test.class).priority() == i) {
                        method.invoke(null);
                    }
                }
            }
        }
        startEndMethods[1].invoke(null);
    }

    public static Method[] chekCountMethods(Class checkedClass){
        int countOfBefore = 0, countOfAfter = 0;
        Method[] startEndMethods = new Method[2];
        Method[] methods = checkedClass.getDeclaredMethods();
        for (Method method: methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)){
                countOfBefore++;
                startEndMethods[0] = method;
            }
            if (method.isAnnotationPresent(AfterSuite.class)){
                countOfAfter++;
                startEndMethods[1] = method;
            }
        }
        if (countOfAfter != 1 || countOfBefore != 1){
            throw new RuntimeException();
        }
        return startEndMethods;
    }
}
