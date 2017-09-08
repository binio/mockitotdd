package com.binio.powermock;

/**
 * Created by tomasz.biniecki on 08/09/2017.
 */
public class UtilityClass {
    static int staticMethod(long value) {
        // Some complex logic is done here...
        throw new RuntimeException(
                "I dont want to be executed. I will anyway be mocked out.");
    }
}