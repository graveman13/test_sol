package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        show();
    }

    public static void show() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println("Fizz");
                continue;
            }
            if (i % 5 == 0) {
                System.out.println("FizzBazz");
                continue;
            }
            System.out.println(i);
        }
    }

    public static int[][] chunk(int[] array, int number) {
        int rest = array.length % number;
        int len = number >= array.length ? 1 : rest != 0 ? array.length / number + 1 : array.length / number;
        int[][] sepArray = new int[len][];

        for (int i = 0; i < sepArray.length; i++) {
            if (rest != 0 && i == sepArray.length - 1) {
                sepArray[i] = new int[rest];
                break;
            }
            sepArray[i] = new int[number];
        }
        for (int i = 0, k = 0; i < sepArray.length; i++) {
            for (int j = 0; j < sepArray[i].length; j++) {
                sepArray[i][j] = array[k++];
            }
        }
        return sepArray;
    }

    public static String isBracketsCorrect(String inputLine) {
        if (inputLine.isEmpty()) {
            return Answer.WRONG_CHAR.getAnswer();
        }
        Stack<String> stack = new Stack<>();
        String openBrackets = "([{";
        String[] bracketsArray = inputLine.split("");

        for (int i = 0; i < bracketsArray.length; i++) {
            String symbol = bracketsArray[i];

            if (openBrackets.contains(symbol)) {
                stack.push(symbol);
                continue;
            }

            if (stack.isEmpty())
                return Answer.WRONG_ORDER.getAnswer();

            String checkSymbol = stack.pop();
            switch (symbol) {
                case ")":
                    if (checkSymbol.equals("{") || checkSymbol.equals("["))
                        return Answer.WRONG_ORDER.getAnswer();
                    break;

                case "}":
                    if (checkSymbol.equals("(") || checkSymbol.equals("["))
                        return Answer.WRONG_ORDER.getAnswer();
                    break;

                case "]":
                    if (checkSymbol.equals("(") || checkSymbol.equals("{"))
                        return Answer.WRONG_ORDER.getAnswer();
                    break;
            }
        }
        return stack.isEmpty() ? Answer.VALID.getAnswer() : Answer.WRONG_ORDER.getAnswer();
    }

    public enum Answer {
        WRONG_ORDER("Wrong order"),
        VALID("true"),
        WRONG_CHAR("Wrong char");
        private String answer;

        Answer(String answer) {
            this.answer = answer;
        }

        public String getAnswer() {
            return answer;
        }
    }
}
