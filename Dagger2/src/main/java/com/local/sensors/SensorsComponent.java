package com.local.sensors;

import dagger.Component;

@Component(modules = {SensorsModule.class})
public interface SensorsComponent {
    Gprs getGprs();
    Battery getBattery();
}
