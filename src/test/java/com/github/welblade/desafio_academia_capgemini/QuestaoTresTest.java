package com.github.welblade.desafio_academia_capgemini;

/*
Duas palavras podem ser consideradas anagramas de si mesmas se as letras de
uma palavra podem ser realocadas para formar a outra palavra. Dada uma string
qualquer, desenvolva um algoritmo que encontre o número de pares de substrings
que são anagramas.
Exemplo:

Exemplo 1)
    Entrada:
    ovo


    Saída:
    2

    Explicação:
    A lista de todos os anagramas pares são: [o, o], [ov, vo] que estão nas
    posições [[0], [2]], [[0, 1], [1, 2]] respectivamente.

Exemplo 2)
    Entrada:
    ifailuhkqq

    Saída:
    3

    Explicação:
    A lista de todos os anagramas pares são: [i, i], [q, q] e [ifa, fai] que
    estão nas posições [[0], [3]], [[8],  [9]] e [[0, 1, 2], [1, 2, 3]].

*/

import nl.altindag.console.ConsoleCaptor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class QuestaoTresTest {
    @ParameterizedTest
    @CsvSource({
            "oa, '[]'",
            "oo, '[o,o]'",
            "ovo, '[o,o][ov,vo]'",
            "#@#, '[#,#][#@,@#]'",
            "teste, '[t,t][e,e][te,te][tes,ste][tes,ste][est,ste]'",
            "ifailuhkqq, '[i,i][q,q][ifa,fai]'"
    })
    void findAnagramsWithCorrectInput(
            final String text,
            @ConvertWith(ToListArgumentConverter.class) final List<List<String>> expectedOutput
    ) {
        final List<List<String>> actualOutput = QuestaoTres.findAnagrams(text);

        System.out.println(
                assertThat(actualOutput)
                        .as("\nText \"%s\"\n--Expect %s\n--Received %s\n", text, expectedOutput, actualOutput)
                        .containsAll(expectedOutput)
                        .info
        );
    }

    @ParameterizedTest
    @CsvSource({
            "oa, 0",
            "oo, 1",
            "ovo, 2",
            "teste, 6",
            "ifailuhkqq, 3"
    })
    void countAnagramsWithCorrectInput(
            final String text,
            final int expectedOutput
    ) {
        final int actualOutput = QuestaoTres.countAnagrams(text);

        System.out.println(
                assertThat(actualOutput)
                        .as("Text \"%s\" expect %s", text, expectedOutput)
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
            QuestaoTres.main("teste");

            final String actualOutput = consoleCaptor.getStandardOutput().toString();
            final String expectedOutput = "6";

            System.out.println(
                    assertThat(actualOutput)
                            .contains(expectedOutput)
                            .info
            );
        }

        @Test
        void mainExecutionWithoutParam() {
            QuestaoTres.main();

            final String actualOutput = consoleCaptor.getStandardOutput().toString();
            final String expectedOutput = "0";

            System.out.println(
                    assertThat(actualOutput)
                            .contains(expectedOutput)
                            .info
            );
        }

        @Test
        void mainExecutionWithTroublesomeParams() {
            QuestaoTres.main("!@#$%*()_+!");

            final String actualOutput = consoleCaptor.getStandardOutput().toString();
            final String expectedOutput = "1";

            System.out.println(
                    assertThat(actualOutput)
                            .contains(expectedOutput)
                            .info
            );
        }
    }

    public static class ToListArgumentConverter extends SimpleArgumentConverter {
        @Override
        protected List<List<String>> convert(Object source, Class<?> targetType) {
            assertThat(targetType)
                    .overridingErrorMessage("Can only convert to List")
                    .isEqualTo(List.class);
            final String stringSource = (String) source;
            final List<List<String>> result = new ArrayList<>();
            if (stringSource.length() == 0) {
                result.add(new ArrayList<>());
            }
            final Pattern p = Pattern.compile("(\\[|]\\[|])");
            final String[] splitedText = p.split(stringSource);
            for (String text : splitedText) {
                if (text.length() > 0) {
                    List<String> elements = Arrays.asList(text.split(","));
                    result.add(elements);
                }
            }
            return result;
        }
    }
}