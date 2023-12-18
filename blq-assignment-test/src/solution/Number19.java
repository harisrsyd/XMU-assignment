package solution;

import java.util.Scanner;

public class Number19 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("------- CEK PANGRAM -------");
        System.out.println("Tulis Kalimat di Bawah ini: ");
        String sentence = input.nextLine().toLowerCase();
        String[] alphabet ="abcdefghijklmnopqrstuvwxyz".split("");
        String result="Kalimat tersebut merupakan Pangram";

        for (String s : alphabet) {
            if (!sentence.contains(s)) {
                result = "Kalimat tersebut bukan Pangram";
                break;
            }
        }
        System.out.println(result);
    }
}
