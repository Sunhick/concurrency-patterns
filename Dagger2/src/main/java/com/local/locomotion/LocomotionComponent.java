package com.local.locomotion;

import com.local.sensors.SensorsComponent;
import dagger.Component;

@Component(
        modules = {
                LocomotionModule.class
        },
        dependencies = {
                SensorsComponent.class
        })
public interface LocomotionComponent {
    Locomotion getLocomotionController();
}
