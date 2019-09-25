package com.example.weatherapi.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.weatherapi.R;
import com.example.weatherapi.ViewAdapter;
import com.example.weatherapi.contact.WeatherContactActivity;
import com.example.weatherapi.pojo.weather.Weather;
import com.example.weatherapi.presenter.WeatherPresenter;

public class WeatherActivity extends AppCompatActivity implements WeatherContactActivity {

    private TextView regionTv;
    private RecyclerView recyclerView;
    private ViewAdapter adapter;

    private WeatherPresenter presenter;
    int i = 0;

    public static final String PERMISSION_STRING
            = android.Manifest.permission.ACCESS_FINE_LOCATION;
    private final int PERMISSION_REQUEST_CODE = 698;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new WeatherPresenter();
        presenter.setView(this);
        initActivityCompat();
    }

    public void initTextView(String region){
        regionTv = findViewById(R.id.region_tv);
        regionTv.setText(region);
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
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ViewAdapter.OnWeatherClickListener onWeatherClickListener =
                daily -> {
                    Intent intent = new Intent(WeatherActivity.this, FullWeatherActivity.class);
                    intent.putExtra("daily", daily);
                    startActivity(intent);
                };

        adapter = new ViewAdapter(onWeatherClickListener);
        recyclerView.setAdapter(adapter);
        adapter.setItems(weather.getDailyForecasts());
    }
}
