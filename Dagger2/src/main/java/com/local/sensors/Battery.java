package com.local.sensors;

import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
public class Battery {

    private int initialLevel;

    @Inject
    public Battery(int initialLevel) {
        this.initialLevel = initialLevel;
    }

    public boolean hasEnoughPower() {
        return initialLevel > 30;
    }
}
