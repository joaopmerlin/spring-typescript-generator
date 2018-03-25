package com.spring.typescript.generator.mavenplugin.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Tipos {

    private static Map<Class, String> tipos;

    public static Map<Class, String> getTipos() {
        if (tipos == null) {
            tipos = new HashMap<>();

            tipos.put(String.class, "string");
            tipos.put(Number.class, "number");
            tipos.put(Date.class, "Date");
            tipos.put(Boolean.class, "boolean");
            tipos.put(Void.class, "void");
            tipos.put(void.class, "void");
        }

        return tipos;
    }
}
