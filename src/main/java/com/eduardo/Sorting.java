package com.eduardo;

public class Sorting {

    public static void bubbleSort(int[] nums) {
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    
    public static void selectionSort(int[] nums) {
        final int size = nums.length;
        int index = 0;
        int temp = 0;

        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-i; j++) {
                if (nums[j] > nums[index])
                    index = j;
            }

            temp = nums[size-1-i];
            nums[size-1-i] = nums[index];
            nums[index] = temp;
            index = 0;
        }
    }

    public static void insertionSort(int[] nums) {
        final int size = nums.length;

        for (int i = 1; i < size; i++) {
            int value = nums[i];

            int j = i-1;
            while (j>=0 && nums[j] > value) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = value;
        }
    }

    public static void quickSort(int[] nums, int low, int high) {

        if (low < high) {
            int pi = partition(nums, low, high);

            quickSort(nums, low, pi -1);
            quickSort(nums, pi +1, high);
        }

    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low -1;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[high] = nums[i+1];
        nums[i+1] = pivot;

        return i+1;
    }


    public static void mergeSort(int[] nums, int left, int right) {
        int mid = (left + right) /2;

        if (left < right){
            mergeSort(nums, left, mid);
            mergeSort(nums, mid +1, right);
            merge(nums, left, mid, right);
        }

    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] leftArr = new int[mid - left +1];
        int[] rightArr = new int[right - mid];

        for (int i = 0; i < leftArr.length; i++)
            leftArr[i] = nums[left+i];

        for (int i = 0; i < rightArr.length; i++)
            rightArr[i] = nums[mid+1+i];

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftArr.length && j < rightArr.length) {

            if (leftArr[i] <= rightArr[j]) {
                nums[k] = leftArr[i];
                i++;
            } else {
                nums[k] = rightArr[j];
                j++;
            }

            k++;
        }

        while (i<leftArr.length) {
            nums[k] = leftArr[i];
            i++;
            k++;
        }

        while (j<rightArr.length) {
            nums[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
