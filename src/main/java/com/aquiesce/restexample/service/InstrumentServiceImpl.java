package com.aquiesce.restexample.service;

import com.aquiesce.restexample.model.Instrument;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentServiceImpl implements InstrumentService {

    @Override
    public List<Instrument> getAllInstruments() {

        var instrumentList = new ArrayList<Instrument>();

        instrumentList.add(new Instrument(1, "Bond"));
        instrumentList.add(new Instrument(2, "Equity"));

        return instrumentList;
    }
}
