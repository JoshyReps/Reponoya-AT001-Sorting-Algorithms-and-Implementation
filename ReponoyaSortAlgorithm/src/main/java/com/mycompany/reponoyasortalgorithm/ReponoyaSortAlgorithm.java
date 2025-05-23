package com.mycompany.reponoyasortalgorithm;

// --------------------- Reponoya Sorting ALogrith - First File ---------------

import java.util.Arrays;


public class ReponoyaSortAlgorithm {

    
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
        
        
        long startBubble = System.nanoTime();
        System.out.println("\n------------------------- Bubble Sort -------------------------");
        //Print Bubble Sorted Array :
        printArray(bubbleSort(names));
        long durationBubble = (System.nanoTime() - startBubble) / 1000000;
        System.out.printf("============= DURATION (%s) : %d ms ==============%n".formatted("Bubble Sort", durationBubble));
        
        
        long startSelection = System.nanoTime();
        System.out.println("\n------------------------- Selection Sort -------------------------");
        //Print Selection Sorted Array :
        printArray(selectionSort(names));
        long durationSelection = (System.nanoTime() - startSelection) / 1000000;
        System.out.printf("============= DURATION (%s) : %d ms ==============%n".formatted("Selection Sort", durationSelection));

        
        long startInsertion = System.nanoTime();
        System.out.println("\n------------------------- Insertion Sort -------------------------");
        //Print Insertion Sorted Array :
        printArray(insertionSort(names));
        long durationInsertion = (System.nanoTime() - startInsertion) / 1000000;
        System.out.printf("============= DURATION (%s) : %d ms ==============%n".formatted("Insertion Sort", durationInsertion));
        
        
    }
    
    // -------------------- Bubble Sort Method -------------------------
    public static String[] bubbleSort(String[] array) {
        
        String[] copy = Arrays.copyOf(array, array.length);
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                
                String temp = copy[j];
                
                if(copy[i].compareTo(copy[j]) < 0) {
                    copy[j] = copy[i];
                    copy[i] = temp;
                }
            }
        }

        return copy;
    }
    // ----------------------------------------------------------------
    
    // -------------------- Selection Sort Method -------------------------
    public static String[] selectionSort(String[] array) {
        
        String[] copy = Arrays.copyOf(array, array.length);
        
        for (int i = 0; i < array.length; i++) {
            
            int minIndex = i;
            
            for (int j = (0 + i); j < array.length; j++) {
                if(copy[j].compareTo(copy[minIndex]) <= 0) minIndex = j;
            }
            
            String temp = copy[i];
            
            if(copy[i].compareTo(copy[minIndex]) >= 0) {
                copy[i] = copy[minIndex];
                copy[minIndex] = temp;
            }
        }
        
        return copy;
    }
    // --------------------------------------------------------------------
    
    // -------------------- Insertion Sort Method -------------------------
    public static String[] insertionSort(String[] array) {
        
        String[] copy = Arrays.copyOf(array, array.length);
        
        for (int i = 1; i < copy.length; i++) {
            
            int count = 1;
            int currentCount = 0;
            
            while(copy[i - currentCount].compareTo(copy[i - count]) < 0) {
                String temp = copy[i - count];
                copy[i - count] = copy[i - currentCount];
                copy[i - currentCount] = temp;
                currentCount++;
                if(i - ++count < 0) break;
            }
        }
        
        return copy;
    }
    // --------------------------------------------------------------------
    
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
