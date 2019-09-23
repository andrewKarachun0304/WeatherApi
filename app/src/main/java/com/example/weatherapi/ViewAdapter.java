package com.example.weatherapi;

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

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        private String dataTimeFormat = "yyy-MM-dd'T'HH:mm:ssXXX";

        private TextView dataTv;
        private TextView tempDayTv;
        private TextView tempNightTv;
        private TextView sostDayTv;
        private TextView sostNightTv;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);

            dataTv = itemView.findViewById(R.id.data_weather_item_tv);
            tempDayTv = itemView.findViewById(R.id.day_temp_weather_item_tv);
            tempNightTv = itemView.findViewById(R.id.night_temp_weather_item_tv);
            sostDayTv = itemView.findViewById(R.id.day_sost_weather_item_tv);
            sostNightTv = itemView.findViewById(R.id.night_sost_weather_item_tv);
        }

        public void bind(DailyForecast dailyForecast){
            dataTv.setText(parseData(dailyForecast.getDate()));
            tempDayTv.setText(dailyForecast.getTemperature().getMaximum().getValue() + " C");
            sostDayTv.setText(dailyForecast.getDay().getIconPhrase());
            tempNightTv.setText(dailyForecast.getTemperature().getMinimum().getValue() + " C");
            sostNightTv.setText(dailyForecast.getNight().getIconPhrase());
        }

        private String parseData(String oldData){
            String newData = "";
            try {
                Date data = new SimpleDateFormat(dataTimeFormat).parse(oldData);
                newData = new SimpleDateFormat("EEE.dd.MM").format(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return newData;
        }
    }
}
