package com.eduardo.dataStructuresTesting;

import com.eduardo.dataStructures.LinkedList;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LinkedListTest {

    LinkedList<Object> list = new LinkedList<>();

    @AfterEach
    void clear() {
        this.list.clear();
    }

    @Test
    void addTest() {
        List<Object> hereList = Arrays.asList("Wanda", "Vladimir", 100, 3.14, 'A', new HashSet<>(), new ArrayList<>(), 20,
                800, 971, "Eye");

        this.list.add(hereList.get(0));
        this.list.add(hereList.get(1));
        this.list.add(hereList.get(2));

        this.list.show();

        this.list.addFirst(hereList.get(7));
        this.list.addFirst(hereList.get(0));

        this.list.show();

        this.list.add(100 ,hereList.get(5));
        this.list.add(6, hereList.get(10));
        this.list.add(5, hereList.get(8));

        this.list.show();

        this.list.add(0, hereList.get(4));
        this.list.add(-100, hereList.get(3));

        this.list.show();

        this.list.add(1, hereList.get(6));
        this.list.add(2, hereList.get(9));

        this.list.show();
    }

    @Test
    void getTest() {
        System.out.println(this.list.get(0));

        for (int i = 0; i < 10; i++)
            this.list.add(i);

        this.list.show();

        assertEquals(0, this.list.get(0));
        assertEquals(0, this.list.get(-100));
        assertEquals(9, this.list.get(9));
        assertEquals(9, this.list.get(100));
        assertEquals(3, this.list.get(3));
        assertEquals(2, this.list.get(2));
        assertEquals(5, this.list.get(5));
        assertEquals(7, this.list.get(7));
        assertEquals(8, this.list.get(8));
    }

    @Test
    void removeTest() {
        System.out.println(this.list);
        this.list.remove();

        for (int i = 0; i < 16; i++)
            this.list.add(i);

        this.list.show();

        this.list.remove(15);
        this.list.remove(100);
        this.list.remove(0);
        this.list.remove(-100);

        this.list.show();

        this.list.removeFirst();
        this.list.removeFirst();

        this.list.show();

        this.list.remove();
        this.list.remove();

        this.list.show();
    }

}
