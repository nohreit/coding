package caesar_cipher;

public class Solution {
    public static String caesarCipher(String s, int k){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String rotAlpha = rotateLeft(k, alpha);
        StringBuilder encrypted = new StringBuilder();

        char oldChar, newChar, cipherChar, lowC;

        for(int i = 0; i < s.length(); i++){
            oldChar = s.charAt(i);
            if(Character.isAlphabetic(oldChar)) {
                cipherChar = rotAlpha.charAt(alpha.indexOf(Character.toLowerCase(oldChar))); // cipherChar is the char from rotAlpha
                newChar = (Character.isUpperCase(oldChar)) ? Character.toUpperCase(cipherChar) : cipherChar; // check if the char is upper or lower case
                encrypted.append(newChar);
            }else encrypted.append(oldChar);
        }

        return encrypted.toString();
    }

    public static String rotateLeft(int d, String arr) {
        String rot = arr;
        char e;

        for(int i = 0; i < d; i++){
            e = rot.charAt(0); // get first char of the string
            rot = rot.substring(1, rot.length()); // return only from the 2nd index to the last index
            rot += e; // then add the previous char e to the new string rot
        }

        return rot;
    }

    public static void main(String[] args) {
        String s = "There's-a-starman-waiting-in-the-sky";
        s = "The first line contains the integer";
        int k = 0;

        pln(caesarCipher(s, k));
    }

    public static void pln(Object o) {
        System.out.println(o);
    }

    public static void p(Object o) {
        System.out.print(o);
    }
}
