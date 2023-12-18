package solution;

import java.util.Scanner;

public class Number15 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String time = "";

        System.out.print("Input waktu (AM/PM) : ");
        time = input.nextLine();

        int HH = Integer.parseInt(time.substring(0, 2));
        String AMPM = time.substring(9, 11);
        if (HH >= 1 && HH <= 12 && AMPM.equalsIgnoreCase("PM")) {
            if (HH < 12) {
                int hh = HH + 12;
                System.out.print("24Hour : ");
                System.out.print(hh);
            } else {
                System.out.print("24Hour : ");
                System.out.print("12");
            }
            System.out.print(time.substring(2, 5));
            System.out.print(time.substring(5, 8));
        } else if (HH >= 1 && HH <= 12 && AMPM.equalsIgnoreCase("AM")) {
            if (HH < 12) {
                System.out.print("24 Hour : ");
                if (HH < 10) {
                    System.out.print("0" + HH);
                } else {
                    System.out.print(HH);
                }
            } else {
                System.out.print("24Hour : ");
                System.out.print("00");
            }
            System.out.print(time.substring(2, 5));
            System.out.print(time.substring(5, 8));
        }
    }
}
