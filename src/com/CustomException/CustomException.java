package com.CustomException;   // ✅ package comes first

import java.util.*;            // ✅ then imports

public class CustomException extends Exception {

    public CustomException(String message) {
        super(message);
    }
}
