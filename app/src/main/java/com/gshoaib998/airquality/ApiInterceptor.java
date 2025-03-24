package com.gshoaib998.airquality;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest=chain.request();
        Request modifiedRequest=originalRequest.newBuilder()
                .addHeader("X-Api-Key","xR8aPCusWMz9a+YttQTOFQ==3XUlzvch4Taag6bR")
                .addHeader("Accept","application/json")
                .build();
        return chain.proceed(modifiedRequest);
    }
}
