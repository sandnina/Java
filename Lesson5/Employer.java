package Lesson5;

    //1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.



    public class Employer {
        private String sirname;
        private String name;
        private String secondName;
        private String position;
        private String email;
        private int phoneNumber;
        private int salary;
        int age;

        //2. Конструктор класса должен заполнять эти поля при создании объекта.
        //3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.

        public Employer(String sirname, String name, String secondName, String position, String email, int phoneNumber, int salary, int age) {
            this.sirname = sirname;
            this.name = name;
            this.secondName = secondName;
            this.position = position;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.salary = salary;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getFullInfo() {
            return this.sirname + " " +
                    this.name + " " +
                    this.secondName + ", Должность: " +
                    this.position + ", email: " +
                    this.email + ", Телефон: " +
                    this.phoneNumber + ". Зарплата: " +
                    this.salary + " руб. Возраст: " +
                    this.age + " лет.";
        }



    }

