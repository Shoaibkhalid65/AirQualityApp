package com.gshoaib998.airquality;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("overall_aqi")
    private double overallAqi;
    @SerializedName("CO")
    private Pollutant co;
    @SerializedName("PM10")
    private Pollutant pm10;
    @SerializedName("SO2")
    private Pollutant so2;
    @SerializedName("PM2.5")
    private Pollutant pm2;
    @SerializedName("O3")
    private Pollutant o3;
    @SerializedName("NO2")
    private Pollutant no2;

    public double getOverallAqi() {
        return overallAqi;
    }

    public void setOverallAqi(double overallAqi) {
        this.overallAqi = overallAqi;
    }

    public Pollutant getCo() {
        return co;
    }

    public void setCo(Pollutant co) {
        this.co = co;
    }

    public Pollutant getPm10() {
        return pm10;
    }

    public void setPm10(Pollutant pm10) {
        this.pm10 = pm10;
    }

    public Pollutant getSo2() {
        return so2;
    }

    public void setSo2(Pollutant so2) {
        this.so2 = so2;
    }

    public Pollutant getPm2() {
        return pm2;
    }

    public void setPm2(Pollutant pm2) {
        this.pm2 = pm2;
    }

    public Pollutant getO3() {
        return o3;
    }

    public void setO3(Pollutant o3) {
        this.o3 = o3;
    }

    public Pollutant getNo2() {
        return no2;
    }

    public void setNo2(Pollutant no2) {
        this.no2 = no2;
    }

    public static class Pollutant{
        @SerializedName("concentration")
        private double concentration;
        @SerializedName("aqi")
        private double aqi;

        public double getConcentration() {
            return concentration;
        }

        public void setConcentration(double concentration) {
            this.concentration = concentration;
        }

        public double getAqi() {
            return aqi;
        }

        public void setAqi(double aqi) {
            this.aqi = aqi;
        }
    }
}
