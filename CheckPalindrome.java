package com.company;

public class CheckPalindrome {

    public static boolean isThisAPalindrome(String text) {
        String plainText = "";
        for(int i = 0; i < text.length(); i++) {
            char tmp = text.toLowerCase().toCharArray()[i];
            if(Character.isLetter(tmp)) plainText += tmp;
        }

        return isThisPalindrome(plainText);
    }

    public static boolean isThisAPalindrome(int nmb) {
        String plainText = Integer.toString(nmb);

        return isThisPalindrome(plainText);
    }

    private static boolean isThisPalindrome(String plainText) {
        for(int i = 0; i < plainText.length()/2; i++) {
            if(plainText.toCharArray()[i] != plainText.toCharArray()[plainText.length()-i-1]) return false;
        }

        return true;
    }
}
