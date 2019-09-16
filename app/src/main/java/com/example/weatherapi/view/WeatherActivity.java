package com.example.weatherapi.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.weatherapi.R;
import com.example.weatherapi.contact.WeatherContactActivity;
import com.example.weatherapi.presenter.WeatherPresenter;
import com.google.android.gms.location.LocationRequest;
import com.patloew.rxlocation.RxLocation;

public class WeatherActivity extends AppCompatActivity implements WeatherContactActivity {

    private TextView textView;

    private WeatherPresenter presenter;
    private double latitude;
    private double longitude;
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

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void initTextView(String s){
        textView = findViewById(R.id.textView);
        textView.setText(s);
    }
}
