package com.flowingsoft.timeconverter.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LocalTimeInput {
    @NotNull
    private String time;

    @NotNull
    private String timezone;
}
