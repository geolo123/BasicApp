package com.easy.db;


import com.easy.bo.Repo;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public interface UserService {

    @GET("data/{type}/{size}/{page}")
    Call<Repo> getData(
            @Path("type") String type,
            @Path("size") int size,
            @Path("page") int page
    );

}
