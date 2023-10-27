import java.util.*;
class SimpleLinkedList<T> {

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    SimpleLinkedList() {
//        throw new UnsupportedOperationException("Please implement the SimpleLinkedList() constructor.");
    }

    SimpleLinkedList(T[] values) {
//        throw new UnsupportedOperationException("Please implement the SimpleLinkedList(T[]) constructor.");
        Arrays.stream(values).forEach((this::push));
    }

    void push(T value) {
//        throw new UnsupportedOperationException("Please implement the SimpleLinkedList.push() method.");
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    T pop() {
//        throw new UnsupportedOperationException("Please implement the SimpleLinkedList.pop() method.");
        if (head == null) throw new NoSuchElementException();
        T result = head.data;
        if (size() == 1) {
            head = null;
            tail = null;
            return result;
        }
        Node currentNode = head;
        while (currentNode.next != tail) {
            currentNode = currentNode.next;
        }
        result = tail.data;
        currentNode.next = null;
        tail = currentNode;
        return result;
    }

    List<T> getList(Node currentNode) {
        if (currentNode == null) return new ArrayList<>();
        if (currentNode == tail) return new ArrayList<>(Collections.singletonList(currentNode.data));

        List<T> result = getList(currentNode.next);
        result.add(currentNode.data);
        return result;
    }
    void reverse() {
//        throw new UnsupportedOperationException("Please implement the SimpleLinkedList.reverse() method.");
        List<T> list = getList(head);
        head = null;
        tail = null;
        list.forEach(this::push);
    }

    Character[] asArray(Class<T> characterClass) {
//        throw new UnsupportedOperationException("Please implement the SimpleLinkedList.asArray() method.");
        return getList(head).toArray(new Character[0]);
    }

    int size() {
//        throw new UnsupportedOperationException("Please implement the SimpleLinkedList.size() method.");
           if (head == null) return 0;
           int count = 1;
           Node currentNode = head;
           while (currentNode.next != null) {
               count++;
               currentNode = currentNode.next;
           }
           return count;
    }
}