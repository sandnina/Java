package Lesson2;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class HomeWork2 {
    public static void main(String[] args){
        System.out.println(Method1(15, 10));
        System.out.println("----------");
        System.out.println(Method2(-7));
        System.out.println("----------");
        System.out.println(Method3(20));
        System.out.println("----------");
        Method4("Hello",5);
        System.out.println("----------");
        System.out.println(Method5(2001));
        System.out.println("----------");
    }

// 1. Написать метод, принимающий на вход два целых числа и проверяющий,
// что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
// в противном случае – false.

public static boolean Method1(int a, int b){
    return (a + b) >= 10 && (a + b) <= 20;
}


// 2. Написать метод, которому в качестве параметра передается целое число,
// метод должен напечатать в консоль, положительное ли число передали или отрицательное.
// Замечание: ноль считаем положительным числом.
public static String Method2(int a){
    if (a >= 0) return "Положительное";
    return "Отрицательное";
}

// 3. Написать метод, которому в качестве параметра передается целое число.
// Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
public static boolean Method3(int a){
    return a >= 0;
}

 // 4. Написать метод, которому в качестве аргументов передается строка и число,
// метод должен отпечатать в консоль указанную строку, указанное количество раз.
 public static void Method4(String a, int b){
     for (int i = 1; i <= b; i++){
         System.out.println(a);
     }
 }

//5.* Написать метод, который определяет, является ли год високосным,
// и возвращает boolean (високосный - true, не високосный - false).
// Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean Method5(int a) {
        if (a % 400 == 0) {
            return true;
        } else if (a % 100 == 0) {
            return false;
        } else return a % 4 == 0;
    }
}