package com.local.subcoms;

import lombok.Getter;
import lombok.NonNull;

import javax.inject.Inject;

public class Comms {
    @Getter
    private Channel channel;

    @Inject
    public Comms(@NonNull Channel channel) {
        this.channel = channel;
    }
}

