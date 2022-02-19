package com.github.welblade.desafio_academia_capgemini;

import nl.altindag.console.ConsoleCaptor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Escreva um algoritmo que mostre na tela uma escada de tamanho n utilizando o caractere * e espaços.
 * A base e altura da escada devem ser iguais ao valor de n. A última linha não deve conter nenhum espaço.
 * Exemplo:
 * Entrada:
 * n = 6
 * Saída:
 * *
 * **
 * ***
 * ****
 * *****
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuestaoUmTest {
    private ConsoleCaptor consoleCaptor;

    @BeforeAll
    public void setupConsoleCaptor() {
        consoleCaptor = new ConsoleCaptor();
    }

    @AfterEach
    public void clearOutput() {
        consoleCaptor.clearOutput();
    }

    @AfterAll
    public void tearDown() {
        consoleCaptor.close();
    }

    @ParameterizedTest
    @CsvSource({
            "1, [*]",
            "2, [*, **]",
            "3, [*, **, ***]"
    })
    void createStairs(int steps, String expectedOutput) {
        QuestaoUm.buildStair(steps);
        String actualOutput = consoleCaptor.getStandardOutput().toString();

        System.out.println(
                assertThat(actualOutput)
                        .contains(expectedOutput)
                        .info
        );
    }

    @ParameterizedTest
    @CsvSource({
            "1, [*]",
            "2, [_*, **]",
            "3, [__*, _**, ***]"
    })
    void createStairWithOtherChar(final int steps, final String expectedOutput) {
        QuestaoUm.buildStair(steps, "_", "*");
        String actualOutput = consoleCaptor.getStandardOutput().toString();

        System.out.println(
                assertThat(actualOutput)
                        .contains(expectedOutput)
                        .info
        );
    }

    @Test
    void mainExecutionWithCorrectParam() {
        final String[] args = {"2"};
        QuestaoUm.main(args);

        System.out.println(
                assertThat(consoleCaptor.getStandardOutput().toString())
                        .contains("[*, **]")
                        .info
        );
    }

    @Test
    void mainExecutionWithIncorrectParamShouldFail() {
        final String[] args = {"n"};
        QuestaoUm.main(args);

        System.out.println(
                assertThat(consoleCaptor.getStandardOutput().toString())
                        .withFailMessage("Argumento inválido: " + args[0])
                        .info
        );
    }

    @Test
    void mainExecutionWithoutParam() {
        final String[] args = {};
        QuestaoUm.main(args);

        System.out.println(
                assertThat(consoleCaptor.getStandardOutput().toString())
                        .contains("[*, **, ***, ****, *****, ******]")
                        .info
        );
    }
}