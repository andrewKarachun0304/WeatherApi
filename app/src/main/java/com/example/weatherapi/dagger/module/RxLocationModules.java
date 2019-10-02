package com.example.weatherapi.dagger.module;

import android.content.Context;

import com.patloew.rxlocation.RxLocation;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class RxLocationModules {

    @Provides
    public RxLocation providesLocation(Context context){
        return new RxLocation(context);
    }
}
