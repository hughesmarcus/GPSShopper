package com.nnc.hughes.gpsshopper.data;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by marcus on 7/26/17.
 */

public interface HockeyAPI {
    @GET("/android_eval.json" )
    Call<JSONResponse> getJSON();
}
