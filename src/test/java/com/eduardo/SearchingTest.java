package com.eduardo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchingTest {

    int[] arr;
    Random generator = new Random();

    //Not putting more elements in the array because my pc cannot stand it
    public SearchingTest() {
        arr = new int[1000];
    }


    @BeforeAll
    void setup() {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = generator.nextInt(1001);
        }

        //Most of the time spent in execution time is spent here, sorting
        long l = System.currentTimeMillis();
        Arrays.sort(this.arr);
        long executionTime = System.currentTimeMillis() - l;

        //System.out.println("Sorting time: " + executionTime);

        showArr(this.arr);
        System.out.println("\n\n");
    }

    private static void showArr(int[] arr) {
        System.out.print("[ ");

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    @Test
    void linearSearchTest() {
        final int EXPECTED = 492;

        int value = arr[EXPECTED];
        final int ACTUAL = Searching.linearSearch(this.arr, value);

        assertEquals(EXPECTED, ACTUAL);
    }

    //The amount of time would be more noticeable if the array were bigger
    //With 1000 elements, the amount of time needed to find a target is roughly 1 millisencond
    @Test
    void linearSearchDurationTest() {
        long startingTime = System.currentTimeMillis();

        final int RESULT = Searching.linearSearch(this.arr, -1); //Not present in the array, so it'll run through it all

        long executionTime = System.currentTimeMillis() - startingTime;
        System.out.println("Execution time: " + executionTime);
        assertEquals(-1, RESULT);

    }

    @Test
    void binarySearchTest() {
        final int EXPECTED = 832;

        int value = this.arr[EXPECTED];
        final int ACTUAL = Searching.binarySort(this.arr, value);

        assertEquals(EXPECTED, ACTUAL);
    }

    //As the other duration test, due to the small size of this.arr the time needed to finish this execution
    //is really small
    //And since this is a more efficient searching method the amount of elements needed to make the execution
    //time greater would be even greater, so this is expected to run in 1 millisecond as well
    @Test
    void binarySearchDurationTest() {
        long startingTime = System.currentTimeMillis();

        final int RESULT = Searching.binarySort(this.arr, -1); //Not present in the array, so it'll run through it all

        long executionTime = System.currentTimeMillis() - startingTime;
        System.out.println("Execution time: " + executionTime);
        assertEquals(-1, RESULT);
    }

    @Test
    void binarySearchRecursiveTest() {
        final int EXPECTED = 790;

        int value = this.arr[EXPECTED];
        final int ACTUAL = Searching.binarySortRecursive(this.arr, value, 0, this.arr.length -1);

        assertEquals(EXPECTED, ACTUAL);
    }

    //Copy and paste of the other duration comments
    @Test
    void binarySearchRecursiveDurationTest() {
        long startingTime = System.currentTimeMillis();

        final int RESULT = Searching.binarySortRecursive(this.arr, -1, 0, this.arr.length-1); //Not present in the array, so it'll run through it all

        long executionTime = System.currentTimeMillis() - startingTime;
        System.out.println("Execution time: " + executionTime);
        assertEquals(-1, RESULT);
    }
}
