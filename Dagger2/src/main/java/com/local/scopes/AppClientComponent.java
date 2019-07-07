package com.local.scopes;

import dagger.Component;

@Component(modules = {AppClientModule.class}, dependencies = {HttpClientComponent.class})
@Session
public interface AppClientComponent {
    AppClient createAppClient();
}
