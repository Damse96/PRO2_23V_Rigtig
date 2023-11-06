package deque;

import bryghus.Produkt;
import bryghus.Salg;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue.CircularArrayQueue;
import queue.NodeQueue;
import queue.QueueI;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CircularArrayDequeTest {
    private DequeI dequeI;

    private Salg salg1;
    private Salg salg2;
    private Salg salg3;
    private Salg salg4;
    private Salg salg5;
    private Salg salg6;

    @BeforeEach
    void setUp() throws Exception
    {
        // --------------------------------------------------
        // ARRANGE
        // --------------------------------------------------

        this.dequeI= new CircularArrayDeque(6);

        Produkt kloster = new Produkt("Klosterbryg");
        Produkt sweet = new Produkt("Sweet Georgia Brown");
        Produkt extra = new Produkt("Extra Pilsner");
        Produkt classic = new Produkt("Classic Jazz");
        Produkt klippekort10 = new Produkt("Klippekort 10 klip");
        Produkt klippekort6 = new Produkt("Klippekort 6 klip");

        this.salg1 = new Salg(1);
        this.salg1.createSalgsLinje(kloster, 2, 40);

        this.salg2 = new Salg(2);
        this.salg2.createSalgsLinje(sweet, 3, 60);

        this.salg3 = new Salg(3);
        this.salg3.createSalgsLinje(extra, 2, 40);

        this.salg4 = new Salg(4);
        this.salg4.createSalgsLinje(classic, 3, 60);

        this.salg5 = new Salg(5);
        this.salg5.createSalgsLinje(klippekort10, 1, 160);

        this.salg6 = new Salg(6);
        this.salg6.createSalgsLinje(klippekort6, 2, 200);
    }

    @Test
    void addFirst_remove_first() {

        dequeI.addLast(salg1);
        dequeI.addLast(salg2);
        dequeI.addLast(salg3);
        dequeI.addLast(salg4);
        dequeI.addLast(salg5);
        dequeI.addLast(salg6);

        Salg salgTilBehandling = (Salg) dequeI.removeFirst();
        assertEquals(salg1, salgTilBehandling);

        salgTilBehandling = (Salg) dequeI.removeFirst();
        assertEquals(salg2, salgTilBehandling);

        salgTilBehandling = (Salg) dequeI.removeFirst();
        assertEquals(salg3, salgTilBehandling);

        salgTilBehandling = (Salg) dequeI.removeFirst();
        assertEquals(salg4, salgTilBehandling);

        salgTilBehandling = (Salg) dequeI.removeFirst();
        assertEquals(salg5, salgTilBehandling);

        salgTilBehandling = (Salg) dequeI.removeFirst();
        assertEquals(salg6, salgTilBehandling);

        assertThrows(NoSuchElementException.class, () -> {
            dequeI.removeFirst();
        });

    }

    @Test
    void addLast_remove_last() {
        //Assemble
        dequeI.addLast(salg1);
        dequeI.addLast(salg2);
        dequeI.addLast(salg3);
        dequeI.addLast(salg4);
        dequeI.addLast(salg5);
        dequeI.addLast(salg6);

        Salg salgTilBehandling = (Salg) dequeI.removeLast();
        assertEquals(salg1, salgTilBehandling);

        salgTilBehandling = (Salg) dequeI.removeLast();
        assertEquals(salg2, salgTilBehandling);

        salgTilBehandling = (Salg) dequeI.removeLast();
        assertEquals(salg3, salgTilBehandling);

        salgTilBehandling = (Salg) dequeI.removeLast();
        assertEquals(salg4, salgTilBehandling);

        salgTilBehandling = (Salg) dequeI.removeLast();
        assertEquals(salg5, salgTilBehandling);

        salgTilBehandling = (Salg) dequeI.removeLast();
        assertEquals(salg6, salgTilBehandling);



        assertThrows(NoSuchElementException.class, () -> {
            dequeI.removeLast();
        });


        //ACT


        //ASSERT
    }



    @Test
    void size() {
        assertEquals(0,dequeI.size());
        dequeI.addLast(salg1);
        assertEquals(1,dequeI.size());
        dequeI.addLast(salg2);
        assertEquals(2,dequeI.size());
        dequeI.addLast(salg3);
        assertEquals(3,dequeI.size());
        dequeI.addLast(salg4);
        assertEquals(4,dequeI.size());
        dequeI.addLast(salg5);
        assertEquals(5,dequeI.size());
        dequeI.addLast(salg6);
        assertEquals(6,dequeI.size());
    }




    @Test
    void isEmpty() {
        assertTrue(dequeI.isEmpty());
        dequeI.addLast(salg1);
        assertFalse(dequeI.isEmpty());
        dequeI.removeFirst();
        assertTrue(dequeI.isEmpty());
    }
}