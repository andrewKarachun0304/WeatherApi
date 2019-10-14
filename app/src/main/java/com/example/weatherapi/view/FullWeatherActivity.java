package com.example.weatherapi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.weatherapi.R;
import com.example.weatherapi.databinding.ActivityFullWeatherBinding;
import com.example.weatherapi.pojo.weather.DailyForecast;

public class FullWeatherActivity extends AppCompatActivity {

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

        binding.dayWeatherIv.setImageResource(iconsDay(daily.getDay().getIcon()));
        binding.nightWeatherIv.setImageResource(iconsDay(daily.getNight().getIcon()));
    }

    private int iconsDay(int number){
        if(number >= 1 && number <= 3)
           return R.drawable.iconfinder_weather_1_3;
        else if(number >= 4 && number <= 6)
            return R.drawable.iconfinder_weather_4_6;
        else if(number >= 7 && number <= 11)
            return R.drawable.iconfinder_weather_7_11;
        else if(number ==12)
            return R.drawable.iconfinder_weather_4_6;
        else if(number == 13 || number == 14)
            return R.drawable.iconfinder_weather_13_14;
        else if(number == 15)
            return R.drawable.iconfinder_weather_15;
        else if(number == 16 || number == 17)
            return R.drawable.iconfinder_weather_16_17;
        else if(number == 18)
            return R.drawable.iconfinder_weather_18;
        else if(number == 19)
            return R.drawable.iconfinder_weather_19;
        else if(number == 20 || number == 21)
            return R.drawable.iconfinder_weather_20_21;
        else if(number == 22)
            return R.drawable.iconfinder_weather_22;
        else if(number == 23)
            return R.drawable.iconfinder_weather_23;
        else if(number == 24 || number == 25)
            return R.drawable.iconfinder_weather_24_25;
        else if(number == 26)
            return R.drawable.iconfinder_weather_26;
        else if(number == 29)
            return R.drawable.iconfinder_weather_29;
        else if(number == 30)
            return R.drawable.iconfinder_weather_30;
        else if(number == 31)
            return R.drawable.iconfinder_weather_31;
        else if(number == 32)
            return R.drawable.iconfinder_weather_32;
        else if(number >= 33 && number <= 35)
            return R.drawable.iconfinder_weather_33_35;
        else if(number >= 36 && number <= 38)
            return R.drawable.iconfinder_weather_36_38;
        else if(number == 39 || number == 40)
            return R.drawable.iconfinder_weather_39_40;
        else if(number == 41 || number == 42)
            return R.drawable.iconfinder_weather_39_40;
        else if(number == 43)
            return R.drawable.iconfinder_weather_43;
        else
            return R.drawable.iconfinder_weather_44;
    }
}
