package com.example.weatherapi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.weatherapi.R;
import com.example.weatherapi.pojo.weather.DailyForecast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FullWeatherActivity extends AppCompatActivity {

    private static final String dataTimeFormat = "yyy-MM-dd'T'HH:mm:ssXXX";

    private Bundle intent;
    private DailyForecast daily;

    private TextView dayDataTv;
    private TextView nightDataTv;
    private TextView dayTempTv;
    private TextView nightTempTv;
    private TextView daySostTv;
    private TextView nightSostTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_weather);

        intent = getIntent().getExtras();
        daily = (DailyForecast) intent.getSerializable("daily");

        initActivity();
    }

    private void initActivity(){
        dayDataTv = findViewById(R.id.day_data_full_weather_tv);
        nightDataTv = findViewById(R.id.night_data_full_weather_tv);
        dayTempTv = findViewById(R.id.day_temp_full_weather_tv);
        nightTempTv = findViewById(R.id.night_temp_full_weather_tv);
        daySostTv = findViewById(R.id.day_sost_full_weather_tv);
        nightSostTv = findViewById(R.id.night_sost_full_weather_tv);

        dayDataTv.setText(parseData(daily.getDate()));
        nightDataTv.setText(parseData(daily.getDate()));
        dayTempTv.setText(daily.getTemperature().getMaximum().getValue() + " F");
        nightTempTv.setText(daily.getTemperature().getMinimum().getValue() + " F");
        daySostTv.setText(daily.getDay().getIconPhrase());
        nightSostTv.setText(daily.getNight().getIconPhrase());
    }

    private String parseData(String oldData){
        String newData = "";
        try {
            Date data = new SimpleDateFormat(dataTimeFormat).parse(oldData);
            newData = new SimpleDateFormat("dd.MM").format(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newData;
    }
}
