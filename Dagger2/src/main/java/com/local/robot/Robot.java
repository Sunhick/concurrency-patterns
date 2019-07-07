package com.local.robot;

import com.local.ai.Brain;
import com.local.locomotion.Locomotion;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
public class Robot {
    private final Brain ai;
    private Locomotion motionControl;

    @Inject
    public Robot(Brain ai, Locomotion motionControl) {
        this.ai = ai;
        this.motionControl = motionControl;
    }

    public void move(String where) {
        if (ai.canMove(where)) {
            log.info("Delegate to motion controller");
            motionControl.move(where);
            return;
        }

        log.warn("can't move to {}. Perhaps another time", where);
    }
}
