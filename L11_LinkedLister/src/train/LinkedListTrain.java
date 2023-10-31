package train;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListTrain
{
    protected WagonNode firstWagon;
    private  int counter;



    /**
     * Constructs an empty linked list train.
     */

    public LinkedListTrain()
    {
        this.firstWagon = null;
    }

    /**
     * Returns the first wagon node in the linked list train.
     * 
     * @return the first wagon node
     * 
     * @throws NoSuchElementException if the train has no wagon nodes
     */
    public WagonNode getFirst()
    {
        if (this.firstWagon == null)
        {
            throw new NoSuchElementException();
        }
        return this.firstWagon;
    }

    /**
     * Adds a wagon node to the front of the linked list train.
     * 
     * @param wagon the wagon node to add
     */
    public void addFirst(WagonNode wagon)
    {
        // TODO: Assignment 1: Implement this add method...
        if(this.firstWagon == null){
            this.firstWagon = wagon;
            if(wagon.getPreviousWagon() == null){

            }
        }else {
            wagon.setNextWagon(this.firstWagon);
            firstWagon = wagon;
        }
        counter++;
    }

    /**
     * Removes the first wagon node in the linked list train.
     * 
     * @return the removed wagon node
     * 
     * @throws NoSuchElementException if the train has no wagon nodes
     */
    public WagonNode removeFirst()
    {
        WagonNode remove = null;
        if(firstWagon == null) {
            throw new NoSuchElementException();
        }else {
            remove = this.firstWagon;
            firstWagon = remove.getNextWagon();
            counter--;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        return remove;

    }

    /**
     * Counts the total number of wagon nodes in the linked list train.
     * 
     * @return the number of wagon nodes
     */
    public int count()
    {
        // TODO: Assignment 3: Implement this count method...
//        WagonNode holdWagon = firstWagon;
//        int sum = 0;
//        while (holdWagon != null){
//            sum++;
//           holdWagon = holdWagon.getNextWagon();
//        }
        return this.counter;
    }

    /**
     * Removes the first wagon node in the linked list train.
     * 
     * @param wagon the wagon node to remove
     * @return <code>true</code> if the wagon node was found and removed;
     *         <code>false</code> otherwise
     */
    public boolean remove(WagonNode wagon)
    {
        WagonNode current = firstWagon;
        WagonNode previous = null;

        while (current != null) {
            if (current == wagon) {
                previous.setNextWagon(current.getNextWagon());
                wagon.setNextWagon(null);
                return true;
            }
            previous = current;
            current = current.getNextWagon();
        }
        return false;
        // TODO: Assignment 4: Implement this remove method..
    }

    /**
     * Inserts a wagon node at a given position in the linked list train.
     * 
     * @param wagon    the wagon node to add
     * @param position the position where to add the wagon node
     */
    public void insertAt(WagonNode wagon, int position)
    {
        WagonNode current = firstWagon;
        WagonNode previous = null;
        int count = 0;

            while (current != null) {
                if (count == position) {
                    previous.setNextWagon(wagon);
                    wagon.setNextWagon(current);
                }
                previous = current;
                current = current.getNextWagon();
                count++;
            }

    }
}
