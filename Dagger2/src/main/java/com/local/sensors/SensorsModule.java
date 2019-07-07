package com.local.sensors;

import dagger.Module;
import dagger.Provides;

@Module
public class SensorsModule {
    @Provides
    public int getInitialBatteryLevel() {
        return 70;
    }
}
