package cmp485;

public class CamelCase {

    public static void main(String[] args) {
        pln("Word count: " + camelCase("saveChangesInTheEditor"));
    }

    public static int camelCase(String s) {
        int x = 0, i = 0, count = 0;
        if (Character.isLowerCase(s.charAt(0))) {
            for (; i < s.length(); i++) {
                if (Character.isUpperCase(s.charAt(i))) {
                    count++;
                    x = i;
                }
            }
            count++;
        }
        return count;
    }

    public static void p(Object o) {
        System.out.print(o);
    }

    public static void pln(Object o) {
        System.out.println(o);
    }
}
