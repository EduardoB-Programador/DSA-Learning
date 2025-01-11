package com.eduardo.dataStructuresTesting;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import com.eduardo.dataStructures.Stack;
import com.eduardo.dataStructures.StaticStack;
import com.eduardo.dataStructures.DynamicStack;

import static com.eduardo.util.Util.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StackTest {

    private Stack<Object> staticStack = new StaticStack<>(10);
    private Stack<Object> dynamicStack = new DynamicStack<>(10);

    @AfterEach
    void clear() {
        this.staticStack = new StaticStack<>(10);
        this.dynamicStack = new DynamicStack<>(10);
    }

    /*Push tests*/

    @Test
    void staticPushTest() {
        List<Object> expected = new ArrayList<>();

        expected.add("William");
        expected.add("Subaru");
        expected.add("Louis");

        staticStack.push("William");
        staticStack.push("Subaru");
        staticStack.push("Louis");

        staticStack.show();
        assertEquals(expected, staticStack.toList());

        expected.add(10);
        expected.add(11);
        expected.add(12);

        staticStack.push(10);
        staticStack.push(11);
        staticStack.push(12);

        staticStack.show();
        assertEquals(expected, staticStack.toList());

        expected.add(3.14);
        expected.add(4.0);
        expected.add('A');
        expected.add(true);

        staticStack.push(3.14);
        staticStack.push(4.0);
        staticStack.push('A');
        staticStack.push(true);

        staticStack.show();
        assertEquals(expected, staticStack.toList());

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> staticStack.push(2));
    }

    @Test
    void dynamicPushTest() {
        List<Object> expected = new ArrayList<>();

        expected.add("William");
        expected.add("Subaru");
        expected.add("Louis");

        dynamicStack.push("William");
        dynamicStack.push("Subaru");
        dynamicStack.push("Louis");

        dynamicStack.show();
        assertEquals(expected, dynamicStack.toList());

        expected.add(10);
        expected.add(11);
        expected.add(12);

        dynamicStack.push(10);
        dynamicStack.push(11);
        dynamicStack.push(12);

        dynamicStack.show();
        assertEquals(expected, dynamicStack.toList());

        expected.add(3.14);
        expected.add(4.0);
        expected.add('A');
        expected.add(true);

        dynamicStack.push(3.14);
        dynamicStack.push(4.0);
        dynamicStack.push('A');
        dynamicStack.push(true);

        dynamicStack.show();
        assertEquals(expected, dynamicStack.toList());
    }

    /*Pop tests*/

    @Test
    void staticPopTest() throws Throwable {
        List<Object> expected = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            staticStack.push(i);
            expected.add(i);
        }

        executeSmth(expected::removeLast, 3);

        assertEquals(9, staticStack.pop());
        assertEquals(8, staticStack.pop());
        assertEquals(7, staticStack.pop());

        staticStack.show();
        assertEquals(expected, staticStack.toList());

        executeSmth(expected::removeLast, 3);

        assertEquals(6, staticStack.pop());
        assertEquals(5, staticStack.pop());
        assertEquals(4, staticStack.pop());

        staticStack.show();
        assertEquals(expected, staticStack.toList());

        executeSmth(expected::removeLast, 4);

        assertEquals(3, staticStack.pop());
        assertEquals(2, staticStack.pop());
        assertEquals(1, staticStack.pop());
        assertEquals(0, staticStack.pop());

        staticStack.show();
        assertEquals(expected, staticStack.toList());

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> staticStack.pop());
        assertEquals(0, staticStack.getCurrentSize());
    }

    @Test
    void dynamicPopTest() {
        List<Object> expected = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dynamicStack.push(i);
            expected.add(i);
        }

        dynamicStack.show();

        assertEquals(expected.removeLast(), dynamicStack.pop());
        assertEquals(expected.removeLast(), dynamicStack.pop());
        assertEquals(expected.removeLast(), dynamicStack.pop());
        assertEquals(expected.removeLast(), dynamicStack.pop());
        assertEquals(expected.removeLast(), dynamicStack.pop());

        dynamicStack.show();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> dynamicStack.pop());

    }

    /*General Tests*/

    @Test
    void peekTest() throws Throwable {
        for (int i = 0; i < 10; i++) {
            staticStack.push(i);
            dynamicStack.push(i);
        }

        assertEquals(9, staticStack.peek());
        assertEquals(9, dynamicStack.peek());

        executeSmth(() -> {staticStack.pop();dynamicStack.pop();}, 2);
        staticStack.show();
        dynamicStack.show();

        assertEquals(7, staticStack.peek());
        assertEquals(7, dynamicStack.peek());

        executeSmth(() -> {staticStack.pop();dynamicStack.pop();}, 7);
        staticStack.show();
        dynamicStack.show();

        assertEquals(0, staticStack.peek());
        assertEquals(0, dynamicStack.peek());

        executeSmth(() -> {staticStack.pop();dynamicStack.pop();}, 1);
        staticStack.show();
        dynamicStack.show();

        assertNull(staticStack.peek());
        assertNull(dynamicStack.peek());
    }

    @Test
    void clearTest() throws Throwable {
        executeSmth(() -> {staticStack.push("bread"); dynamicStack.push("cheese");}, 10);

        assertNotNull(staticStack.toList());
        assertNotNull(dynamicStack.toList());

        staticStack.clear();
        dynamicStack.clear();

        assertTrue(staticStack.toList().isEmpty());
        assertTrue(dynamicStack.toList().isEmpty());
    }

    @Test
    void toListTest() throws Throwable {
        List<Object> expected = new ArrayList<>();
        executeSmth(() -> {
            staticStack.push("bread");
            dynamicStack.push("bread");
            expected.add("bread");
        }, 10);

        assertNotNull(staticStack);
        assertNotNull(dynamicStack);

        assertEquals(expected, staticStack.toList());
        assertEquals(expected, dynamicStack.toList());
    }

    /*Dynamic Stack specific tests*/

    @Test
    void growTest() throws Throwable {
        assertEquals(10, dynamicStack.getStackCapacity());

        executeSmth(() -> dynamicStack.push("bread"), 11);
        dynamicStack.show();
        System.out.println(dynamicStack.getStackCapacity());

        assertEquals(20, dynamicStack.getStackCapacity());

        executeSmth(() -> dynamicStack.push("bread"), 10);
        dynamicStack.show();
        System.out.println(dynamicStack.getStackCapacity());

        assertEquals(40, dynamicStack.getStackCapacity());

    }

    @Test
    void shrinkTest() throws Throwable {

        executeSmth(() -> dynamicStack.push("bread"), 40);

        assertEquals(40, dynamicStack.getStackCapacity());
        System.out.println(dynamicStack.getStackCapacity());

        executeSmth(() -> dynamicStack.pop(), 30);

        assertEquals(20, dynamicStack.getStackCapacity());
        System.out.println(dynamicStack.getStackCapacity());

        executeSmth(() -> dynamicStack.pop(), 5);

        assertEquals(10, dynamicStack.getStackCapacity());
        System.out.println(dynamicStack.getStackCapacity());

        executeSmth(() -> dynamicStack.pop(), 3);

        assertEquals(5, dynamicStack.getStackCapacity());
        System.out.println(dynamicStack.getStackCapacity());

    }

}
