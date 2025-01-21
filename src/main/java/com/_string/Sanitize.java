package com._string;

public class Sanitize {
    public static String san(String s) {
        if (s==null) {
            return null;
        } else {
            return s.trim();
            
        }
    }
}
