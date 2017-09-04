package com.android.yt.ehouse.app.component;

import com.android.yt.ehouse.app.application.EHouseApplication;
import com.android.yt.ehouse.app.utils.Constants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by feng on 2017/6/15.
 */

@Module
public class AppModule {

    private EHouseApplication houseApplication;

    public AppModule(EHouseApplication houseApplication) {
        this.houseApplication = houseApplication;
    }


    @Singleton
    @Provides
    public OkHttpClient getOkHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(10,TimeUnit.SECONDS);
        builder.writeTimeout(10,TimeUnit.SECONDS);
        return builder.build();
    }

    @Singleton
    @Provides
    public Retrofit getRetrofit(OkHttpClient okHttpClient){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient);
        builder.addConverterFactory(ScalarsConverterFactory.create());
        builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.baseUrl("http://192.168.1.111");
        return builder.build();
    }

    @Singleton
    @Provides
    public ApiService getUserService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

}
