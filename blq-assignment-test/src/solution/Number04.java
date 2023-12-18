package solution;

import java.util.Scanner;

public class Number04 {

    public static void main(String[] args) {
        int length, stat, num = 1, i = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Panjang deret prima n: ");
        length = input.nextInt();

        int[] prime = new int[length];
        System.out.println(length + " Bilangan prima pertama adalah:");
        while (i < length) {
            int j = 1;
            stat = 0;
            while (j <= num) {
                if (num % j == 0) {
                    stat++;
                }
                j++;
            }
            if (stat == 2) {
                prime[i] = num;
                System.out.print(prime[i] + " ");
                i++;
            }
            num++;
        }
    }
}
