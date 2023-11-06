package queue;

import java.util.NoSuchElementException;

/**
 * An implementation of a queue as a linked list.
 */
public class NodeQueue implements QueueI
{
    private int size;
    private Node tail;
    private Node head;
    /**
     * Constructs an empty queue.
     */

    public NodeQueue()
    {
        // TODO: Assignment 1: Implement this constructor...
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    class Node
    {
        public Object data;
        public Node next;

        public Node(Object data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }

    @Override
    public void enqueue(Object element)
    {
        /*
        Que er first in first out, er en list hvor man inserter ind i enden af listen (tail),
        og sletter og tilgåes fra toppen
         */
        Node elementAddToQueNode =new Node(element);
        if(head == null){ // hvis Listen er tom så er peger linkedListens head og tail på det element der addes
            head = elementAddToQueNode; // head bliver sat til i quen at være det første element
            tail = head;  // tail sættes til at pege på første element
        }else {
            //
            tail.setNext(elementAddToQueNode); //Så adder man det nye element til LinkedListen
            tail = tail.getNext();  //sætter tail til at være det nye element
        }
        size++;

    }

    @Override
    public Object dequeue() {
        // TODO: Assignment 1: Implement this method...
        Object element = null;
        if(head == null){ // hvis head er null er listen tom
            throw new NoSuchElementException("Listen/køen er tom");

        }else { // eller skal man hente data der på head listen sætte head til at være næste i listen
            // og return data
            element = head.data; // henter data Objekt
            head = head.next; // sætter head til at være den næste i køen
        }
        size--;
        return element;


    }


    @Override
    public int size()
    {
        // TODO: Assignment 1: Implement this method...
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        // TODO: Assignment 1: Implement this method...
        if(size == 0){
            return true;
        }else {
            return false;
        }
    }
}


//        Node current = new Node(element);
//     if(head == null)
//     {
//       head = current;
//       tail = head;
//     }
//     else
//     {
//         tail.setNext(current);
//         tail = current;
//     }
//     size++;



//        if(head == null){
//            throw new NoSuchElementException("Der ikke flere elementer i klassen");
//        }
//        Node node = head;
//            head = head.next;
//            size--;
//            return node.data;