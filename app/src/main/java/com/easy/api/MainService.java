package com.easy.api;


import com.easy.pojo.Goods;
import com.easy.pojo.GoodsRepo;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public interface MainService {


    @GET("data/福利/{size}/{page}")
    Call<GoodsRepo> getBenefitsGoods(
            @Path("size") int size,
            @Path("page") int page
    );

}
