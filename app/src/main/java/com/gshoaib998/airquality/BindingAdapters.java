package com.gshoaib998.airquality;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.airbnb.lottie.LottieAnimationView;


public class BindingAdapters {
    @BindingAdapter("aqiAnimation")
    public static void setAnimation(LottieAnimationView view,double aqi){
        if (aqi < 50) {
            view.setAnimation(R.raw.good); // Good Air
        } else if (aqi < 100) {
            view.setAnimation(R.raw.code_green); // Moderate Air
        } else if (aqi < 150) {
            view.setAnimation(R.raw.code_yellow); // Unhealthy for Sensitive Groups
        } else if (aqi < 200) {
            view.setAnimation(R.raw.code_orange); // Unhealthy Air
        } else if (aqi < 300) {
            view.setAnimation(R.raw.code_red); // Very Unhealthy
        } else {
            view.setAnimation(R.raw.alert_avalanche_danger); // Hazardous
        }
        view.playAnimation();
    }


}
