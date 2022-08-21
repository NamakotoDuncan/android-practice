package com.dun.droid_app.io.services;

import com.dun.droid_app.io.models.boredapi.BoredModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BoredApi {
    // https://www.boredapi.com/api/activity
    @GET("")
    Call<BoredModel> getBoredActivity();
}
