package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableLinkedList {

    private ImmutableNode head;
    private ImmutableNode tail;

    public ImmutableLinkedList() {
        head = null;
        tail = null;
    }

    public ImmutableLinkedList(Object[] objects) {
        ImmutableNode[] nodes = objectsToNodes(objects);

        head = nodes[0];
        if (objects.length != 1) {
            tail = nodes[nodes.length - 1];
        }

    }

    ImmutableNode[] objectsToNodes(Object[] objects) {
        ImmutableNode[] nodes = new ImmutableNode[objects.length];
        for (int i = 0; i < objects.length; i++) {
            nodes[i] = new ImmutableNode(objects[i]);
            if (i - 1 >= 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        return nodes;
    }

    public ImmutableLinkedList(ImmutableLinkedList linkedList) {
        if (linkedList.size() == 1) {
            head = new ImmutableNode(linkedList.head);

        } else {
            head = new ImmutableNode(linkedList.head);
            ImmutableNode previousNode = head;
            ImmutableNode currentNode = linkedList.head.next;
            ImmutableNode newNode = null;
            while (currentNode.next != null) {
                newNode = new ImmutableNode(currentNode);
                previousNode.next = newNode;
                newNode.prev = previousNode;
                previousNode = newNode;
                currentNode = currentNode.next;
            }
            tail = new ImmutableNode(currentNode);
            tail.prev = previousNode;

        }
    }


    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (size() == 0) {
            ImmutableNode newNode = new ImmutableNode(c);
            return new ImmutableLinkedList(c);
        }
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        ImmutableNode[] nodes = objectsToNodes(c);
        if (index + c.length < linkedList.size()) {
            ImmutableNode finishNode = linkedList.getNode(index + c.length - 1);
            finishNode.prev = nodes[nodes.length - 1];
        }
        if (index != 0) {
            ImmutableNode startNode = linkedList.getNode(index - 1);
            startNode.next = nodes[0];
            nodes[0].prev = startNode;
        } else {
            nodes[nodes.length - 1].next = linkedList.head;
            linkedList.head = nodes[nodes.length - 1];
        }

        if (linkedList.tail == null) {
            linkedList.tail = nodes[nodes.length - 1];
        }
        return linkedList;

    }


    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size(), c);
    }

    public ImmutableLinkedList add(int index, Object e) {
        Object[] objectArray = new Object[]{e};
        return addAll(index, objectArray);
    }


    public ImmutableLinkedList add(Object e) {
        return add(size(), e);
    }


    Object get(int index) {
        return getNode(index).value;
    }

    ImmutableNode getNode(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            ImmutableNode curNode = head;
            int i = 0;
            while (i != index) {
                curNode = curNode.next;
                i++;
            }
            return new ImmutableNode(curNode);
        }
    }

    public ImmutableLinkedList remove(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        ImmutableNode curNode = linkedList.getNode(index);
        ImmutableNode prevNode = curNode.prev;
        ImmutableNode nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        return linkedList;
    }

    public ImmutableLinkedList set(int index, Object e) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        ImmutableNode curNode = linkedList.getNode(index);
        curNode.value = e;
        return linkedList;

    }

    public int indexOf(Object e) {
        int index = 0;
        ImmutableNode curNode = this.head;
        while (curNode != null) {
            if (curNode.value == e) {
                return index;
            } else {
                index++;
                curNode = curNode.next;
            }
        }
        return -1;
    }

    int size() {
        if (isEmpty()) {
            return 0;
        }
        ImmutableNode curNode = head;
        int s = 0;
        while (curNode != null) {
            curNode = curNode.next;
            s++;
        }
        return s;
    } //розмір колекції

    ImmutableLinkedList clear() {
        return new ImmutableLinkedList();

    } //очищує вміст колекції

    boolean isEmpty() {
        return head == null;
    } //якщо у колеції нема елементів то повертає true

    Object[] toArray() {
        int arrSize = size();
        Object[] array = new Object[arrSize];
        ImmutableNode curNode = head;
        int i = 0;
        while (curNode != null) {
            array[i] = curNode.value;
            curNode = curNode.next;
            i++;
        }
        return array;
    } //перетворює колекцію до масиву обєктів

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    } //повертає рядок, де через кому відображаютсься елементи колекції

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(size() - 1, e);
    }

    public Object getFirst() {
        return get(0);

    }

    public Object getLast() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(size() - 1);
    }


}
