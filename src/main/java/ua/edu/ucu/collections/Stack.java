package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList linkedList;
    public Stack() {
        linkedList = new ImmutableLinkedList();
    }
    public Object peek() {
        return linkedList.getLast();
    }

    public Object pop() {
        Object elem = linkedList.getLast();
        linkedList = linkedList.removeLast();
        return elem;
    }

    public void push(Object e) {
        linkedList = linkedList.addLast(e);
    }

}