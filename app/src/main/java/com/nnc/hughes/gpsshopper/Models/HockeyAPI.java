package com.nnc.hughes.gpsshopper.Models;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/**
 * Created by marcus on 7/26/17.
 */

public interface HockeyAPI {
    @GET("/android_eval.json" )
    Call<JSONResponse> getJSON();
}
