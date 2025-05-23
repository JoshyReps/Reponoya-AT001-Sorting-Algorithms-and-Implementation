package com.mycompany.reponoyasortalgorithm;

import java.util.Arrays;

public class ReponoyaSortAlgorith2 {
    
    public static void main(String[] args) {
        
        // ---------------------------- List Of Names (Naka Shuffled :)) ------------------------------------
        String[] names = {
                           "Katherine", "Benjamin", "Briana", "Leah", "Liam", "Lucas", "Madison", "Matthew", "Mia", "Nathan",
                           "Gabriel", "Abigail", "Alice", "Kevin", "Caleb", "Charlotte", "Emma", "Daniel", "Diana", "Elijah", 
                           "Grace", "Hannah", "Isaac", "Isabella", "Jacob", "Jasmine", "Joshua", "Aaron", "Noah", "Olivia", "Owen", 
                           "Patrick", "Penelope", "Quentin", "Rachel", "Samuel", "Sarah", "Sophia", "Steven", "Thomas","Tristan",
                           "Uriel","Vanessa","Victor", "William", "Xander", "Yastime", "Zachary","Zoe", "Mewtwo"
                         };
        // ———————————————————————————————————————————————————————————————————
        
        System.out.println("------------------------- Original Array -------------------------");
        //Print Unsorted Array :
        printArray(names);
        
        
        long startMerge = System.nanoTime();
        System.out.println("\n------------------------- Merge Sort -------------------------");
        //Print Bubble Sorted Array :
        printArray(mergeSort(Arrays.copyOf(names, names.length)));
        long durationMerge = (System.nanoTime() - startMerge) / 1000000;
        System.out.printf("============= DURATION (%s) : %d ms ==============%n".formatted("Merge Sort", durationMerge));
        
        
        long startQuickSort = System.nanoTime();
        System.out.println("\n------------------------- Quick Sort -------------------------");
        //Print Selection Sorted Array :
        String[] copyArray = Arrays.copyOf(names,names.length);
        quickSort(copyArray);
        printArray(copyArray);
        long duractionQuickSort = (System.nanoTime() - startQuickSort) / 1000000;
        System.out.printf("============= DURATION (%s) : %d ms ==============%n".formatted("Quick Sort", duractionQuickSort));

    }
    
    
    // -------------------- MERGE SORT METHODS -------------------------
    // -----------------------------------------------------------------
    
    // ----------------------- Recursive Method -----------------------
     public static String[] merge(String[] array1, String[] array2) {
        String[] combined = new String[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i].compareTo(array2[j]) < 0) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                combined[index] = array2[j];
                index++;
                j++;
            }
        }
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }
        return combined;
    }

    // ---------- Method that Activates the Recursive Method ----------
    public static String[] mergeSort(String[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length/2;
        String[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        String[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }
    // ----------------------------------------------------------------
    
    
    // -------------------- QUICK SORT METHODS -------------------------
    
    // -------- This is Method that Swaps the Values to Sort -----------
    private static void swap(String[] array, int firstIndex, int secondIndex) {
        String temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    // -- This is the Method that Basically Determines the Pivot Elements -----
    private static int pivot(String[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i].compareTo(array[pivotIndex]) < 0) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }

    // -------------- This is the Recursive Method ------------------------
    private static void quickSortHelper(String[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex-1);
            quickSortHelper(array, pivotIndex+1, right);
        }
    }

    // -------- This is the Method that Starts the Recursive Method -------
    public static void quickSort(String[] array) {
        quickSortHelper(array, 0, array.length-1);
    }
    // ---------------------------------------------------------------------
    
    
    // -------------------- Method For Printing Arrays --------------------
    public static void printArray(String[] array) {
        
        int count = 0;
        
        for(Object ar : array) {
            System.out.printf("%s[%d]%s %s".formatted(
                                                 ar,
                                                 count++,
                                                 ((count == array.length) ? "" : ","), 
                                                 ((count % 5 == 0) ? "\n" : "")));
        }
    }
    // ---------------------------------------------------------------------
}
