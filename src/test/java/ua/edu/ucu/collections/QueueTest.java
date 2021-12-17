package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    Queue queue;
    @Before
    public void setUp() {
        queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
    }

    @Test
    public void dequeue() {
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }


    @Test(expected = IllegalArgumentException.class)
    public void dequeueEmpty() {
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }

    @Test
    public void peek() {
        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.peek());

        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.peek());
    }

    @Test(expected = IllegalArgumentException.class)
    public void peekEmpty() {
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.peek();
    }


}
