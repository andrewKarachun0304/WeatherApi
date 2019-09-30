package com.example.weatherapi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.weatherapi.R;
import com.example.weatherapi.databinding.ActivityFullWeatherBinding;
import com.example.weatherapi.pojo.weather.DailyForecast;

public class FullWeatherActivity extends AppCompatActivity {

    private static final String dataTimeFormat = "yyy-MM-dd'T'HH:mm:ssXXX";

    private Bundle intent;
    private DailyForecast daily;
    private ActivityFullWeatherBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = getIntent().getExtras();
        if (intent != null)
            daily = (DailyForecast) intent.getSerializable("daily");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_full_weather);
        binding.setDaily(daily);
    }
}
