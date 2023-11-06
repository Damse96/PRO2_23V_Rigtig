package cannibal;

import java.util.NoSuchElementException;
import java.util.Random;

public class CircularCannibalMeal implements QueueI {

    private Person head;
    private Person tail;
    private int size;





    public CircularCannibalMeal() {


    }



    public void addPerson(Person p){
        Person current = p;
        if(head == null)
        {
            head = current;
            tail = head;
        }
        else
        {
            tail.setNext(current);
            tail = tail.getNext();
            tail.setNext(head);
        }

        size++;


    }



    public Person eatRandomPerson(){
       Random r = new Random();
      int personNr =  r.nextInt(0,size);

        System.out.println(personNr);

        Person current = head;
        Person previous = null;
        Person temp = null;

        int count = 0;

        if(size == -1){
           throw new NoSuchElementException("No Elements in the List");
        }else {
            if(personNr == 0){ // sikre at preveious bliver sat, fordi den kommer aldrig ind i while
                previous = current;
                current = current.getNext(); // sikre at fx går = A til  = B
            }
            else {
                while (count < personNr) {
                    previous = current;
                    current = current.getNext();
                    count++;
                    count = count % size;
                }
            }

            previous.setNext(current.getNext());
            previous = previous.getNext();
        }
        if(head == current){
            head = current.getNext();
        }
        temp = current;
        size--;

        return  temp;









    }

    public Person eatNextPerson(int count ){
        Person current = head;


        Person previous = null;
        Person temp = null;
        int counting = 0;


        if(size == -1){
           throw new NoSuchElementException("Ikke flere ");
        }else {
//           for(int i = 0; i < count; i++){
            while (counting < count){ // køre til den er counting = 4 og en sidste gange +1 =  counting = 5
                    previous = current;
                    current = current.getNext();

                counting++;
                counting = counting % size; //sikre at når den køre rundt ikke begynder at give mærkelig nummer
            }
            previous.setNext(current.getNext());
            previous = previous.getNext();
        }
        if(head == current){
            head = current.getNext();
        }

        temp = current;
        System.out.println(temp.getNavn() + " " + counting);
//        System.out.println(temp.getNavn());

        size--;

        return  temp;
    }


    public void printPersons(){
        Person current = head;
        System.out.println("Size is " + size);
        System.out.println();

        for(int i = 0; i < size; i++){
            System.out.println(current.getNavn() + " " + i);
            current = current.getNext();

        }






    }

    @Override
    public void enqueue(Object element) {



    }



    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        if(size == 0){
            return true;
        }
        return false;
    }



}
