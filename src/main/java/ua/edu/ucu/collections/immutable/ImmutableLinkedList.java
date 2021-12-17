package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private final Node head = new Node();
    private final Node tail;
    private int length = 0;

    public ImmutableLinkedList(Object[] elements) {
        Node currentNoderentNode = head;
        head.setValue(elements[0]);
        length++;
        for (Object element:
                Arrays.copyOfRange(elements, 1, elements.length)) {
            final Node nextNode = new Node();
            nextNode.setValue(element);

            nextNode.setPrevious(currentNoderentNode);
            currentNoderentNode.setNext(nextNode);
            length++;

            currentNoderentNode = nextNode;
            }
        tail = currentNoderentNode;
    }

    public ImmutableLinkedList() {
        tail = head;
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(length, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newArray = new Object[length + c.length];
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            newArray[i] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        System.arraycopy(c, 0, newArray, index, c.length);

        for (int k = index + c.length; k < length + c.length; k++) {
            newArray[k] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }

        return new ImmutableLinkedList(newArray);
    }

    @Override
    public Object get(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= length) {
            throw new IllegalArgumentException();
        }
        if (length == 1) {
            return new ImmutableLinkedList();
        }
        Object[] newArray = new Object[length - 1];
        Node currentNode = head;
        for (int i = 0; i < length - 1; i++) {
            if (i == index) {
                currentNode = currentNode.getNext();
            }
            newArray[i] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return new ImmutableLinkedList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newArray = new Object[length];
        Node currentNode = head;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                newArray[i] = e;
            } else {
                newArray[i] = currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }
        return new ImmutableLinkedList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        int index = -1;

        Node currentNode = head;

        for (int i = 0; i < length; i++) {
            if (currentNode.getValue().equals(e)) {
                index = i;
                return index;
            }
            currentNode = currentNode.getNext();
        }
        return index;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        Node currentNode = head;
        for (int i = 0; i < length; i++) {
            array[i] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return array;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) addAll(0, new Object[]{e});
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) addAll(length, new Object[]{e});
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return this.getHead().getValue();
    }

    public Object getLast() {
        return this.getTail().getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(length-1);
    }
}
