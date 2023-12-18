package solution;

import java.util.Scanner;

public class Number09 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;

        System.out.print("Nilai N = ");
        n = input.nextInt();

         int multiple =0;
        for (int i = 0; i < n ; i++) {
            multiple += n;
            System.out.print(multiple + " ");
        }
    }
}
