public class IncrementTask implements Runnable {
    public static boolean stop = false; //flag to signal when to stop incrementing
    private SharedData data;

    public IncrementTask(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (!stop) {
            data.counter++;
            System.out.println("Counter incremented: " + data.counter);

            Thread.yield();
        }
    }
}