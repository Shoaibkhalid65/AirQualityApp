package com.gshoaib998.airquality;

import android.content.Context;

public class ApiPresenter implements ApiContract.Presenter {
    ApiModel model;
    ApiContract.View view;

    public ApiPresenter(ApiContract.View view, Context context) {
        this.view = view;
        model=new ApiModel(context);
    }

    @Override
    public void fetchAirQuality(String city,String key) {
        model.fetchAirQualityData(city,key, new ApiModel.OnFetchDataListener() {
            @Override
            public void onSuccess(ApiResponse response) {
                view.showData(response);
            }

            @Override
            public void onFailure(String message) {
                view.showErrorMessage(message);
            }
        });
    }
    public void loadCity(){
        String city= model.getLastSearchedCity();
        if(!city.isEmpty()){
            view.returnLastSearchCity(city);
        }
    }
    public void saveCity(){
        String city= view.getLastSearchedCity();
        model.saveLastSearchedCity(city);
    }
}
