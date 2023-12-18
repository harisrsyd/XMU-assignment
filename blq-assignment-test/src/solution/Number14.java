package solution;

import java.util.Scanner;

public class Number14 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arr = {3, 9, 0, 7, 1, 2, 4};
        System.out.print("Masukkan nilai N: ");
        int n = input.nextInt();

        loopingArray(arr,n);
    }

    public static void loopingArray(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int temp = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = temp;
        }

        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
