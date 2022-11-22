package New;

public class MonitorObject {
    public synchronized void monitor() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
