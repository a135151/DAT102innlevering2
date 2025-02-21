package sortering;

import java.util.Random;
import java.util.Arrays;

public class Innsetting {

	public static <T extends Comparable<? super T>> void innsettingSortmod(T[] a) {

			int n = a.length;

		    int minIndex = 0;
		    for (int i = 1; i < n; i++) {
		        if (a[i].compareTo(a[minIndex]) < 0) {
		            minIndex = i;
		        }
		    }
		    bytt(a, minIndex, 0);

		    for (int i = 1; i < n; i += 2) {
		        if (i + 1 < n) {
		            T minste = a[i];
		            T storste = a[i + 1];

		            if (minste.compareTo(storste) > 0) {
		                T temp = minste;
		                minste = storste;
		                storste = temp;
		            }

		            int j = i - 1;
		            
		            while (a[j].compareTo(storste) > 0) {
		                a[j + 2] = a[j];
		                j--;
		            }
		            a[j + 2] = storste;

		            j = i - 1;
		            
		            while (a[j].compareTo(minste) > 0) {
		                a[j + 1] = a[j];
		                j--;
		            }
		            a[j + 1] = minste;
		        } else {
		            int j = i - 1;
		            T sisteElement = a[i];
		            while (a[j].compareTo(sisteElement) > 0) {
		                a[j + 1] = a[j];
		                j--;
		            }
		            a[j + 1] = sisteElement;
		        }
		    }
		}

		private static <T> void bytt(T[] array, int i, int j) {
		    T temp = array[i];
		    array[i] = array[j];
		    array[j] = temp;
		}

    public static void main(String[] args) {
        Random tilfeldig = new Random();
        int n = 100000;
        int antall = 5;

        Integer[][] a = new Integer[antall][n];

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
