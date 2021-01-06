package codes;

public class Something {

    public static String getStringTitleCased(String s){
        if(s.isEmpty()){
            return "";
        }

        String [] upperCase = s.trim().split(" ");
        String str = "";

        for(int i = 0; i < upperCase.length; i++){
            str += Character.toUpperCase(upperCase[i].charAt(0))+ upperCase[i].substring(1)
                    + (i == upperCase.length -1 ? "" : " ");
        }

        return str;
    }

    public static void main(String [] args){

        String str = "java is hard. but i am practicing it. i wish to be the best coder ever.  ";
        pln("String: " + getStringTitleCased(str));
    }



    public static void p(Object o) {
        System.out.print(o);
    }

    public static void pln(Object o) {
        System.out.println(o);
    }
}
