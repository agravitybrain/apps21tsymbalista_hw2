package ua.edu.ucu.collections.immutable;

public class Node {
    private Node previous;
    private Node next;
    private Object value;

    public Node() {
    }

    @Override
    public String toString() {
        return value.toString();
    }


    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node newPrevious) {
        this.previous = newPrevious;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object newValue) {
        this.value = newValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node newNext) {
        this.next = newNext;
    }
}

