package solution;

import java.util.Scanner;

public class Number12 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Input (Angka dengan jarak spasi): ");
        String[] arr = input.nextLine().trim().split(" ");

        int[] aNumber = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            aNumber[i] = Integer.parseInt(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (aNumber[i] > aNumber[j]) {
                    int temp = aNumber[i];
                    aNumber[i] = aNumber[j];
                    aNumber[j] = temp;
                }
            }
        }

        System.out.print("Output: ");
        for (int i : aNumber) {
            System.out.print(i + " ");
        }
    }
}
