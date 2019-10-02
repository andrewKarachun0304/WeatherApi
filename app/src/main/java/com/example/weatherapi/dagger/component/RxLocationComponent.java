package com.example.weatherapi.dagger.component;

import com.example.weatherapi.dagger.module.RxLocationModules;
import com.patloew.rxlocation.RxLocation;

import dagger.Component;

@Component(modules = RxLocationModules.class)
public interface RxLocationComponent {
    RxLocation getLocation();
}
