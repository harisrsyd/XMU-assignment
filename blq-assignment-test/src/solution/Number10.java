package solution;

import java.util.Scanner;

public class Number10 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fullName = "";
        String first = "";
        String last = "";

        System.out.print("Masukan nama lengkap : ");
        fullName = input.nextLine();

        String[] aName = fullName.split(" ");
        for (String s : aName) {
            first = Character.toString(s.charAt(0));
            last = Character.toString(s.charAt(s.length() - 1));
            System.out.print(first.toUpperCase() + "***" + last + " ");
        }
    }
}
