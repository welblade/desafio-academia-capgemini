package com.github.welblade.desafio_academia_capgemini;

public class QuestaoUm {
    private static final String space = " ";
    private static final String asterisk = "*";

    public static void main(final String[] args) {
        int steps = 6;

        try {
            if (args.length > 0) {
                steps = Integer.parseInt(args[0]);
            }
            buildStair(steps);
        } catch (Exception e) {
            System.out.println("Argumento inválido: " + args[0]);
        }
    }

    public static void buildStair(final int steps) {
        buildStair(steps, space, asterisk);
    }

    public static void buildStair(final int steps, final String firstChar, final String secondChar) {
        for (int i = 1; i < steps; i++) {
            System.out.println(firstChar.repeat(steps - i) + secondChar.repeat(i));
        }
        System.out.print(secondChar.repeat(steps));
    }
}
