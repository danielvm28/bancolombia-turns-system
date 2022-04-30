package model;

public class CircularLinkedList {
    private Node head;
    private Node turn;
    private int size;

    public CircularLinkedList() {
        head = null;
        turn = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int giveTurn() {
        Node newNode = null;

        if (head == null) {
            newNode = new Node(1);
            head = newNode;
            head.setNext(head);
            head.setPrev(head);
            turn = head;
        } else {
            newNode = new Node(head.getPrev().getValue() + 1);

            Node tail = head.getPrev();

            head.setPrev(newNode);
            tail.setNext(newNode);
            newNode.setPrev(tail);
            newNode.setNext(head);
        }

        size++;

        return newNode.getValue();
    }

    public Node getTurn(){
        return turn;
    }

    /**
     * Returns true if the turn was passed and also deleted
     * @return a boolean indicating if the turn was deleted
     */
    public boolean passTurn(){
        turn.setPassedCounter(turn.getPassedCounter() + 1);

        if (turn.getPassedCounter() == 3) {
            deleteTurn();
            return true;
        }

        turn = turn.getNext();
        return false;
    }

    public void deleteTurn() {
        if (size != 1) {
            Node prev = turn.getPrev();
            Node next = turn.getNext();

            prev.setNext(next);
            next.setPrev(prev);

            if (turn.equals(head)) {
                head = next;
            }

            turn = next;
        } else {
            head = null;
            turn = null;
        }

        size--;
    }

    public void print() {
        print(head);
    }

    private void print(Node node) {
        // Base case
        if (node.getNext() == head) {
            System.out.println(node.getValue());
            return;
        }

        System.out.println(node.getValue());

        // Recursive
        print(node.getNext());
    }
}
