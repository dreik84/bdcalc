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
                System.out.print("Enter the augend: ");
                String augend = getString();
                System.out.print("Enter the addend: ");
                String addend = getString();
                BigDecimal sum = Calculator.addition(augend, addend);
                showBinaryString(augend, addend, operator, sum);
                System.out.println("The sum is: " + sum.toPlainString());
                break;
            case "-":
                System.out.print("Enter the minuend: ");
                String minuend = getString();
                System.out.print("Enter the subtrahend: ");
                String subtrahend = getString();
                BigDecimal difference = Calculator.subtraction(minuend, subtrahend);
                showBinaryString(minuend, subtrahend, operator, difference);
                System.out.println("The difference is: " + difference.toPlainString());
                break;
            case "*":
                System.out.print("Enter the multiplier: ");
                String multiplier = getString();
                System.out.print("Enter the multiplicand: ");
                String multiplicand = getString();
                BigDecimal product = Calculator.multiplication(multiplier, multiplicand);
                showBinaryString(multiplier, multiplicand, operator, product);
                System.out.println("The product is: " + product.toPlainString());
                break;
            case "/":
                System.out.print("Enter the dividend: ");
                String dividend = getString();
                System.out.print("Enter the divisor: ");
                String divisor = getString();
                BigDecimal quotient = Calculator.division(dividend, divisor);
                showBinaryString(dividend, divisor, operator, quotient);
                System.out.println("The quotient is: " + quotient.toPlainString());
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

    private static void showBinaryString(String term1, String term2, String operator, BigDecimal result) {

        System.out.printf("%s\n%s\n%s\n=\n%s\n",
                Integer.toBinaryString(Integer.parseInt(term1)),
                operator,
                Integer.toBinaryString(Integer.parseInt(term2)),
                Integer.toBinaryString(result.intValue()));
    }
}
