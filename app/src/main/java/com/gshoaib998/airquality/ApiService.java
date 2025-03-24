package com.gshoaib998.airquality;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String END_POINT="airquality";
    @GET(END_POINT)
    Call<ApiResponse> getAirQuality(@Query("city") String city,@Query("key") String apiKey);
}
