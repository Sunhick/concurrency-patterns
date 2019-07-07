package com.local.sensors;

import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
public class Gprs {

    @Inject
    public Gprs() {

    }

    public String getDirections(String where) {
        log.debug("Finding directions to {}", where);
        return null;
    }
}
