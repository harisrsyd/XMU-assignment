package solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Number02 {

    public static void main(String[] args) {

        String dateStart1 = "28/02/2016";
        String dateEnd1 = "07/03/2016";

        String dateStart2 = "29/04/2018";
        String dateEnd2 = "30/05/2018";

        System.out.println("a. Denda: " + calculateFines(dateStart1, dateEnd1));
        System.out.println("b. Denda: " + calculateFines(dateStart2, dateEnd2));

    }

    public static int calculateFines(String a, String b) {
        int[] loanDuration = {14, 3, 7, 7};

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        long difference = 0, days = 0;

        try {
            Date dateFrom = format.parse(a);
            Date dateUntil = format.parse(b);

            difference = dateUntil.getTime() - dateFrom.getTime();
            days = TimeUnit.MILLISECONDS.toDays(difference);

            System.out.println("durasi: " + days + " hari");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        int fines = 0;
        for (int j : loanDuration) {
            if (days > j) {
                fines += ((int) days - j) * 100;
            } else {
                fines = 0;
            }
        }
        return fines;

    }
}
