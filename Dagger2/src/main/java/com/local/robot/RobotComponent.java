package com.local.robot;

import com.local.ai.AIComponent;
import com.local.locomotion.LocomotionComponent;
import com.local.sensors.SensorsComponent;
import dagger.Component;

import javax.inject.Singleton;

@Component(
        modules = {
                RobotModule.class
        },
        dependencies = {
                AIComponent.class,
                LocomotionComponent.class,
                SensorsComponent.class
        }
)
public interface RobotComponent {
    Robot createRobo();
}
