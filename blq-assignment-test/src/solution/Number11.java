package solution;

import java.util.Scanner;

public class Number11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan input kata : ");
        String word = input.nextLine();

        String[] aWord = word.split("");
        for (int i = (aWord.length - 1); i >= 0; i--) {
            System.out.println("***" + aWord[i] + "***");
        }
    }
}
