package com.github.welblade.desafio_academia_capgemini;

public class QuestaoDois {
    private static final int MINIMUM_LENGTH = 6;

    public static void main(final String ... args) {
        String password = "";
        if (args.length > 0) {
            password = args[0];
        }
        System.out.println(amountOfCharsNeededToPasswordMinimumLength(password));
    }

    public static int amountOfCharsNeededToPasswordMinimumLength(final String password) {
        if (password.length() <  MINIMUM_LENGTH) {
            return MINIMUM_LENGTH - password.length();
        }
        return 0;
    }
}
