package solution;

public class Number22 {

    public static void main(String[] args) {

        int[] arrCandle = {3, 3, 9, 6, 7, 8, 23};

        int n1 = 1, n2 = 1, n3;
        int[] fibonacci = new int[arrCandle.length];
        for (int i = 0; i < arrCandle.length; i++) {
            fibonacci[i] = n1;
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

        double meltingTime = 0, fastest = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < arrCandle.length; i++) {
            meltingTime = (double) arrCandle[i] /fibonacci[i];
            if (meltingTime < fastest) {
                fastest = meltingTime;
                index = i;
            }
        }

        System.out.println("Lilin yang paling pertama habis adalah lilin dengan panjang awal "+ arrCandle[index] +" karena meleleh dalam waktu "+ fastest + " detik");
    }
}
