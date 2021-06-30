package Lesson6;

public class Dog extends Animal {
    public static int countDog = 0;

    public Dog(String type, String name, int maxSwim, int maxRun) {
        super(type, name, maxSwim, maxRun);
        ++countDog;
    }
}
