package com.local.scopes;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
public class ClientAggregator {
    @Getter
    private AppClient appClient;

    @Inject
    public ClientAggregator(AppClient appClient) {
        this.appClient = appClient;
    }
}
