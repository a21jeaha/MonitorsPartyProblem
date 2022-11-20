package New;

public class Host implements Runnable {

    String name;
    DrinkBowl drinkBowl;
    int drinkFiller;

    public Host(DrinkBowl drinkBowl) {
        this.drinkBowl = drinkBowl;
        name = "Host";
        drinkFiller = 3;
    }

    public void needFill() {
        // try {
        // System.out.println(name + " is waiting to fill bowl");
        // drinkBowl.wait();
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        drinkBowl.fillBowl(drinkFiller, true);
        System.out.println(name + " filled the drink bowl");

    }

    @Override
    public void run() {
        needFill();
    }
}
