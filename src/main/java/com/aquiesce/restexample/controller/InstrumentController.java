package com.aquiesce.restexample.controller;

import com.aquiesce.restexample.model.Instrument;
import com.aquiesce.restexample.service.InstrumentService;
import com.aquiesce.restexample.service.InstrumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    public InstrumentController(InstrumentService instrumentService) {

        this.instrumentService = instrumentService;
    }

    @GetMapping("/instrument")
    public ResponseEntity<List<Instrument>> getInstruments(){

        var instruments = instrumentService.getAllInstruments();

        return new ResponseEntity(instruments, HttpStatus.OK);
    }

}
