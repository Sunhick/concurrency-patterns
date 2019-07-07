package com.local;

import com.local.ai.AIComponent;
import com.local.ai.DaggerAIComponent;
import com.local.locomotion.DaggerLocomotionComponent;
import com.local.locomotion.LocomotionComponent;
import com.local.robot.DaggerRobotComponent;
import com.local.robot.Robot;
import com.local.robot.RobotComponent;
import com.local.sensors.DaggerSensorsComponent;
import com.local.sensors.SensorsComponent;
import lombok.extern.log4j.Log4j2;

import java.util.stream.IntStream;

@Log4j2
public class Starter {
    public static void main(String[] args) {
        log.debug("Hello Welcome to Dagger2");

        SensorsComponent sensorsComponent = DaggerSensorsComponent.create();

        AIComponent aiComponent = DaggerAIComponent.builder()
                .sensorsComponent(sensorsComponent)
                .build();

        LocomotionComponent locomotionComponent = DaggerLocomotionComponent.builder()
                .sensorsComponent(sensorsComponent)
                .build();

        RobotComponent robotComponent = DaggerRobotComponent.builder()
                .sensorsComponent(sensorsComponent)
                .aIComponent(aiComponent)
                .locomotionComponent(locomotionComponent)
                .build();

        Robot robo = robotComponent.createRobo();

        IntStream.range(1, 2000).forEach(e ->
                robo.move("Seattle")
        );
    }
}
