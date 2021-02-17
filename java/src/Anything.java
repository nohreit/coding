

public class Anything {

    public static String[] powers = {"side_attack"};
    private final int size;
    public String name = "";

    public Anything(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        char[] flags = {'c', 'f', 'l', 'b', 'a'};
//        swap(arr, 3, 7);
//        backward(flags);
//        String[][] classroom = new String[][]{{"a", "b", "c", "d"}, {"e", "f", "g", "h"}, {"i", "j", "k", "l"}};

//        for (char[] row: classroom) {
//            for (char col: row) {
//                p(col+ " ");
//            }
//            pln("");
//        }

//        for (int i = 0; i < classroom[2].length; i++) {
//            p(classroom[2][i]);
//        }
//        // or
//        for (String col: classroom[2]) {
//            p(col);
//        }

//        Anything a1 = new Anything("a1", 10);
//        Anything.addPower("climb_walls");
//        Anything a2 = new Anything("a2", 10);
//
//        p(a1.name + "'s powers: ");
//        for (String power: Anything.powers) {
//            p(power + " ");
//        }
//        p("\n"+a2.name + "'s powers: ");
//        for (String power: Anything.powers) {
//            p(power + " ");
//        }

//        Scanner scnr = new Scanner(System.in);
//        String input = "";
//        do {
//            p("Your input (enter [q] to quit): ");
//            input = new Scanner(System.in).next();
//            if(input.equals("q")) pln("Goodbye.");
//        }while(!input.equals("q"));
        mystery1(4321);
        mystery2(5678);
    }

    public static void mystery1(int x) {
        pln(x % 10);
        if (x / 10 != 0)
            mystery1(x / 10);
    }

    public static void mystery2(int x) {
        if (x / 10 != 0)
            mystery2(x / 10);
        pln(x % 10);
    }

    public static void addPower(String newPower) {
        String[] temp = powers;
        powers = new String[powers.length + 1];
        powers = temp;
        powers[powers.length - 1] = newPower;
    }

    private static String mysteryFn(String input) { // Method that return a string without volleys.
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
                continue;
            }
            output.append(input.charAt(i));
        }
        return output.toString();
    }

    public static void swap(int[] distances, int index1, int index2) {
        int temp = distances[index1];
        distances[index1] = distances[index2];
        distances[index2] = temp;
    }

    public static void backward(char[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            p(array[i] + " ");
        }
    }

    //Too lazy
    public static void p(Object o) {
        System.out.print(o);
    }

    public static void pln(Object o) {
        System.out.println(o);
    }

    public int getSize() {
        return this.size;
    }
}
