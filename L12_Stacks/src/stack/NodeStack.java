package stack;

import java.time.temporal.Temporal;
import java.util.NoSuchElementException;

public class NodeStack implements StackI{
    Node top;
    private static int  size;

    public NodeStack(){

    }

    class Node
    {
        public Object data;
        public Node next;

        Node(Object data){
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
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
    public void push(Object element) {
        if(top != null) {
            Node temp = new Node(element);
            temp.setNext(top);
            top = temp;
        } else {
            this.top = new Node(element);
        }
        size++;
    }

    @Override
    public Object pop() {
        Object temp = null;
        if(top != null){
           temp = top.getData();
           top.setData(null);
           top = top.getNext();
        }else {
            throw new NoSuchElementException();
        }
        size--;
        return temp;
    }

    @Override
    public Object peek() {
        Object temp;
        if(top != null){
            temp = top.getData();
        }else {
            throw new NoSuchElementException();
        }
        return temp;
    }

    @Override
    public int size() {
        return size;

//        int counter = 0;
//        Node temp = top;
//
//        while (temp != null){
//            counter ++;
//            temp = temp.getNext();
//        }
//        return counter;

    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
            return false;
    }
}
