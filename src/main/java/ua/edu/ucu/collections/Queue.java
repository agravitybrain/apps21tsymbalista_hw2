package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue = new ImmutableLinkedList();

    public Object peek() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return queue.getFirst();
    }

    public Object dequeue() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Object element = queue.getFirst();
        queue = queue.removeFirst();
        return element;
    }

    public void enqueue(Object e) {
        queue = queue.addLast(e);
    }
}
