package stack;

import java.util.NoSuchElementException;

public class ArrayDropOutStack implements DropOutStack{
    private Object[] stack;
    private int top;

    public ArrayDropOutStack(int seize) {
        this.top = -1;
        this.stack = new Object[seize];
    }

    @Override
    public void push(Object element) {
        if(this.stack.length > top){
            top++;
            stack[top] = element;
        }else {
            Object temp = null;
            for(int i = 0; i < stack.length -1; i++){
                stack[i] = stack[i+1];
            }
            stack[top] = element;
            top--;
        }
    }

    @Override
    public Object pop() {
        Object temp = null;
        if(top != -1) {
            temp = stack[top];
            stack[top] = null;
            top--;
        }else {
            throw new NoSuchElementException();
        }
        return temp;
    }


    @Override
    public Object peek() {
        if(top != -1) {
            return stack[top];
        }else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int size() {
        return stack.length;
    }

    @Override
    public boolean isEmpty() {
        if(top == -1) {
            return true;
        }else {
            return false;
        }
    }

}
