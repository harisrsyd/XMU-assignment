package solution;

import java.util.Scanner;

public class Number06 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Cek apakah merupakan Palindrome: ");
        String word = input.nextLine();

        if (palindrome(word)) {
            System.out.println(word + " merupakan Palindrome");
        } else {
            System.out.println(word + " bukanlah Palindrome");
        }
    }

    public static boolean palindrome(String word) {
        StringBuilder reverseWord = new StringBuilder();
        for (int i = (word.length() - 1); i >= 0; i--) {
            reverseWord.append(word.charAt(i));
        }
        return word.equalsIgnoreCase(reverseWord.toString());
    }
}
