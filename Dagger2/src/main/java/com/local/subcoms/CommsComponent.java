package com.local.subcoms;

import dagger.Subcomponent;

@Subcomponent(modules = {CommsModule.class})
public interface CommsComponent {
    Comms createComms();
}
