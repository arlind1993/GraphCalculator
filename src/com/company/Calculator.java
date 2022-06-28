package com.company;

public class Calculator {
    public static double show(String input) {
        if (errors(input)){
            return -1;
        }
        if (input.equals("")){
            input="0";
        }
        if (input.charAt(0)=='-'){
            input="0"+input;
        }
        if (input.charAt(0)=='('&&input.charAt(input.length()-1)==')'&&onlyOneParenthesis(input)){
            input=input.substring(1,input.length()-1);
        }
        System.out.println(input);
        for (int i = input.length()-1; i >= 0; i--) {
            if((input.charAt(i)=='+'||input.charAt(i)=='-')&&(!charIsInParenthesis(input,i))){
                if (input.charAt(i)=='+'){
                    System.out.println(input.substring(0,i) +" + "+ input.substring(i+1) +" = "+ (show(input.substring(0,i)) + show(input.substring(i+1))));
                    return calculator(input.substring(0,i)) + calculator(input.substring(i+1));
                }else if (input.charAt(i)=='-'){
                    System.out.println(input.substring(0,i) +" - "+ input.substring(i+1) +" = "+ (show(input.substring(0,i)) - show(input.substring(i+1))));
                    return calculator(input.substring(0,i)) - calculator(input.substring(i+1));
                }
            }
        }
        for (int i = input.length()-1; i >= 0; i--) {
            if((input.charAt(i)=='*'||input.charAt(i)=='/')&&(!charIsInParenthesis(input,i))){
                if (input.charAt(i)=='*'){
                    System.out.println(input.substring(0,i) +" * "+ input.substring(i+1) +" = "+ (show(input.substring(0,i)) * show(input.substring(i+1))));
                    return calculator(input.substring(0,i)) * calculator(input.substring(i+1));
                }else if (input.charAt(i)=='/'){
                    System.out.println(input.substring(0,i) +" / "+ input.substring(i+1) +" = "+ (show(input.substring(0,i)) / show(input.substring(i+1))));
                    return calculator(input.substring(0,i)) / calculator(input.substring(i+1));
                }
            }
        }
        for (int i = input.length()-1; i >= 0; i--) {
            if((input.charAt(i)=='^')&&(!charIsInParenthesis(input,i))){
                System.out.println(input.substring(0,i) +" ^ "+ input.substring(i+1) +" = "+ Math.pow(show(input.substring(0,i)),show(input.substring(i+1))));
                return Math.pow(calculator(input.substring(0,i)),calculator(input.substring(i+1)));
            }
        }

        return Double.parseDouble(input);
    }

    public static double calculator(String input) {
        if (errors(input)){
            return -1;
        }

        if (input.equals("")){
            input="0";
        }
        if (input.charAt(0)=='-'){
            input="0"+input;
        }
        if (input.charAt(0)=='('&&input.charAt(input.length()-1)==')'&&onlyOneParenthesis(input)){
            input=input.substring(1,input.length()-1);
        }

        for (int i = input.length()-1; i >= 0; i--) {
            if((input.charAt(i)=='+'||input.charAt(i)=='-')&&(!charIsInParenthesis(input,i))){
                if (input.charAt(i)=='+'){
                    return calculator(input.substring(0,i)) + calculator(input.substring(i+1));
                }else if (input.charAt(i)=='-'){
                    return calculator(input.substring(0,i)) - calculator(input.substring(i+1));
                }
            }
        }
        for (int i = input.length()-1; i >= 0; i--) {
            if((input.charAt(i)=='*'||input.charAt(i)=='/')&&(!charIsInParenthesis(input,i))){
                if (input.charAt(i)=='*'){
                    return calculator(input.substring(0,i)) * calculator(input.substring(i+1));
                }else if (input.charAt(i)=='/'){
                    return calculator(input.substring(0,i)) / calculator(input.substring(i+1));
                }
            }
        }
        for (int i = input.length()-1; i >= 0; i--) {
            if((input.charAt(i)=='^')&&(!charIsInParenthesis(input,i))){
                return Math.pow(calculator(input.substring(0,i)),calculator(input.substring(i+1)));
            }
        }

        return Double.parseDouble(input);
    }

    public static boolean errors(String input) {
        boolean result=false;

        int countLeft=0;
        int countRight=0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)=='('){
                countLeft++;
            }else if (input.charAt(i)==')'){
                countRight++;
            }
        }

        if (countLeft!=countRight){
            result=true;
            System.out.println("Parenthesis should be opened and closed");
        }

        return result;
    }

    public static boolean onlyOneParenthesis(String input) {
        int count=0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)=='('){
                count++;
            }
        }
        return count==1;
    }

    public static boolean charIsInParenthesis(String input, int i) {
        boolean inState=false;
        for (int j = 0; j < i; j++) {
            if (input.charAt(j)=='('){
                inState=true;
            }else if (input.charAt(j)==')'){
                inState=false;
            }
        }
        return inState;
    }
}