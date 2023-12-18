package solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Number03 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan waktu masuk (ex: 28/01/2020 07:30:34): ");
        String timeIn = input.nextLine();
        System.out.println("Masukan waktu keluar (ex: 29/01/2020 20:03:35): ");
        String timeOut = input.nextLine();

        long selisih = 0, jam = 0, menit = 0, detik = 0;
        int biayaParkir = 0, denda = 0;
        //buat format
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            Date dateIn = format.parse(timeIn);
            Date dateOut = format.parse(timeOut);
            selisih = dateOut.getTime() - dateIn.getTime();
            jam = TimeUnit.MILLISECONDS.toHours(selisih);
            menit = TimeUnit.MILLISECONDS.toMinutes(selisih) -
                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(selisih));
            detik = TimeUnit.MILLISECONDS.toSeconds(selisih) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(selisih));
            System.out.print("Selisih : " + jam);
            System.out.print(":" + menit);
            System.out.println(":" + detik);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if (jam < 8 || (jam == 8 && menit == 0 && detik < 1)) {
            biayaParkir = (int) jam * 1000;
        } else if (jam < 24 || (jam == 24 && menit == 0 && detik < 1)) {
            biayaParkir = 8000;
        } else if (jam >= 24 && menit >= 0 && detik >= 1) {
            biayaParkir = (int) jam / 24 * 15000;
            int mod = (int) jam % 24;
            if (mod <= 8) {
                denda = mod * 1000;
            } else {
                denda = 8000;
            }
            biayaParkir = biayaParkir + denda;
        }
        System.out.println("Tarif Parkir: " + biayaParkir);
    }
}
