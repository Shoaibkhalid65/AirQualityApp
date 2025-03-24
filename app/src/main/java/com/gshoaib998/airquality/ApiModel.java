package com.gshoaib998.airquality;

import android.content.Context;
import android.content.SharedPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiModel {
    private ApiService apiService;
    CityRepository cityRepository;

    public ApiModel(Context context) {
        apiService = RetrofitClint.getInstance().create(ApiService.class);
        cityRepository=new CityRepository(context);
    }
    public void fetchAirQualityData(String city,String key,OnFetchDataListener listener){
        Call<ApiResponse> call=apiService.getAirQuality(city,key);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if(response.isSuccessful()&&response.body()!=null) {
                    listener.onSuccess(response.body());
                }else {
                    listener.onFailure("Failed to retrieve the data");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable throwable) {
                listener.onFailure(throwable.getMessage());
            }
        });
    }

    public String getLastSearchedCity(){
        return cityRepository.getLastCity();
    }
    public void saveLastSearchedCity(String city){
        cityRepository.saveCity(city);
    }

    public interface OnFetchDataListener{
        void onSuccess(ApiResponse response);
        void onFailure(String message);
    }
}
