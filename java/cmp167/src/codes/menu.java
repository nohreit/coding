package codes;

import java.util.Scanner;

public class menu {
    private static final String ERMSG = "Entry incorrect!!! Please, try again...\n";
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String decision = "", name = "";

        pln("Welcome to \"Your Restaurant\"\nWould you like to place an order?");

        do { // If the user gives an answer different from Yes and No
            decision = sc.nextLine().toUpperCase(); //user says yes or no
        } while (!decision.equals("YES") && !decision.equals("NO"));

        if (decision.equals("YES")) {
            mainMenu(); // mainMenu method call and we go to the corresponding method.
        }

        pln("Thank you"); // waiter says thank you whether you place an order or not.

    }

    // Zyleyaime: AikoEtsuko246@gmail.com

    public static void mainMenu() {
        String order = ""; // to record the order of the user.
        String name = "";
        int choice;
        boolean isNotDone = true;

        pln("What is the name for your order ?");
        name = sc.nextLine(); //Zuleyaime

        while(isNotDone) {
            pln("Select from the main menu " + name + ":\n" +
                    "0 - Nothing\n" +
                    "1 - Appetizer\n" +
                    "2 - Main Course\n" +
                    "3 - Dessert\n" +
                    "Enter your selection [ 0 , 1 , 2 , 3]"
            );

            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    pln("I changed my mind, I need nothing. Thank you.");
                    isNotDone = false;
                    break;
                case 1:
                    order += "Appetizer: [";
                    order = appMenu(order); // appMenu(order) => Appetizer: [Oysters
                    isNotDone = false;
                    break;
                case 2:
                    order += "Main Course: [";
                    order = mainCourseMenu(order); //method call
                    break;
                case 3:
                    order += "Dessert: [";
                    order = desMenu(order);
                    isNotDone = false;
                    break;
                default:
                    pln("I am sorry, we do not have that.");
                    isNotDone = false;
                    break;
            }
            order+="\n"; // Appetizer: [Oysters \n
        }

        pln(order); // display the order for the main.
    }

    public static String appMenu(String order){
        int choice;
        boolean isNotDone = true;
        pln("previous: "+order);
        while(isNotDone) {
            pln("Appetizer menu:\n " +
                    "0 - Nothing\n" +
                    "1 - Oysters\n" +
                    "2 - Grilled Octopus\n" +
                    "3 - Hummus\n" +
                    "Enter your selection [ 0 , 1 , 2 or 3]"
            );

            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    order += "]";
                    break;
                case 1:
                    order += "Oysters: "; // => Appetizer: [ Oysters
                    order = topMenu(order); //method call
                    isNotDone = false;
                    break;
                case 2:
                    order += "Grilled Octopus";
                    order = topMenu(order);
                    isNotDone = false;
                    break;
                case 3:
                    order += "Hummus";
                    order = topMenu(order);
                    isNotDone = false;
                    break;
                default:
                    pln(ERMSG);
                    break;
            }
        }

        return order; // => Appetizer: [ Oyster
    }

    public static String mainCourseMenu(String order){ // This is the main course menu method
        int choice;
        boolean isNotDone = true;
        while(isNotDone) {
            pln("Main course menu:\n " +
                    "0 - Nothing\n" +
                    "1 - Grilled Chicken Sandwich\n" +
                    "2 - Vegetable fried rice\n" +
                    "3 - White rice white and some sauce\n" +
                    "Enter your selection [ 0 , 1 , 2 , 3]"
            );

            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    order += "]";
                    break;
                case 1:
                    order += "Grilled Chicken Sandwich: [";
                    order = topMenu(order);
                    break;
                case 2:
                    order += "Vegetable fried rice: [";
                    order = topMenu(order);
                    break;
                case 3:
                    order += "White rice white and some sauce: [";
                    order = topMenu(order);
                    break;
                default:
                    pln(ERMSG);
                    break;
            }
        }

        return order;
    }

    public static String desMenu(String order){
        int choice;
        boolean isNotDone = true;
        while(isNotDone) {
            pln("Select from the main menu:\n " +
                    "0 - Nothing\n" +
                    "1 - Charlotte aux fraises\n" +
                    "2 - Takoyaki\n" +
                    "3 - Ice cream\n" +
                    "Enter your selection [ 0 , 1 , 2 , 3]"
            );

            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    order += "]";
                    break;
                case 1:
                    order += "Charlotte aux fraises: [";
                    order = desTopMenu(order);  // return
                    isNotDone = false;
                    break;
                case 2:
                    order += "Takoyaki: [";
                    order = desTopMenu(order);
                    isNotDone = false;
                    break;
                case 3:
                    order += "Ice cream: [";
                    order = desTopMenu(order);
                    isNotDone = false;
                    break;
                default:
                    pln(ERMSG);
                    break;
            }
        }

        return order;
    }

    public static String topMenu(String order){
        pln("topMeth: "+ order);
        order += " : "; // format need
        boolean isNotDone = true;

        int choice;
        do {
            pln("Topping menu:\n " +
                    "0 - Nothing\n" +
                    "1 - Soy Sauce\n" +
                    "2 - Onions\n" +
                    "3 - Peppers\n" +
                    "Enter your selection [ 0 , 1 , 2 or 3]"
            );

            choice = sc.nextInt();
            switch (choice) {
                case 0: order += "]"; // checking it later
                    break;
                case 1:
                    order += "Soy Sauce";
                    order = topMenu(order); // adding more topping;
                    isNotDone = false;
                    break;
                case 2:
                    order += "Onions";
                    order = topMenu(order); // adding more topping;
                    isNotDone = false;
                    break;
                case 3:
                    order += "Peppers";
                    order = topMenu(order); // adding more topping;
                    isNotDone = false;
                    break;
                default:
                    pln(ERMSG);
                    break;
            }

        }while (choice < 0 || choice > 3);

        return order;
    }

    public static String desTopMenu(String order){
        order += " : ";
        int choice;
        boolean isNotDone = true;
        while(isNotDone) {
            pln("Dessert topping menu:\n " +
                    "0 - Nothing\n" +
                    "1 - Strawberry\n" +
                    "2 - Pineapple\n" +
                    "3 - Cream\n" +
                    "Enter your selection [ 0 , 1 , 2 or 3]"
            );

            choice = sc.nextInt();
            switch (choice) {
                case 0: order += "]";
                    break;
                case 1:
                    order += "Strawberry";
                    order = desTopMenu(order);
                    isNotDone = false;
                    break;
                case 2:
                    order += "Pineapple";
                    desTopMenu(order);
                    isNotDone = false;
                    break;
                case 3:
                    order += "Cream";
                    order = desTopMenu(order);
                    isNotDone = false;
                    break;
                default:
                    pln(ERMSG);
                    break;
            }
        }
        return order;
    }

    public static void p(Object o) {
        System.out.print(o);
    }

    public static void pln(Object o) {
        System.out.println(o);
    }
}