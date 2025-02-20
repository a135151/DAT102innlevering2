package sortering;

import java.util.Random;
import java.util.Arrays;

public class InnsettingUmodifisert {
    
    public static void innsettingSort(int[] a) {
        int n = a.length;
        
        for (int i = 1; i < n; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
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
            innsettingSort(a[i]);
            long slutt = System.currentTimeMillis();
            totalTid += (slutt - start);
        }
        
        System.out.println("Total tid: " + totalTid + " ms");
        System.out.println("Gjennomsnittlig tid: " + (totalTid / antall) + " ms");
    }
}
