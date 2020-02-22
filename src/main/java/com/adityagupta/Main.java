package com.adityagupta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    private static void playAlphabetDifference() {
        Map<ArrayList<Integer>, Integer> res = new HashMap<>();
        ArrayList<String> inputs = new ArrayList<>();
        while (true) {
            inputs.add(sc.nextLine());
            if (inputs.get(inputs.size() - 1).equals("q"))
                break;

            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < inputs.get(inputs.size() - 1).length() - 1; i++) {
                arr.add(inputs.get(inputs.size() - 1).charAt(i) - inputs.get(inputs.size() - 1).charAt(i + 1));
            }
            res.put(arr, res.getOrDefault(arr, 0) + 1);
        }
        for (Map.Entry<ArrayList<Integer>, Integer> entry : res.entrySet()) {
            if (entry.getValue() == 1)
                System.out.println("Unique Found: " + getUnique(entry.getKey(), inputs));
        }
    }

    private static String getUnique(ArrayList<Integer> key, ArrayList<String> inputs) {
        for (String s : inputs) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < s.length() - 1; i++) {
                arr.add(s.charAt(i) - s.charAt(i + 1));
            }
            if (arr.equals(key))
                return s;
        }
        return "NOT FOUND";
    }

    private static void startGame() {
        char ch;
        do {
            System.out.println("What Game do you want to play?");
            System.out.println("1. Alphabet Difference");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    playAlphabetDifference();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
            }

            System.out.println("Do you want to play more?(Y/y) ");
            ch = sc.nextLine().charAt(0);
        } while (ch == 'y' || ch == 'Y');
    }

    public static void main(String[] args) {
        startGame();
    }
}
