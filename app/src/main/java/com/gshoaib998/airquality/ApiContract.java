package com.gshoaib998.airquality;

public interface ApiContract {
    interface View{
        void showData(ApiResponse response);
        void showErrorMessage(String message);
        String getLastSearchedCity();
        void returnLastSearchCity(String city);


    }
    interface Presenter{
        void fetchAirQuality(String city,String key);
    }

}
