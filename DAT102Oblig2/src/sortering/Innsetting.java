package sortering;

import java.util.Random;
import java.util.Arrays;

public class Innsetting {
    
    public static void innsettingSortmod(int[] a) {
        int n = a.length;
        
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        byttElement(a, 0, minIndex);
        
        for (int i = 2; i < n - 1; i += 2) {
            settinnToElement(a, i, i + 1);
        }
        
        if (n % 2 == 0) {
            settinnElement(a, n - 1);
        }
    }
    
    private static void settinnToElement(int[] a, int i, int j) {
        settinnElement(a, i);
        settinnElement(a, j);
    }
    
    private static void settinnElement(int[] a, int i) {
        int temp = a[i];
        int j = i - 1;
        while (a[j] > temp) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = temp;
    }
    
    public static void byttElement(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void main(String[] args) {
        Random tilfeldig = new Random();
        int n = 50000;
        int antall = 10;
        
        int[][] a = new int[antall][n];
        
        for (int i = 0; i < antall; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = tilfeldig.nextInt();
            }
        }
        
        long totalTid = 0;
        for (int i = 0; i < antall; i++) {
            long start = System.currentTimeMillis();
            innsettingSortmod(a[i]);
            long slutt = System.currentTimeMillis();
            totalTid += (slutt - start);
        }
        
        System.out.println("Total tid: " + totalTid + " ms");
        System.out.println("Gjennomsnittlig tid: " + (totalTid / antall) + " ms");
    }
}
