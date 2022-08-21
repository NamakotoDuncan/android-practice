package com.dun.droid_app.io.repo;

import com.dun.droid_app.io.models.boredapi.BoredModel;

import javax.inject.Inject;

public class BoredRepo {
    private BoredApi boredApi;

    @Inject
    public  BoredRepo(BoredApi api){
        this.boredApi= api;
    }

    public Call<BoredModel> getBoredActivity(){
        return  this.boredApi.getBoredActivity();
    }
}
