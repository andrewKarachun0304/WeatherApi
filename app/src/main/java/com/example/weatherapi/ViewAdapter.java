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

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

            itemView.setOnClickListener(view -> {
                DailyForecast dailyForecast = dailyList.get(getLayoutPosition());
                listener.onWeatherClick(dailyForecast);
            });
        }
    }
}
