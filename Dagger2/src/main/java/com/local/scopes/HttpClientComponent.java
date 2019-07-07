package com.local.scopes;

import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {HttpClientModule.class})
@Singleton
public interface HttpClientComponent {
    HttpClient createHttpClient();
}
