package com.example.weatherapi;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapi.pojo.weather.DailyForecast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.WeatherViewHolder> {

    private List<DailyForecast> dailyList = new ArrayList<>();
    private OnWeatherClickListener listener;

    public ViewAdapter(OnWeatherClickListener listener) {
        this.listener = listener;
    }

    public void setItems(List<DailyForecast> daily){
        if (daily.equals(null)){
            Log.d("TAG", "LIST NULL!!!");
            return;
        } else {
            dailyList.addAll(daily);
            notifyDataSetChanged();
        }
    }

    public void deleteItems(){
        dailyList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item_view, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        holder.bind(dailyList.get(position));
    }

    @Override
    public int getItemCount() {
        return dailyList.size();
    }

    public interface OnWeatherClickListener{
        void onWeatherClick(DailyForecast daily);
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        private static final String dataTimeFormat = "yyy-MM-dd'T'HH:mm:ssXXX";

        private TextView dataTv;
        private TextView tempTv;
        private TextView dayWeatherTv;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);

            dataTv = itemView.findViewById(R.id.data_weather_item_tv);
            tempTv = itemView.findViewById(R.id.temp_weather_item_tv);
            dayWeatherTv = itemView.findViewById(R.id.day_weather_item_tv);

            itemView.setOnClickListener(view -> {
                DailyForecast dailyForecast = dailyList.get(getLayoutPosition());
                listener.onWeatherClick(dailyForecast);
            });
        }

        public void bind(DailyForecast dailyForecast){
            dataTv.setText(parseData(dailyForecast.getDate()));
            tempTv.setText(convertTemperature(dailyForecast.getTemperature().getMaximum().getValue()) + " C/ "
                    + convertTemperature(dailyForecast.getTemperature().getMinimum().getValue()) + " C");
            dayWeatherTv.setText(dailyForecast.getDay().getIconPhrase());
        }

        private String parseData(String oldData){
            String newData = "";
            try {
                Date data = new SimpleDateFormat(dataTimeFormat).parse(oldData);
                newData = new SimpleDateFormat("EEE dd.MM").format(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return newData;
        }

        private int convertTemperature(String tempStr){
            double temp = Double.parseDouble(tempStr);
            return (int) ((temp - 32) / 1.8);
        }
    }
}
