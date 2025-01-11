package com.eduardo.dataStructuresTesting;

import static org.junit.jupiter.api.Assertions.*;

import com.eduardo.dataStructures.BinaryTree;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TreeTest {
    BinaryTree<Integer> tree = new BinaryTree<>();
    Random random = new Random();

    @Test
    void insertionTest() {
        Executable exe = () -> {
            for (int i = 0; i < 10; i++) {
                int value = random.nextInt(50);
                tree.insert(value);
                System.out.println(value);
            }
        };

        assertDoesNotThrow(exe);

        tree.inOrder();
        tree.preOrder();
    }

    @Test
    void typesTest() throws Throwable {
        BinaryTree<String> tree1 = new BinaryTree<>();

        Executable exe = () -> {
            String[] names = {"Anne", "Emilia", "Beatrice", "Anastasia", "Garfield", "Ricardo"};
            for (String name : names)
                tree1.insert(name);
        };

        assertDoesNotThrow(exe);
        tree1.inOrder();
        tree1.preOrder();

        BinaryTree<Double> tree2 = new BinaryTree<>();

        exe = () -> {
            double[] constants = {3.1415, 1.4142, 1.7320, 2.2360, 1.6180, 0.1149};
            for (double constant : constants)
                tree2.insert(constant);
        };

        assertDoesNotThrow(exe);
        tree2.inOrder();
        tree2.preOrder();

    }

}
