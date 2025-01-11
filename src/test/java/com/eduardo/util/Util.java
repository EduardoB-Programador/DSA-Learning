package com.eduardo.util;

import org.junit.jupiter.api.function.Executable;

public class Util {

    public static void executeSmth(Executable e, int amount) throws Throwable {
        for (int i = 0; i < amount; i++)
            e.execute();
    }

    public record Person(int age, String name, String email, String secNumber){}
}
