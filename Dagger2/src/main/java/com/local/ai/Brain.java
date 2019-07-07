package com.local.ai;

import com.local.sensors.Battery;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
public class Brain {

    private Battery battery;

    @Inject
    public Brain(@NonNull Battery battery) {
        this.battery = battery;
    }

    public boolean canMove(String where) {
        if (battery.hasEnoughPower()) {
            log.info("Move provisioned. Battery is good");
            return true;
        }

        log.error("Battery at critical level. Move declined at this moment");
        return false;
    }
}
