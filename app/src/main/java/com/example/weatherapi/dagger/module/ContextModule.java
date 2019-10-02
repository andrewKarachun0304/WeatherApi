package com.example.weatherapi.dagger.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    public Context providesContext(){
        return context;
    }
}
