package ua.edu.ucu.collections.immutable;

class ImmutableNode {
    Object value;
    ImmutableNode next;
    ImmutableNode prev;

    public ImmutableNode(Object val) {
        value = val;
    }

    public ImmutableNode(ImmutableNode node) {
        value = node.value;
        next = node.next;
        prev = node.prev;
    }


}
