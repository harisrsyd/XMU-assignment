package solution;

import java.util.Scanner;

public class Number05 {

    public static void main(String[] args) {
        int length, n1 = 1, n2 = 1, n3;
        Scanner input = new Scanner(System.in);

        System.out.print("Panjang deret n: ");
        length = input.nextInt();
        int[] fibonacci = new int[length];

        System.out.println(length + " Bilangan fibonacci pertama adalah: ");
        for (int i = 0; i < length; i++) {
            fibonacci[i]= n1;
            System.out.print(fibonacci[i]+" ");
            n3= n1+n2;
            n1= n2;
            n2= n3;
        }
    }
}
