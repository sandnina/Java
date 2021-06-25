package Lesson6;

//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
//Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
//плавание: кот не умеет плавать, собака 10 м.).
//4. * Добавить подсчет созданных котов, собак и животных.

public abstract class Animal {
    static final int swim_yes = 1;
    static final int swim_no = 2;
    static final int does_not_swim = 3;

    protected String type;
    protected String name;
    protected int maxSwim;
    protected int maxRun;

    public static int countAnimal = 0;

    public Animal(String type, String name, int maxSwim, int maxRun) {
        this.type = type;
        this.name = name;
        this.maxSwim = maxSwim;
        this.maxRun = maxRun;
        ++countAnimal;
    }
    protected boolean run (int distance) {
        return (distance <= maxRun);
    }

    protected int swim (int distance) {
        return (distance <= maxSwim) ? swim_yes : swim_no;
    }
}
