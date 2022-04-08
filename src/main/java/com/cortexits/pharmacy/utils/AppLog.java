package com.cortexits.pharmacy.utils;

import org.apache.commons.logging.LogFactory;

public class AppLog {
    private static LogFactory logFactory = LogFactory.getFactory();

    public static void error(Class paramClass, String paramString) {
        logFactory.getInstance(paramClass).error(paramString);
    }

    public static void error(Class paramClass, Exception paramException) {
        logFactory.getInstance(paramClass).error(paramException.getMessage(), paramException);
    }

    public static void error(Class paramClass, String paramString, Exception paramException) {
        logFactory.getInstance(paramClass).error(paramString, paramException);
    }

    public static void debug(Class paramClass, String paramString) {
        logFactory.getInstance(paramClass).debug(paramString);
    }

    public static void info(Class paramClass, String paramString) {
        logFactory.getInstance(paramClass).info(paramString);
    }
}
