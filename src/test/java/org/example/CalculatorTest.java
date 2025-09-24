package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    static Stream<Arguments> provideNumbersForSubtraction() {
        return Stream.of(
                Arguments.of("2", "1", "1"),
                Arguments.of("5", "8", "-3"),
                Arguments.of("-3", "1", "-4"),
                Arguments.of("0.003", "0.001", "0.002")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "-1, -1, -2",
            "-2, 2, 0",
            "0.00, 0.000, 0.000",
            "-1.5, 0.5, -1.0"
    })
    void testAddition(String augend, String addend, String sum) {
        BigDecimal expected = new BigDecimal(sum);
        BigDecimal actual = Calculator.addition(augend, addend);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForSubtraction")
    void testSubtraction(String minuend, String subtrahend, String difference) {
        BigDecimal expected = new BigDecimal(difference);
        BigDecimal actual = Calculator.subtraction(minuend, subtrahend);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/mult.csv", numLinesToSkip = 0)
    void testMultiplication(String multiplier, String multiplicand, String product) {
        BigDecimal expected = new BigDecimal(product);
        BigDecimal actual = Calculator.multiplication(multiplier, multiplicand);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(TestDivisionArgumentsProvider.class)
    void testDivision(String dividend, String divisor, String quotient) {
        BigDecimal expected = new BigDecimal(quotient);
        BigDecimal actual = Calculator.division(dividend, divisor);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "0.0", "0.00"})
    void testDivisionByZero(String zero) {
        Exception ex = assertThrows(ArithmeticException.class, () -> Calculator.division("3", zero));
        assertEquals("Деление на ноль не определено", ex.getMessage());
    }

    @ParameterizedTest
    @ArgumentsSource(TestRemainderOfDivisionArgumentsProvider.class)
    void testRemainderOfDivision(String dividend, String divisor, String remainder) {
        BigDecimal expected = new BigDecimal(remainder);
        BigDecimal actual = Calculator.remainderOfDivision(dividend, divisor);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "0.0", "0.00"})
    void testRemainderOfDivisionByZero(String zero) {
        Exception ex = assertThrows(ArithmeticException.class, () -> Calculator.remainderOfDivision("3", zero));
        assertEquals("Деление на ноль не определено", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "2, -1, 0.5",
            "3, 4, 81",
            "-2, 3, -8",
            "5, 0, 1",
            "2, 10, 1024"
    })
    void testExponentiation(String base, String exponent, String power) {
        BigDecimal expected = new BigDecimal(power);
        BigDecimal actual = Calculator.exponentiation(base, exponent);

        assertEquals(expected, actual);
    }
}
