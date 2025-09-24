package org.example;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {

    public static final MathContext MC = new MathContext(10);
    public static final RoundingMode RM = RoundingMode.HALF_UP;

    public static BigDecimal addition(String augend, String addend) {
        BigDecimal term1 = new BigDecimal(augend, MC);
        BigDecimal term2 = new BigDecimal(addend, MC);

        return term1.add(term2, MC);
    }

    public static BigDecimal subtraction(String minuend, String subtrahend) {
        BigDecimal term1 = new BigDecimal(minuend, MC);
        BigDecimal term2 = new BigDecimal(subtrahend, MC);

        return term1.subtract(term2, MC);
    }

    public static BigDecimal multiplication(String multiplier, String multiplicand) {
        BigDecimal term1 = new BigDecimal(multiplier, MC);
        BigDecimal term2 = new BigDecimal(multiplicand, MC);

        return term1.multiply(term2, MC);
    }

    public static BigDecimal division(String dividend, String divisor) {
        BigDecimal term1 = new BigDecimal(dividend, MC);
        BigDecimal term2 = new BigDecimal(divisor, MC);

        if (term2.compareTo(new BigDecimal("0", MC)) == 0)
            throw new ArithmeticException("Деление на ноль не определено");

        return term1.divide(term2, MC);
    }

    public static BigDecimal remainderOfDivision(String dividend, String divisor) {
        BigDecimal term1 = new BigDecimal(dividend, MC);
        BigDecimal term2 = new BigDecimal(divisor, MC);

        if (term2.compareTo(new BigDecimal("0", MC)) == 0)
            throw new ArithmeticException("Деление на ноль не определено");

        return term1.remainder(term2, MC);
    }

    public static BigDecimal exponentiation(String base, String exponent) {
        BigDecimal term1 = new BigDecimal(base, MC);
        BigDecimal term2 = new BigDecimal(exponent, MC);

        return term1.pow(term2.intValue(), MC);
    }
}
