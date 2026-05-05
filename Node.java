import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Node<T> {
    T value;
    private Lock lock;
    private Condition valueChanged;

    public Node(){
        lock = new java.util.concurrent.locks.ReentrantLock();
        valueChanged = lock.newCondition();
    }

    //SET VALUE AND NOTIFY ALL WAITING THREADS
    public void setValue(T newValue){
        lock.lock(); // acquire the lock before modifying the value
        try {
            value = newValue;
            System.out.println("Value set to: " + value);
            valueChanged.signalAll(); //notify all waiting threads that the value has changed
        } finally {
            lock.unlock();
        }
    }

    //Execute task when desired value is found
    public void executeOnValue(T desiredValue, Runnable task){
        lock.lock(); // Acquire the lock before checking the value
        try {
            // Wait until the value matches the desired value
            while (!value.equals(desiredValue)) {
                valueChanged.await();
            }

            task.run();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
