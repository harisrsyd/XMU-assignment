package solution;

public class Number13 {

    public static void main(String[] args) {
        String time1 = "3:00";
        System.out.println("Sudut terkecil yang dibentuk jam "+ time1 +" adalah: " + smallestAngle(time1) + " derajat");
        String time2 = "5:30";
        System.out.println("Sudut terkecil yang dibentuk jam "+ time2 +" adalah: " + smallestAngle(time2) + " derajat");
        String time3 = "2:20";
        System.out.println("Sudut terkecil yang dibentuk jam "+ time3 +" adalah: " + smallestAngle(time3) + " derajat");
    }

    public static int smallestAngle(String time) {
        int hours = Integer.parseInt(time.substring(0, 1));
        int minutes = Integer.parseInt(time.substring(2, 4));

        int angle = (int) (((double) 11 /2*minutes)-(30*hours));
        return Math.abs(angle);
    }
}
