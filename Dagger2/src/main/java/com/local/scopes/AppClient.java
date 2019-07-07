package com.local.scopes;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
@Session
public class AppClient {
    @Getter
    private HttpClient client;

    @Inject
    public AppClient(HttpClient client) {
        this.client = client;
    }
}
