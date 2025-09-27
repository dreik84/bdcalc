package org.example;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {

    public static final MathContext MC = new MathContext(10);
    public static final RoundingMode RM = RoundingMode.HALF_UP;

    public static BigDecimal addition(String _augend, String _addend) {
        BigDecimal augend = new BigDecimal(_augend, MC);
        BigDecimal addend = new BigDecimal(_addend, MC);

        return augend.add(addend, MC);
    }

    public static BigDecimal subtraction(String _minuend, String _subtrahend) {
        BigDecimal minuend = new BigDecimal(_minuend, MC);
        BigDecimal subtrahend = new BigDecimal(_subtrahend, MC);

        return minuend.subtract(subtrahend, MC);
    }

    public static BigDecimal multiplication(String _multiplier, String _multiplicand) {
        BigDecimal multiplier = new BigDecimal(_multiplier, MC);
        BigDecimal multiplicand = new BigDecimal(_multiplicand, MC);

        return multiplier.multiply(multiplicand, MC);
    }

    public static BigDecimal division(String _dividend, String _divisor) {
        BigDecimal dividend = new BigDecimal(_dividend, MC);
        BigDecimal divisor = new BigDecimal(_divisor, MC);

        if (divisor.compareTo(new BigDecimal("0", MC)) == 0)
            throw new ArithmeticException("Деление на ноль не определено");

        return dividend.divide(divisor, MC);
    }

    public static BigDecimal remainderOfDivision(String _dividend, String _divisor) {
        BigDecimal dividend = new BigDecimal(_dividend, MC);
        BigDecimal divisor = new BigDecimal(_divisor, MC);

        if (divisor.compareTo(new BigDecimal("0", MC)) == 0)
            throw new ArithmeticException("Деление на ноль не определено");

        return dividend.remainder(divisor, MC);
    }

    public static BigDecimal exponentiation(String _base, String _exponent) {
        BigDecimal base = new BigDecimal(_base, MC);
        BigDecimal exponent = new BigDecimal(_exponent, MC);

        return base.pow(exponent.intValue(), MC);
    }

    public static BigDecimal rootExtraction(String _radicand) {
        BigDecimal radicand = new BigDecimal(_radicand, MC);

        if (radicand.compareTo(new BigDecimal("0", MC)) < 0)
            throw new ArithmeticException("Квадратный корень отрицательного числа не определен");

        return radicand.sqrt(MC);
    }
}
