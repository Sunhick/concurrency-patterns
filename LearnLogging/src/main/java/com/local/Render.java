package com.local;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Render {
    public void show() {
        log.debug("hello render");
        log.error("hello render");
        log.fatal("hello render");
        log.warn("hello render");
        log.info("hello render");
        log.trace("hello render");
    }
}
