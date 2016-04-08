package com.easy.api;


import com.easy.pojo.Gank;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public interface MainService {


    @GET("data/Android/{size}/{page}")
    Call<Gank> getMainAndroid(
            @Path("size") int size,
            @Path("page") int page
    );

}
