package Lesson6;

public class RunSwim {

    public static void main(String[] args) {
        String tempWinEvent = ". И это получается!";
        String tempLossEvent = ". Но не получается.";
        String tryDo;
        String canDo;
        Dog dog1 = new Dog("Собака", "Тузик", 20, 250);
        Dog dog2 = new Dog("Собака", "Шарик", 8, 500);
        Cat cat1 = new Cat("Кот", "Пушок", 1, 100);
        Cat cat2 = new Cat("Кот", "Маркиз", 5, 80);

        Animal[] animals = {dog1, dog2, cat1, cat2};

        int runTry = 500;
        int swimTry = 10;

        for (int i = 0; i < animals.length; i++) {
            String finalRun = animals[i].type + " " + animals[i].name + " может ";
            canDo = "пробежать " + animals[i].maxRun + " м. А пытается пробежать " + runTry;
            tryDo = animals[i].run (runTry) ? tempWinEvent : tempLossEvent;
            result(finalRun, canDo, tryDo);

            int finalSwim = animals[i].swim(swimTry);
            canDo = "проплыть на " + animals[i].maxSwim + " м. А пытается проплыть на " + swimTry;
            tryDo = (finalSwim == Animal.swim_yes) ? tempWinEvent : tempLossEvent;

            if (finalSwim == Animal.swim_no)
                tryDo = ". И это не получается, т.к. не умеет плавать";
            result(finalRun, canDo, tryDo);
        }

        System.out.println("Всего животных " + Animal.countAnimal + ". Котов " + Cat.countCat + ". Собак " + Dog.countDog);

    }

    private static void result(String str1, String str2, String str3) {
        System.out.println(str1 + str2 + str3);
    }
}


