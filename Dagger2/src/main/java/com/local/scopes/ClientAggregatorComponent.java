package com.local.scopes;

import dagger.Component;

@Component(modules = {ClientAggregatorModule.class}, dependencies = {AppClientComponent.class})
@Login
public interface ClientAggregatorComponent {
    ClientAggregator createAggregator();
}
