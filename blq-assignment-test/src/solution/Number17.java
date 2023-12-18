package solution;

public class Number17 {

    public static void main(String[] args) {
        String[] rute = "N N T N N N T T T T T N T T T N T N".split(" ");
        int mdpl = 0, mount = 0, valley = 0;
        int[] aMdpl = new int[rute.length];
        //grafik gunung lembah
        for (int i = 0; i < rute.length; i++) {
            if (rute[i].equalsIgnoreCase("T")) {
                mdpl--;
                //System.out.print(mdpl+" ");
            } else if (rute[i].equalsIgnoreCase("N")) {
                mdpl++;
                //System.out.print(mdpl+" ");
            }
            aMdpl[i] = mdpl;
        }
        //menghitung gunung dan lembah
        for (int i = 0; i < aMdpl.length; i++) {
            if (aMdpl[i] == 0 && aMdpl[i - 1] >= 1) {
                mount++;
            } else if (aMdpl[i] == 0 && aMdpl[i - 1] <= -1) {
                valley++;
            }
        }
        System.out.println("\nHattori telah melewati " + mount + " gunung dan " + valley + " lembah");
    }
}
