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
        return Arrays.asList(new Main("Hari"), new Main("Ravi"), new Main("Pa1"));
    }
}
