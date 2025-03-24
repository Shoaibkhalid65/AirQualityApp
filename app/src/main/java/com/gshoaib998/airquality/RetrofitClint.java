package com.gshoaib998.airquality;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {
    public static final String BASE_URL="https://api.api-ninjas.com/v1/";
    public static Retrofit instance;

    public static Retrofit getInstance() {
        if(instance==null){

            HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client=new OkHttpClient.Builder()
                    .addInterceptor(new ApiInterceptor())
                    .addInterceptor(httpLoggingInterceptor)
                    .build();

            instance=new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(client)
                    .build();
        }
        return instance;
    }
}
