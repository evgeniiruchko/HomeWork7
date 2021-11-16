package ru.geekbrains.Java3;

public class TestedMethods {

    @BeforeSuite
    public static void BeforeMethod(){
        System.out.println("Этот метод с аннотацией @BeforeSuite");
    }

    @AfterSuite
    public static void AfterMethod(){
        System.out.println("Этот метод с аннотацией @AfterSuite");
    }

//    @AfterSuite
//    public static void AfterMethod_2(){
//        System.out.println("Этот метод с аннотацией @AfterSuite");
//    }

    @Test(priority = 4)
    public static void Method_1(){
        System.out.println("Метод с приоритетом 4");
    }

    @Test(priority = 7)
    public static void Method_2(){
        System.out.println("Метод с приоритетом 7");
    }

    @Test(priority = 1)
    public static void Method_3(){
        System.out.println("Метод с приоритетом 1");
    }

    @Test(priority = 10)
    public static void Method_4(){
        System.out.println("Метод с приоритетом 10");
    }

    @Test(priority = 4)
    public static void Method_5(){
        System.out.println("Метод с приоритетом 4");
    }

    @Test(priority = 2)
    public static void Method_6(){
        System.out.println("Метод с приоритетом 2");
    }

    @Test(priority = 8)
    public static void Method_7(){
        System.out.println("Метод с приоритетом 8");
    }

    @Test(priority = 7)
    public static void Method_8(){
        System.out.println("Метод с приоритетом 8");
    }

    @Test(priority = 3)
    public static void Method_9(){
        System.out.println("Метод с приоритетом 3");
    }

    @Test
    public static void Method_10(){
        System.out.println("Метод с дефолтным приоритетом (5)");
    }

}
