package Lesson6;

public class Cat extends Animal {
    public static int countCat = 0;

    public Cat(String type, String name, int maxSwim, int maxRun) {
        super(type, name, maxSwim, maxRun);
        ++countCat;
    }
    @Override
    public int swim(int distance) {
        return Animal.does_not_swim;
    }

}
