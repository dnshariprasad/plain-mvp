package com.planemvp.main;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hari on 14/09/17.
 */

public class DataRepository implements MainRepository {
    @Override
    public List<Main> getData() {
        try {
            throw new Exception(); //dummy throw error for checking test
//            return Arrays.asList(new Main("Hari"), new Main("Ravi"), new Main("Pa1"));
        } catch (Exception e) {
            throw new RuntimeException("boom!");
        }
    }
}
