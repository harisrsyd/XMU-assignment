package solution;

import java.util.Arrays;

public class Number07 {
    public static void main(String[] args) {
        int[] arr = {8, 7, 0, 2, 7, 1, 7, 6, 3, 0, 7, 1, 3, 4, 6, 1, 6, 4, 3};

        System.out.println("Nilai rata-rata dari dari deret array: " + mean(arr));
        System.out.println("Nilai median dari dari deret array: " + median(arr));
        System.out.println("Nilai modus dari dari deret array: " + modus(arr));

    }

    public static double mean(int[] array) {
        int total = 0;
        for (int i : array) {
            total += i;
        }
        return (double) total / array.length;
    }

    public static int median(int[] array) {
        Arrays.sort(array);
        int result = 0;
        if (array.length % 2 == 0) {
            float gMedian = (float) ((array[array.length / 2 - 1]) + (array[array.length / 2])) / 2;
            result = (int) gMedian;
        } else {//hitungan median jika panjang array ganjil
            int med = array[(array.length + 1) / 2 - 1];
            result = med;
        }
        return result;
    }

    public static int modus(int[] array) {
        Arrays.sort(array);
        int[] arrItem = new int[array[array.length - 1]+1];
        int frequency = 0, index = 0;

        for (int k : array) {
            arrItem[k]++;
        }

        for (int i = 0; i < arrItem.length; i++) {
            if (arrItem[i] > frequency) {
                frequency = arrItem[i];
                index = i;
            }
        }
        return index;
    }
}
