package com.dun.droid_app.io.modules;

import com.dun.droid_app.io.services.BoredApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class BoredModule {
    @Provides
    @Singleton
    public static BoredApi getBoredApi() {

        return new Retrofit.Builder()
                .baseUrl("https://www.boredapi.com/api/activity")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(BoredApi.class);
    }
}
