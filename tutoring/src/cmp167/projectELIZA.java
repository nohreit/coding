package cmp167;

import java.util.Scanner;

public class projectELIZA {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        PromptBank promptBank = new PromptBank();
        boolean loops = true;

        pln("ELIZA: Hello, my name is Eliza. What is your name?");

        p("USER: ");
        String userName = scnr.nextLine(); // It gets the name of the user

        pln("ELIZA: Hello " + userName + "! Tell me what is on your mind in one sentence.");

        do {
            p("USER: ");
            String str = scnr.nextLine(); // It gets a sentence from the user

            if (! str.equalsIgnoreCase("EXIT")) {
                switch (str.charAt(str.length() - 1)) {
                    case '?':
                        pln("ELIZA: " + promptBank.question(str));
                        break;
                    case '!':
                        pln("ELIZA: WOW! Dramatic! " + promptBank.statement(str));
                        break;
                    default:
                        pln("ELIZA: " + promptBank.statement(str));
                        break;
                }
            } else {
                loops = false;
            }

        } while (loops);

    }

    public static void pln(Object o) {
        System.out.println(o);
    }

    public static void p(Object o) {
        System.out.print(o);
    }
}
