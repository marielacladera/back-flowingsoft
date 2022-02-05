package com.flowingsoft.timeconverter.controller;

import com.flowingsoft.timeconverter.input.LocalTimeInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import com.flowingsoft.timeconverter.response.TimeUTCResponse;
import com.flowingsoft.timeconverter.service.TimeConverterService;

import javax.validation.Valid;

@RestController
@RequestScope
@RequestMapping("/timeconverter")
public class TimeConverterController {

    @Autowired
    private TimeConverterService timeConverterService;

    @PostMapping("/convert")
    public ResponseEntity<TimeUTCResponse> convert(@RequestBody @Valid LocalTimeInput input) throws Exception {
        TimeUTCResponse response = timeConverterService.convertTime(input);

        if (response == null) {
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
