
public class HomeWorkApp {
    public static void main(String[] args) {

        printThreeWords();
        System.out.println("----------");

        checkSumSign();
        System.out.println("----------");

        System.out.println(printColor(35));
        System.out.println(printColor(21));
        System.out.println(printColor(140));
        System.out.println("----------");

        System.out.println(compareNumbers(20, 15));
        System.out.println("----------");
    }
//Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
//_Orange
//_ Banana
//_ Apple
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
//Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите.
//Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
//то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
    public static void checkSumSign() {
        int a = 15;
        int b = -20;
        System.out.println("Сумма a + b = " + (a + b));
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
    //Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
    // если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
    // если больше 100 (100 исключительно) - “Зеленый”
    public static String printColor(int value) {
        if (value <= 0) {
            return "Красный";
        } else if (value > 0 && value <= 100) {
            return "Желтый";
        } else {
            return "Зеленый";
        }

    }
    //Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
    //и инициализируйте их любыми значениями, которыми захотите.
    //Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    public static String compareNumbers(int a, int b) {
        if (a >= b) {
            return "a >= b";
        } else {
            return "a < b";
        }
    }

}

