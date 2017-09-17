
package com.planemvp.main;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Hari on 14/09/17.
 */

public interface MainRepository {
    Single<List<Main>> getData();
}
