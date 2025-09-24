package org.example;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class TestRemainderOfDivisionArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("2", "2", "0"),
                Arguments.of("15", "10", "5"),
                Arguments.of("-3", "2", "-1"),
                Arguments.of("0", "2", "0"),
                Arguments.of("0.003", "0.001", "0.000"),
                Arguments.of("10", "-3", "1")
        );
    }
}
