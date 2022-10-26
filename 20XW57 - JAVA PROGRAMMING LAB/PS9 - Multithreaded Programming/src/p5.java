import java.lang.*;
import java.util.*;

public class p5 {
    public static void main(String args[]) {
        Queue<Integer> sharedQueue = new LinkedList<>();
        int size = 5;
        new Thread(new Producer(sharedQueue, size), "Producer").start();
        new Thread(new Consumer(sharedQueue, size), "Consumer").start();
    }
}

class Producer implements Runnable {

    private final Queue<Integer> sharedQueue;
    private final int SIZE;

    public Producer(Queue<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                System.out.println("Produced: " + (i) + " (" + sharedQueue.size() + "/" + SIZE + ")");
                produce(i++);
            } catch (InterruptedException ex) {
                System.err.println("Producer interrupted. Error ==> " + ex);
            }

        }
    }

    private void produce(int i) throws InterruptedException {

        // wait if the queue is full
        while (sharedQueue.size() == SIZE) {
            synchronized (sharedQueue) {
                System.out.println("The queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        // producing element and notify consumers
        synchronized (sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}

class Consumer implements Runnable {

    private final Queue<Integer> sharedQueue;
    private final int SIZE;

    public Consumer(Queue<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume() + " (" + sharedQueue.size() + "/" + SIZE + ")");
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.err.println("Consumer interrupted. Error ==> " + ex);
            }

        }
    }

    private int consume() throws InterruptedException {
        // wait if the queue is empty
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                System.out.println("The queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        // Otherwise consume element and notify the waiting producer
        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return sharedQueue.remove();
        }
    }
}
