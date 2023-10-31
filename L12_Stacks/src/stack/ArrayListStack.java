package stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListStack implements StackI {
    private ArrayList<Object> stack;
    private int top;

    public ArrayListStack(){
        top = -1;
        stack = new ArrayList<>();
    }

    @Override
    public void push(Object element) {
        top ++;
        stack.add(top,element);
    }

    @Override
    public Object pop() {
        Object temp = null;
        if(top != -1) {
            temp = stack.get(top);
            stack.remove(top);
            top--;
        }else {
            throw new NoSuchElementException();
        }
        return temp;
    }

    @Override
    public Object peek() {
        if(top != -1) {
            return stack.get(top);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        if(stack.size() == 0){
            return true;
        }
        return false;
    }
}
