package com.github.welblade.desafio_academia_capgemini;

import nl.altindag.console.ConsoleCaptor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Débora se inscreveu em uma rede social para se manter em contato com seus amigos.
 * A página de cadastro exigia o preenchimento dos campos de nome e senha, porém a
 * senha precisa ser forte. O site considera uma senha forte quando ela satisfaz os
 * seguintes critérios:
 * Possui no mínimo 6 caracteres.
 * Contém no mínimo 1 digito.
 * Contém no mínimo 1 letra em minúsculo.
 * Contém no mínimo 1 letra em maiúsculo.
 * Contém no mínimo 1 caractere especial.
 * Os caracteres especiais são: !@#$%^&*()-+
 * Débora digitou uma string aleatória no campo de senha, porém ela não tem certeza
 * se é uma senha forte. Para ajudar Débora, construa um algoritmo que informe qual
 * é o número mínimo de caracteres que devem ser adicionados para uma string qualquer
 * ser considerada segura.
 * Exemplo:
 * Entrada:
 * Ya3
 * Saída:
 * 3
 * Explicação:
 * Ela pode tornar a senha segura adicionando 3 caracteres, por exemplo, &ab,
 * transformando a senha em Ya3&ab. 2 caracteres não são suficientes visto que
 * a senha precisa ter um tamanho mínimo de 6 caracteres.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuestaoDoisTest {

    @ParameterizedTest
    @CsvSource({
            "'', 6",
            "Ya3, 3",
            "aaaaaa, 0",
            "ABCDEFGH, 0",
    })
    void checkCorrectInput(final String password, final int expectedOutput) {
        final int actualOutput = QuestaoDois.amountOfCharsNeededToPasswordMinimumLength(password);

        System.out.println(
                assertThat(actualOutput)
                        .as("\nPassword \"%s\"\n--expect %d\n--received %d\n", password, expectedOutput, actualOutput)
                        .isEqualTo(expectedOutput)
                        .info
        );
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class MainFunctionTest {
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

        @Test
        void mainExecution() {
            QuestaoDois.main("teste");

            final String actualOutput = consoleCaptor.getStandardOutput().toString();
            final String expectedOutput = "1";

            System.out.println(
                    assertThat(actualOutput)
                            .contains(expectedOutput)
                            .info
            );
        }

        @Test
        void mainExecutionWithoutParam() {
            QuestaoDois.main("");

            final String actualOutput = consoleCaptor.getStandardOutput().toString();
            final String expectedOutput = "6";

            System.out.println(
                    assertThat(actualOutput)
                            .contains(expectedOutput)
                            .info
            );
        }
    }

}