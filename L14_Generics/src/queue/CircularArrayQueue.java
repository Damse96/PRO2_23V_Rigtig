package queue;

import java.util.NoSuchElementException;

/**
 * An implementation of a queue as a circular array.
 */
public class CircularArrayQueue implements QueueI
{
    private Object[] elements;
    private int currentSize;
    private int head;
    private int tail;

    /**
     * Constructs an empty queue.
     */
    public CircularArrayQueue(int size)
    {
        elements = new Object[size];
        currentSize = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public void enqueue(Object element)
    {
        growIfNecessary();
        currentSize++; //antal add til array
        elements[tail] = element;
        tail = (tail + 1) % elements.length;// holder styr på man ikke kommer ud fra arrays length hvis
        /*
        Så kigger man på tail++
        for et array [null][head][ex][tail] længde = 4
        hvis man vil add til det skal man adde til index [null pladsen]
        tail++;
        tail++  (fra tail =3 til 4) = 4
        men der er ikke nogle 4 del af array da array er 0 1 2 3 pladser
        Men i stedet for 4 vil man her have 0
        så måden er at
        tail = tail++ % array.length (=4)

        længde 4 da der kan være 4 elementer  på index plads 3 +1 = 4
        tail = 4 % 4 = 0

        så hvis tail = 3 og længden er 4  og index 0 af fx arrayet er null (tomt) så vil
        man ved tail =3 (index)  få   tail = (3+1) % 4 = 0

        Næste gang man så vil add til array og man har tail = 0  vil den blive
        tail = (0+1) & 4 = 1

        linjen  tail++ % længde giver ikke andet fx at bruge tail++ men når man når tail++ = 4 at
        % 4 bliver effektiv og man får 0  ellers er 0 % 4  osv lig med fx 0

         */
    }

    public Object[] getElements() {
        return elements;
    }

    @Override
    public Object dequeue()
    {
        if (currentSize == 0)
        {
            throw new NoSuchElementException();
        }
        Object removed = elements[head];
        head = (head + 1) % elements.length;
        currentSize--;
        return removed;
        /*
        Når man fjerner fra head  og head kommer til enden af arrayet
        Que har længden 4  [ex][tail][null][head] så følgende antagelse deletede fra head og add fra tail
        hvis man vil delte fra front vil position gå 4 ved head++
        så når  head fjernes skal head nu pege på ex (fra index 3 til index 0)
        benytter samme logik fra  tail
        head = head++ % længde (=4)





         */
    }

    @Override
    public int size()
    {
        return currentSize;
    }

    @Override
    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    /**
     * Grows the element array if the current size equals the capacity.
     */
    private void growIfNecessary()
    {
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
