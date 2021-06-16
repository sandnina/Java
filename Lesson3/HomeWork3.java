package Lesson3;

import java.util.Arrays;

public class HomeWork3 {
    public static void main(String[] args) {
        int[] array1 = { 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        Method1(array1);
        System.out.println("---------------");
        int[] nullArray = new int[100];
        Method2(nullArray);
        System.out.println("---------------");
        int[] mulArray = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        Method3(mulArray);
        System.out.println("---------------");
        int size = 5;
        int[][] digArray = new int[size][size];
        Method4(digArray);
        Print2(digArray);
        System.out.println("---------------");
        int[] returnArrayBack = Method5(5, 10);
        System.out.println("Массив5 " + Arrays.toString(returnArrayBack));
    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void Method1(int[] array1) {
        System.out.println("Массив до " + Arrays.toString(array1));
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                array1[i] = 1;
            } else array1[i] = 0;
            }
        System.out.println("Массив после " + Arrays.toString(array1));
        }

    //2. Задать пустой целочисленный массив длиной 100.
    // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    public static void Method2(int[] nullArray) {
          for (int i = 0; i < nullArray.length; i++) {
            nullArray[i] = i + 1;
        }
        System.out.println("Заполненный массив " + Arrays.toString(nullArray));
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    // и числа меньшие 6 умножить на 2;
    public static void Method3(int[] mulArray) {
        System.out.println("Массив " + Arrays.toString(mulArray));
        for (int i = 0; i < mulArray.length; i++) {
            if (mulArray[i] < 6) {
                mulArray[i] = mulArray[i] * 2;
            } else mulArray[i] = mulArray[i];
        }
        System.out.println("Массив после умножения " + Arrays.toString(mulArray));
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну
    // из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему
    // принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    public static void Method4(int[][] digArray) {
        for (int i = 0; i < digArray.length; i++) {
            digArray[i][i] = 1;
        }
    }
        public static void Print2(int[][] digArray) {
        for (int i = 0; i < digArray.length; i++) {
            for (int j = 0; j < digArray[i].length; j++) {
                System.out.print(digArray[i][j] + " ");
            }
            System.out.println();
        }

    }

    //5. Написать метод, принимающий на вход два аргумента: len и initialValue,
    // и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
    public static int[] Method5(int len, int initialValue) {
        int[] ArrayBack = new int[len];
        for (int i = 0; i < ArrayBack.length; i++) {
            ArrayBack[i] = initialValue;
        }
        return ArrayBack;
    }

    //6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    // (к сожалению, не успела выполнить)


    //7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    //**Примеры:
    //checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
    //checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
    //checkBalance([1, 1, 2, 1]) → false
    //граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
    // (к сожалению, не успела выполнить)


}














































