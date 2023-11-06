package deque;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/*
    så husk en que appender man til enden af en que og fjernet fra begyndelsen af quen

    Deque extender Queue interface derfor kan man bruge LinkedList fx til at lave en queue
    LinkedList er ideal for queue operationer da det er effektiv for inerserting og removing elementer
    fra begge ender

    Queue interface extends Collection interface for at give ekstra insertion og extraction, og inseption
    operationer

    LinkedList implements List og Deque

    Deque understøtter interstion og remvoal ved begge ender
    udtales deck

    Dequeue exenteds Queue med ekstra metoder for indsætte og fjerne elementer fra begge ender que
    The
    methods addFirst(e), removeFirst(), addLast(e), removeLast(), getFirst(), and
    getLast() are defined in the Deque interface.


 */

public class CircularArrayDeque implements DequeI{

    private Object[] elements;
    private int currentSize;
    private int head;
    private int tail;


    public CircularArrayDeque(int size) {
        elements = new Object[size];
        currentSize = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public void addFirst(Object element) {
        growIfNecessary();
        currentSize++;
        elements[head] = element;
        head = (head + 1) % elements.length;

    }

    @Override
    public void addLast(Object element) {
        growIfNecessary();
        currentSize++;
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
    }



    @Override
    public Object removeFirst() {
        if(currentSize == 0){
            throw new NoSuchElementException("Ikke flere elementer");
        }
        Object fjernet = elements[head];
        head = (head + 1) % elements.length;
        currentSize--;
        return fjernet;
    }

    @Override
    public Object removeLast() {
        if(currentSize == 0){
            throw new NoSuchElementException("Ikke flere elementer");
        }
        Object fjernet = elements[tail];
        tail = (tail + 1) % elements.length;
        currentSize--;
        return fjernet;
    }



    @Override
    public Object getFirst() {
      return elements[head];
    }

    @Override
    public Object getLast() {
        return elements[tail];
    }


    @Override
    public int size() {
       return currentSize;
    }

    @Override
    public boolean isEmpty() {
       if(currentSize == 0){
           return true;
       }
       return false;
    }




    private void growIfNecessary() {
        if (currentSize == elements.length)
        {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < elements.length; i++)
            {
                newElements[i] = elements[(head + i) % elements.length];
            }
            elements = newElements;
            head = 0;
            tail = currentSize;
        }

    }
}
