package com.local;

import com.local.ai.AIComponent;
import com.local.ai.DaggerAIComponent;
import com.local.locomotion.DaggerLocomotionComponent;
import com.local.locomotion.LocomotionComponent;
import com.local.robot.DaggerRobotComponent;
import com.local.robot.Robot;
import com.local.robot.RobotComponent;
import com.local.scopes.*;
import com.local.sensors.DaggerSensorsComponent;
import com.local.sensors.SensorsComponent;
import com.local.subcoms.*;
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

        IntStream.range(1, 2).forEach(e ->
                robo.move("Seattle")
        );

        HttpClientComponent httpClientComponent = DaggerHttpClientComponent.create();

        {
            AppClientComponent appClientComponent = DaggerAppClientComponent.builder()
                    .httpClientComponent(httpClientComponent)
                    .build();

            AppClient appClient1 = appClientComponent.createAppClient();
            AppClient appClient2 = appClientComponent.createAppClient();
            AppClient appClient3 = appClientComponent.createAppClient();
            AppClient appClient4 = appClientComponent.createAppClient();

            log.info("{} -- {}", appClient1, appClient1.getClient());
            log.info("{} -- {}", appClient2, appClient2.getClient());
            log.info("{} -- {}", appClient3, appClient3.getClient());
            log.info("{} -- {}", appClient4, appClient4.getClient());
        }

        {
            AppClientComponent appClientComponent = DaggerAppClientComponent.builder()
                    .httpClientComponent(httpClientComponent)
                    .build();

            AppClient appClient1 = appClientComponent.createAppClient();
            AppClient appClient2 = appClientComponent.createAppClient();
            AppClient appClient3 = appClientComponent.createAppClient();
            AppClient appClient4 = appClientComponent.createAppClient();

            log.info("{} -- {}", appClient1, appClient1.getClient());
            log.info("{} -- {}", appClient2, appClient2.getClient());
            log.info("{} -- {}", appClient3, appClient3.getClient());
            log.info("{} -- {}", appClient4, appClient4.getClient());
        }

        AppClientComponent appClientComponent = DaggerAppClientComponent.builder()
                .httpClientComponent(httpClientComponent)
                .build();

        {

            ClientAggregatorComponent clientAggregatorComponent = DaggerClientAggregatorComponent.builder()
                    .appClientComponent(appClientComponent)
                    .build();

            ClientAggregator aggregator1 = clientAggregatorComponent.createAggregator();
            ClientAggregator aggregator2 = clientAggregatorComponent.createAggregator();
            ClientAggregator aggregator3 = clientAggregatorComponent.createAggregator();

            log.info("{} {} {}", aggregator1, aggregator1.getAppClient(), aggregator1.getAppClient().getClient());
            log.info("{} {} {}", aggregator2, aggregator2.getAppClient(), aggregator2.getAppClient().getClient());
            log.info("{} {} {}", aggregator3, aggregator3.getAppClient(), aggregator2.getAppClient().getClient());
        }

        {

            AppClientComponent appClientComponent1 = DaggerAppClientComponent.builder()
                    .httpClientComponent(httpClientComponent)
                    .build();
            ClientAggregatorComponent clientAggregatorComponent = DaggerClientAggregatorComponent.builder()
                    .appClientComponent(appClientComponent1)
                    .build();

            ClientAggregator aggregator1 = clientAggregatorComponent.createAggregator();
            ClientAggregator aggregator2 = clientAggregatorComponent.createAggregator();
            ClientAggregator aggregator3 = clientAggregatorComponent.createAggregator();

            log.info("{} {} {}", aggregator1, aggregator1.getAppClient(), aggregator1.getAppClient().getClient());
            log.info("{} {} {}", aggregator2, aggregator2.getAppClient(), aggregator2.getAppClient().getClient());
            log.info("{} {} {}", aggregator3, aggregator3.getAppClient(), aggregator2.getAppClient().getClient());
        }


        ChannelComponet channelComponet = DaggerChannelComponet.create();
        CommsComponent commsComponent = channelComponet.plus(new CommsModule());
        Comms comms = commsComponent.createComms();

        log.info(comms);

    }
}
