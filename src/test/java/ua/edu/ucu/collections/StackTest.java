package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack();
        for (int i : new int[]{1, 2, 3, 4, 5}) {
            stack.push(i);
        }
    }

    @Test
    public void pop() {
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test(expected = IllegalArgumentException.class)
    public void popEmpty() {
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Test
    public void peek() {
        assertEquals(5, stack.peek());
        stack.pop();
        assertEquals(4, stack.peek());
    }

    @Test(expected = IllegalArgumentException.class)
    public void peekEmpty() {
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.peek();
    }
}
