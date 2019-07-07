package com.local.locomotion;

import com.local.sensors.Battery;
import com.local.sensors.Gprs;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
public class Locomotion {

    private final Gprs gprs;
    private Battery battery;

    @Inject
    public Locomotion(Gprs gprs, Battery battery) {
        this.gprs = gprs;
        this.battery = battery;
    }

    public void move(String where) {
        String directions = gprs.getDirections(where);
        log.info("Moving to location: {} Directions: {}", where, directions);
    }
}
