package New;

import javax.management.monitor.Monitor;

public class App {

    public App() {

    }

    public static void main(String[] args) throws Exception {
        Go go = new Go();
        MonitorObject monitorObject = new MonitorObject();

        DrinkBowl drinkBowl = new DrinkBowl(go, monitorObject);

        Host host = new Host(drinkBowl);

        Guest guest1 = new Guest(drinkBowl, "guest1");
        Guest guest2 = new Guest(drinkBowl, "guest2");
        Guest guest3 = new Guest(drinkBowl, "guest3");
        Guest guest4 = new Guest(drinkBowl, "guest4");
        Guest guest5 = new Guest(drinkBowl, "guest5");

        Thread thread1 = new Thread(host);
        Thread thread2 = new Thread(guest1);
        Thread thread3 = new Thread(guest2);
        // Thread thread4 = new Thread(guest3);
        // Thread thread5 = new Thread(guest4);
        // Thread thread6 = new Thread(guest5);

        thread1.start();
        thread2.start();
        thread3.start();
        // thread4.start();
        // thread5.start();
        // thread6.start();

    }
}
