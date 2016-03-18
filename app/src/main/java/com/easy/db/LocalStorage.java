package com.easy.db;

import com.easy.bo.Repo;
import com.orhanobut.hawk.Hawk;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public class LocalStorage {
    private static final String DATA_FULI = "Respose";

    private LocalStorage() {
    }

    public static void saveMainData(Repo body) {
        Hawk.put(DATA_FULI, body);
    }

    public static Repo getMainData() {
        Repo data = Hawk.get(DATA_FULI);
        if (data == null) data = new Repo();
        return data;
    }
}
