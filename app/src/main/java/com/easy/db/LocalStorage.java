package com.easy.db;

import com.easy.Repo;
import com.orhanobut.hawk.Hawk;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public class LocalStorage {
    private static final String DATA_FULI ="fuli";

    private LocalStorage() {
    }

    public static void saveFuliRespose(Repo body) {
        Hawk.put(DATA_FULI, body);
    }
}
