package com.planemvp.main;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Single;

/**
 * Created by Hari on 14/09/17.
 */

public class DataRepository implements MainRepository {
    public DataRepository() {
    }

    @Override
    public Single<List<Main>> getData() {
        try {
//            throw new Exception(); //dummy throw error for checking test
            return Single.just(Arrays.asList(new Main("Hari"), new Main("Ravi"), new Main("Pa1")));
        } catch (Exception e) {
            throw new RuntimeException("boom!");
        }
    }
}
