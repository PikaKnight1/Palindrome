package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        Scanner sc = new Scanner(System.in);
        String choice = "";

        while(true) {
            System.out.println("\nWybierz co chcesz zrobić: \n" +
                    "1. Wyświetl kilka przykładów.\n" +
                    "2. Stwórz własną listę do sprawdzenia.\n" +
                    "9. Wyjdź");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    list = new ArrayList<Object>();
                    createExamples(list);
                    showList(list);
                    break;
                case "2":
                    list = new ArrayList<Object>();
                    createUserList(list);
                    showList(list);
                    break;
                case "9":

                    break;
                default:
                    System.err.println("Nie ma opcji dla wprowadzonych danych.");
                    break;
            }
        }
    }

    public static List<Object> createExamples(List<Object> list) {
        list.add("A to kawa kota.");
        list.add("Ej, żyrafa ryż je.");
        list.add("Witam świecie!");
        list.add("Was it a cat I saw?");
        list.add(12321);
        list.add(12343);

        return list;
    }

    public static void showList(List<Object> list) {
        for(Object o: list) {
            boolean result = true;
            if (o instanceof String) result = CheckPalindrome.isThisAPalindrome((String)o);
            if (o instanceof Integer) result = CheckPalindrome.isThisAPalindrome((Integer)o);

            String stringbuild = "Treść: \"" + o;
            stringbuild += (result) ? "\" jest palindromem." : "\" nie jest palindromem.";
            System.out.println(stringbuild);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Wciśnij enter aby kontynuować...");
        sc.nextLine();
    }

    public static List<Object> createUserList(List<Object> list) {
        String input;
        int tmpInput;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Podaj następny tekst, który chcesz sprawdzić lub wciśnij enter zakończyć.");
            System.err.println("Uwaga. W przypadku samego tekstu, ignorowane są wszystkie znaki poza literami.");
            System.err.println("W przypadku liczb, akceptowane są liczby całkowite w zakresie do 2 147 483 647");
            input = sc.nextLine();

            try {
                tmpInput = Integer.parseInt(input);
                list.add(tmpInput);
            }
            catch (NumberFormatException ex) {
                list.add(input);
            }

        } while (!input.isEmpty());
    return list;
    }

}