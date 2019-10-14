package com.example.weatherapi;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapi.databinding.WeatherItemViewBinding;
import com.example.weatherapi.pojo.weather.DailyForecast;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.WeatherViewHolder> {

    private List<DailyForecast> dailyList = new ArrayList<>();
    private OnWeatherClickListener listener;

    public ViewAdapter(OnWeatherClickListener listener) {
        this.listener = listener;
    }

    public void setItems(List<DailyForecast> daily){
         dailyList.addAll(daily);
         notifyDataSetChanged();
    }

    public void deleteItems(){
        dailyList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        WeatherItemViewBinding binding = WeatherItemViewBinding.inflate(inflater, parent, false);
        return new WeatherViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        DailyForecast dailyForecast = dailyList.get(position);
        holder.icons(dailyForecast.getDay().getIcon());
        holder.binding.setDaily(dailyForecast);
    }

    @Override
    public int getItemCount() {
        return dailyList.size();
    }

    public interface OnWeatherClickListener{
        void onWeatherClick(DailyForecast daily);
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        private WeatherItemViewBinding binding;
        private DailyForecast daily;

        public void setDaily(DailyForecast daily) {
            this.daily = daily;
        }

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

            itemView.setOnClickListener(view -> {
                DailyForecast dailyForecast = dailyList.get(getLayoutPosition());
                listener.onWeatherClick(dailyForecast);
            });
        }

        private void icons(int number){
            if(number >= 1 && number <= 3)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_1_3);
            else if(number >= 4 && number <= 6)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_4_6);
            else if(number >= 7 && number <= 11)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_7_11);
            else if(number ==12)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_4_6);
            else if(number == 13 || number == 14)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_13_14);
            else if(number == 15)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_15);
            else if(number == 16 || number == 17)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_16_17);
            else if(number == 18)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_18);
            else if(number == 19)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_19);
            else if(number == 20 || number == 21)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_20_21);
            else if(number == 22)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_22);
            else if(number == 23)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_23);
            else if(number == 24 || number == 25)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_24_25);
            else if(number == 26)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_26);
            else if(number == 29)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_29);
            else if(number == 30)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_30);
            else if(number == 31)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_31);
            else if(number == 32)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_32);
            else if(number >= 33 && number <= 35)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_33_35);
            else if(number >= 36 && number <= 38)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_36_38);
            else if(number == 39 || number == 40)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_39_40);
            else if(number == 41 || number == 42)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_39_40);
            else if(number == 43)
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_43);
            else
                binding.weatherIconImageView.setImageResource(R.drawable.iconfinder_weather_44);
        }
    }
}
