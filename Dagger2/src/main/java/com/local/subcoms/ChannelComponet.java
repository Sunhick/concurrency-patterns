package com.local.subcoms;

import dagger.Component;

@Component(modules = {ChannelModule.class})
public interface ChannelComponet {
    CommsComponent plus(CommsModule commsModule);
}
