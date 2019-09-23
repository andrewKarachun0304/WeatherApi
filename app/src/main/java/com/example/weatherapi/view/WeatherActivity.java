package com.example.weatherapi.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;

import com.example.weatherapi.R;
import com.example.weatherapi.ViewAdapter;
import com.example.weatherapi.contact.WeatherContactActivity;
import com.example.weatherapi.pojo.weather.Weather;
import com.example.weatherapi.presenter.WeatherPresenter;
import com.google.android.gms.location.LocationRequest;
import com.patloew.rxlocation.RxLocation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

public class WeatherActivity extends AppCompatActivity implements WeatherContactActivity {

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
        adapter = new ViewAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setItems(weather.getDailyForecasts());
    }
}
