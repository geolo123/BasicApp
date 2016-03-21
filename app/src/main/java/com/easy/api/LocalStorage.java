package com.easy.api;

import com.easy.pojo.Goods;
import com.orhanobut.hawk.Hawk;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public class LocalStorage {
    private static final String DATA_FULI = "Respose";

    private LocalStorage() {
    }

    public static void saveMainData(Goods body) {
        Hawk.put(DATA_FULI, body);
    }

    public static Goods getMainData() {
        Goods data = Hawk.get(DATA_FULI);
        if (data == null) data = new Goods();
        return data;
    }
}
