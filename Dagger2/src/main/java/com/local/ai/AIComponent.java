package com.local.ai;

import com.local.sensors.SensorsComponent;
import dagger.Component;

@Component(
        modules = {
                AIModule.class
        },
        dependencies = {
                SensorsComponent.class
        }
)
public interface AIComponent {
    Brain getAI();
}
