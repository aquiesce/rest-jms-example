package com.aquiesce.restexample.service;

import com.aquiesce.restexample.model.Instrument;

public interface JmsService {
    void send(Instrument message);
}
