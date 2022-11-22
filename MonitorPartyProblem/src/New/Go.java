package New;

public class Go {
    // host waits untill a guest notifies that the bowl is empty
    public synchronized void host(int drinkFiller) {

        this.notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // guest notifies Host
    public synchronized void guest() {
        notify();
    }
}
