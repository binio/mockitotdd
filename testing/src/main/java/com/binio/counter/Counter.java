package com.binio.counter;

/**
 * Created by tomasz.biniecki on 12/09/2017.
 */
public class Counter {
    public String getResult(int i) {
        if((i % 2)==0 && (i % 3)==0) {
            return "OK";
        }
        return "NOT OK";
    }
}
