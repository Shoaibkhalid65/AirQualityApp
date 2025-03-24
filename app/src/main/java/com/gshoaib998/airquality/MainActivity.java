package com.gshoaib998.airquality;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.gshoaib998.airquality.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements ApiContract.View {
    ActivityMainBinding binding;
    ApiPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        presenter=new ApiPresenter(this,this);
        presenter.loadCity();
        binding.edSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_SEARCH||keyEvent.getKeyCode()==KeyEvent.KEYCODE_ENTER){
                    String city= getLastSearchedCity();
                    if(!city.isEmpty()){
                        binding.tvCityName.setText(city);
                        presenter.fetchAirQuality(city,"xR8aPCusWMz9a+YttQTOFQ==3XUlzvch4Taag6bR");
                        presenter.saveCity();
                    }
                }
                return false;
            }
        });
    }
    @Override
    public void showData(ApiResponse response) {
        binding.setResponse(response);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getLastSearchedCity() {
        return Objects.requireNonNull(binding.edSearch.getText()).toString().trim();
    }

    @Override
    public void returnLastSearchCity(String city) {
        binding.tvCityName.setText(city);
        presenter.fetchAirQuality(city, "xR8aPCusWMz9a+YttQTOFQ==3XUlzvch4Taag6bR");
    }
}