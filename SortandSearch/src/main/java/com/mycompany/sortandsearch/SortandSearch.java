package com.mycompany.sortandsearch;

import java.util.Arrays;

/**
 * Lab Project
 * @author cmauer2
 */
public class SortandSearch {

    public static void main(String[] args) {
        String input = "a,c,f,g,h,s,r,d,t,v,m,n,b,j,k,l,p,o,z,q,w,e";
        String[] strings = input.split(",");
        
        exchangeSort(strings);

        System.out.println(Arrays.toString(strings));

        String searchWord = "g";

        binarySearch(strings, searchWord);
        linearSearch(strings, searchWord);
    }

    public static void exchangeSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;
        int steps = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = arr[mid].compareTo(target);
            steps++;

            if (cmp == 0) {
                System.out.printf("Binary search - Target: %s, found at index %d with %d steps\n", target, mid, steps);
                return;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.printf("Binary search - Target: %s, not found with %d steps\n", target, steps);
    }

    public static void linearSearch(String[] arr, String target) {
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i].equals(target)) {
                System.out.printf("Linear search - Target: %s, found at index %d with %d steps\n", target, i, steps);
                return;
            }
        }
        System.out.printf("Linear search - Target: %s, not found with %d steps\n", target, steps);
    }
}