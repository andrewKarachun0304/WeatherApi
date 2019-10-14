package com.example.weatherapi.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.weatherapi.R;
import com.example.weatherapi.ViewAdapter;
import com.example.weatherapi.dagger.component.DaggerWeatherComponent;
import com.example.weatherapi.dagger.component.WeatherComponent;
import com.example.weatherapi.contact.WeatherContactActivity;
import com.example.weatherapi.contact.WeatherContactPresenter;
import com.example.weatherapi.databinding.ActivityWeatherBinding;
import com.example.weatherapi.pojo.weather.Weather;

public class WeatherActivity extends AppCompatActivity implements WeatherContactActivity {



    private ActivityWeatherBinding binding;
    private ViewAdapter adapter;

    private WeatherContactPresenter presenter;
    private WeatherComponent component;

    public static final String PERMISSION_STRING
            = android.Manifest.permission.ACCESS_FINE_LOCATION;
    private final int PERMISSION_REQUEST_CODE = 698;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather);

        component = DaggerWeatherComponent.create();

        presenter = component.getWeatherPresenter();
        presenter.setView(this, component.getWeatherModel());
        presenter.connection();
    }

    public void notConnection(){
        binding.regionTv.setText("Нет подключения к интернету!");
    }

    public void initTextView(String region){
        binding.regionTv.setText(region);
    }

    public void initActivityCompat(){
        if(ContextCompat.checkSelfPermission(this, PERMISSION_STRING)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{PERMISSION_STRING},
                    PERMISSION_REQUEST_CODE
            );
        } else {
            presenter.getLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_REQUEST_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    presenter.getLocation();
                } else {

                }
        }
    }

    public void initRecyclerView(Weather weather){
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ViewAdapter.OnWeatherClickListener onWeatherClickListener =
                daily -> {
                    Intent intent = new Intent(WeatherActivity.this, FullWeatherActivity.class);
                    intent.putExtra("daily", daily);
                    startActivity(intent);
                };

        adapter = new ViewAdapter(onWeatherClickListener);
        binding.recyclerView.setAdapter(adapter);
        adapter.setItems(weather.getDailyForecasts());
    }
}
