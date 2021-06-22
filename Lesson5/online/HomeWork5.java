package Lesson5.online;

import Lesson5.Employer;

import java.util.Arrays;

public class HomeWork5 {

    public static void main(String[] args) {

        Employer employer1 = new Employer("Иванов", "Иван", "Иванович", "Инженер", "mail1@mail.ru", 1111111, 50000, 42);

        //4.Создать массив из 5 сотрудников.

        Employer[] list = {new Employer("Петров", "Петр", "Петрович", "Конструктор", "mail2@mail.ru", 2222222, 60000, 41),
                new Employer("Сидоров", "Сидор", "Сидорович", "Испытатель", "mail3@mail.ru", 3333333, 45000, 27),
                new Employer("Харитонов", "Харитон", "Харитонович", "Химик", "mail4@mail.ru", 4444444, 65000, 50),
                new Employer("Юрьев", "Юрий", "Юрьевич", "Технолог", "mail5@mail.ru", 5555555, 47000, 53),
                new Employer("Смирнова", "Мария", "Ивановна", "Секретарь", "mail6@mail.ru", 6666666, 35000, 25)
        };
        System.out.println(employer1.getFullInfo());
        System.out.println("---------------");
        allEmployers(list);
        System.out.println("---------------");
        Age(list);
    }

    private static void allEmployers(Employer[] list) {
        System.out.println("Список сотрудников: ");
        for (int i = 0; i < list.length; i++ )
            System.out.println(list[i].getFullInfo());
    }


    private static void Age(Employer[] list) {
         for (int i = 0; i < list.length; i++ )
             if (list[i].getAge() > 40)
            System.out.println(list[i].getFullInfo());

    }





    }




//5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
    //public static boolean Age () {
      //  if (Employer.age
    //}



