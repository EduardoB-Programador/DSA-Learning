package com.eduardo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SortingTest {

    int[] arr;
    Random generator = new Random();

    //Standard array size is 10000, else it's time sorting becomes too fast making it hard to determine
    //which sorting algorithm is best
    public SortingTest() {
        arr = new int[10000];
    }

    //If BeforeAll, the array that is being sorted will stay sorted when other methods be applied
    @BeforeEach
    void setup() {
        for (int i = 0; i < arr.length; i++)
            this.arr[i] = generator.nextInt(10001);

    }

    private static void showArr(int[] arr) {
        System.out.print("[ ");

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    @Test
    void bubbleSortTest() {
        int[] expectedArr = this.arr.clone();

        Arrays.sort(expectedArr);
        Sorting.bubbleSort(this.arr);

        showArr(this.arr);
        assertArrayEquals(expectedArr, this.arr);
    }

    @Test
    void bubbleSortDurationTest() {
        long startingTime = System.currentTimeMillis();
        Sorting.bubbleSort(this.arr);
        long executionTime = System.currentTimeMillis() - startingTime;

        System.out.println("\n---Bubble Sort---\nTime Sorting: " + executionTime);
    }

    @Test
    void selectionSortTest() {
        int[] expectedArr = this.arr.clone();

        Arrays.sort(expectedArr);
        Sorting.selectionSort(this.arr);

        showArr(this.arr);
        assertArrayEquals(expectedArr, this.arr);
    }

    @Test
    void selectionSortDurationTest() {
        long startingTime = System.currentTimeMillis();
        Sorting.selectionSort(this.arr);
        long executionTime = System.currentTimeMillis() - startingTime;

        System.out.println("\n---Selection Sort---\nTime Sorting: " + executionTime);
    }

    @Test
    void insertionSortTest() {
        int[] expectedArr = this.arr.clone();

        Arrays.sort(expectedArr);
        Sorting.insertionSort(this.arr);

        showArr(this.arr);
        assertArrayEquals(expectedArr, this.arr);
    }

    @Test
    void insertionSortDurationTest() {
        long startingTime = System.currentTimeMillis();
        Sorting.insertionSort(this.arr);
        long executionTime = System.currentTimeMillis() - startingTime;

        System.out.println("\n---Insertion Sort---\nTime Sorting: " + executionTime);
    }

    @Test
    void quickSortTest() {
        int[] expectedArr = this.arr.clone();

        Arrays.sort(expectedArr);
        Sorting.quickSort(this.arr, 0, arr.length -1);

        showArr(this.arr);
        assertArrayEquals(expectedArr, this.arr);
    }

    @Test
    void quickSortDurationTest() {
        long startingTime = System.currentTimeMillis();
        Sorting.quickSort(this.arr, 0, arr.length -1);
        long executionTime = System.currentTimeMillis() - startingTime;

        System.out.println("\n---Quick Sort---\nTime Sorting: " + executionTime);
    }

    @Test
    void mergeSortTest() {
        int[] expectedArr = this.arr.clone();

        Arrays.sort(expectedArr);
        Sorting.mergeSort(this.arr, 0, this.arr.length -1);

        showArr(this.arr);
        assertArrayEquals(expectedArr, this.arr);
    }

    @Test
    void mergeSortDurationTest() {
        long startingTime = System.currentTimeMillis();
        Sorting.mergeSort(this.arr, 0, this.arr.length -1);
        long executionTime = System.currentTimeMillis() - startingTime;

        System.out.println("\n---Merge Sort---\nTime Sorting: " + executionTime);
    }

}
