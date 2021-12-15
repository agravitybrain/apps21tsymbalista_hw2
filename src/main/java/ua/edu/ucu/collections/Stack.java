package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public void push(Object e) {
        stack = stack.addLast(e);
    }

    public Object pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Object lastElement = stack.getLast();
        stack = stack.removeLast();
        return lastElement;
    }

    public Object peek() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return stack.getLast();
    }
}
