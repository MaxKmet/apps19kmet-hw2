package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedList;
    public Queue() {
        linkedList = new ImmutableLinkedList();
    }

    public Object dequeue() {
        Object first = linkedList.get(0);
        linkedList = linkedList.removeFirst();
        return first;
    }

    public Object peek() {
        return linkedList.get(0);
    }

    public void enqueue(Object e) {
        linkedList = linkedList.addLast(e);
    }

}