package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.print("Enter the operator ( + - * / ): ");
        String operator = getString();

        switch (operator) {
            case "+":
                System.out.print("Enter the augend ( + - * / ): ");
                String augend = getString();
                System.out.print("Enter the addend ( + - * / ): ");
                String addend = getString();
                BigDecimal sum = Calculator.addition(augend, addend);
                System.out.println("The sum is: " + sum);
                break;
            default:
                System.out.println("Invalid operator");
        }
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
