package com.eduardo.dataStructuresTesting;

import static com.eduardo.util.Util.*;

import com.eduardo.dataStructures.Queue;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QueueTest {

    private Queue<Person> staticQueue = new Queue<>();

    @BeforeEach
    void clear() {
        staticQueue = new Queue<>();
    }

    /*Enqueue test*/

    @Test
    void enqueueTest() {
        Person joshua = new Person(20, "Joshua", "Joshua@example.com", "1234567890");
        staticQueue.enqueue(joshua);
        
        assertEquals(1, staticQueue.getCurrentSize());
        staticQueue.show();

        staticQueue.enqueue(joshua);
        staticQueue.enqueue(joshua);
        staticQueue.enqueue(joshua);
        staticQueue.enqueue(joshua);
        
        assertEquals(5, staticQueue.getCurrentSize());
        staticQueue.show();
        
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> staticQueue.enqueue(joshua));
    }

    /*Dequeue test*/

    @Test
    void dequeueTest() {
        Person p1 = new Person(20, "Joshua", "Joshua@example.com", "1234567890");
        Person p2 = new Person(23, "Emilia", "emilia@example.com", "0987654321");
        Person p3 = new Person(27, "Otto", "otto@example.com", "7418529630");
        Person p4 = new Person(26, "Anna", "anna@example.com", "3692581470");
        Person p5 = new Person(22, "Anastasia", "anastasia@example.com", "1473690258");

        staticQueue.enqueue(p1);
        staticQueue.enqueue(p2);
        staticQueue.enqueue(p3);
        staticQueue.enqueue(p4);
        staticQueue.enqueue(p5);

        staticQueue.show();

        assertEquals(p1, staticQueue.dequeue());
        assertEquals(p2, staticQueue.dequeue());
        assertEquals(p3, staticQueue.dequeue());
        assertEquals(p4, staticQueue.dequeue());
        assertEquals(p5, staticQueue.dequeue());

        staticQueue.show();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> staticQueue.dequeue());
    }

    /*General tests*/

    @Test
    void peekTest() {
        Person p1 = new Person(20, "Joshua", "Joshua@example.com", "1234567890");
        Person p2 = new Person(23, "Emilia", "emilia@example.com", "0987654321");
        Person p3 = new Person(27, "Otto", "otto@example.com", "7418529630");
        Person p4 = new Person(26, "Anna", "anna@example.com", "3692581470");
        Person p5 = new Person(22, "Anastasia", "anastasia@example.com", "1473690258");

        staticQueue.enqueue(p1);
        staticQueue.enqueue(p2);
        staticQueue.enqueue(p3);
        staticQueue.enqueue(p4);
        staticQueue.enqueue(p5);

        staticQueue.show();

        assertEquals(p1, staticQueue.peek());
        System.out.println(staticQueue.peek());

        staticQueue.dequeue();

        assertEquals(p2, staticQueue.peek());
        System.out.println(staticQueue.peek());

        staticQueue.dequeue();

        assertEquals(p3, staticQueue.peek());
        System.out.println(staticQueue.peek());

        staticQueue.dequeue();
        staticQueue.dequeue();

        assertEquals(p5, staticQueue.peek());
        System.out.println(staticQueue.peek());

        staticQueue.dequeue();

        assertNull(staticQueue.peek());
        System.out.println(staticQueue.peek());
    }
    
    @Test
    void clearTest() throws Throwable {
        Person joshua = new Person(20, "Joshua", "Joshua@example.com", "1234567890");
        executeSmth(() -> staticQueue.enqueue(joshua), 5);

        assertNotNull(staticQueue.toList());
        staticQueue.show();

        staticQueue.clear();
        staticQueue.show();

        assertTrue(staticQueue.toList().isEmpty());
    }
    
    @Test
    void toListTest() throws Throwable {
        Person joshua = new Person(20, "Joshua", "Joshua@example.com", "1234567890");
        List<Person> expected = new ArrayList<>();

        executeSmth(() -> {
            staticQueue.enqueue(joshua);
            expected.add(joshua);
            }, 5);

        assertEquals(expected, staticQueue.toList());
        staticQueue.show();
        System.out.println(expected);

        executeSmth(() -> {
            staticQueue.dequeue();
            expected.removeLast();
        }, 3);

        assertEquals(expected, staticQueue.toList());
        staticQueue.show();
        System.out.println(expected);

        executeSmth(() -> {
            staticQueue.dequeue();
            expected.removeLast();
        }, 2);

        assertEquals(expected, staticQueue.toList());
        assertTrue(staticQueue.toList().isEmpty());
        staticQueue.show();
        System.out.println(expected);
    }

    @Test
    void circularPropertyTest() throws Throwable {
        Person joshua = new Person(20, "Joshua", "Joshua@example.com", "1234567890");
        executeSmth(() -> staticQueue.enqueue(joshua), 3);

        executeSmth(() -> staticQueue.dequeue(), 2);
        assertDoesNotThrow(() ->
                executeSmth(() -> staticQueue.enqueue(joshua), 3)
        );

        assertDoesNotThrow(() ->
                executeSmth(() -> staticQueue.dequeue(), 2)
        );

        assertDoesNotThrow(() ->
                executeSmth(() -> staticQueue.enqueue(joshua), 3)
        );

        assertDoesNotThrow(() ->
                executeSmth(() -> staticQueue.dequeue(), 2)
        );

        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                executeSmth(() -> staticQueue.enqueue(joshua), 3)
        );
    }

}
