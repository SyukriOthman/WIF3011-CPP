public class CheckCounter implements Runnable {
    private SharedData data;

    public CheckCounter(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        int lastSeenValue = 0;
        
        while (data.counter <= 4999) {
            //only print when the value actually changed from our last read
            if (data.counter != lastSeenValue) {
                System.out.println("Current counter value: " + data.counter);
                lastSeenValue = data.counter;
            }

            Thread.yield();
        }
        IncrementTask.stop = true; //signal the increment thread to stop once we reach 5000
    }
    
}
