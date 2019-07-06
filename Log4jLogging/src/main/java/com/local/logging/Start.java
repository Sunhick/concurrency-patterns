package com.local.logging;

import com.local.Render;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Start {
    public static void main(String[] args) {
        log.debug("hello sunil");
        log.error("hello sunil");
        log.fatal("hello sunil");
        log.warn("hello sunil");
        log.info("hello sunil");
        log.trace("hello sunil");

        Render r = new Render();
        r.show();
    }
}
