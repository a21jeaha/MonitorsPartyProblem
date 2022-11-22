package New;

import java.util.Random;

public class Guest implements Runnable {

    private String name;
    private int drink;
    DrinkBowl drinkBowl;
    Random randomGenerator;
    int randomUpperLimit;
    int randomNumber;

    public Guest(DrinkBowl drinkBowl, String name) {
        this.name = name;
        this.drinkBowl = drinkBowl;
        drink = 0;
        randomGenerator = new Random();
        randomUpperLimit = 2000;
        randomNumber = randomGenerator.nextInt(randomUpperLimit);
    }

    private void getDrink() {
        drink = drinkBowl.getDrink();
        if (drink == 1) {
            System.out.println(name + " got a drink");
        } else {
            System.out.println("Did not get a drink...");
        }
    }

    private void mingle() {
        System.out.println(name + " is mingeling");
        // simulats mingeling
        try {
            Thread.sleep(randomNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void drink() {
        System.out.println(name + " emptied drink");
        drink--;
    }

    @Override
    public void run() {
        while (true) {
            mingle();
            getDrink();
            mingle();
            drink();
        }
    }
}