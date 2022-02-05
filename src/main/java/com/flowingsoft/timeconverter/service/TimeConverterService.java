package com.flowingsoft.timeconverter.service;

import com.flowingsoft.timeconverter.input.LocalTimeInput;
import org.springframework.stereotype.Service;
import com.flowingsoft.timeconverter.response.TimeResponse;
import com.flowingsoft.timeconverter.response.TimeUTCResponse;

@Service
public class TimeConverterService {

    public TimeUTCResponse convertTime(LocalTimeInput input) {
        char symbol = input.getTimezone().charAt(0);
        int cantHoras = Integer.parseInt(input.getTimezone().substring(1));
        String[] time = input.getTime().split(":");
        TimeUTCResponse response = null;

        if(isValidTime(time) && isMinusOrPlus(symbol)) {
            int responseHour = convert(symbol, cantHoras, Integer.parseInt(time[0]));
            String stringHourResponse = (responseHour <10) ? "0" + responseHour: "" + responseHour;

            TimeResponse timeResponse = new TimeResponse();
            timeResponse.setTimezone("utc");
            timeResponse.setTime(stringHourResponse.concat(":").concat(time[1]).concat(":").concat(time[2]));

            response = new TimeUTCResponse();
            response.setResponse(timeResponse);
        }

        return response;
    }

    private boolean isValidTime(String [] time) {
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int second = Integer.parseInt(time[2]);
        boolean isValidTime = true;

        if(hour < 0 || hour > 23) {
            isValidTime = false;
        }
        if(minute < 0 || minute > 59) {
            isValidTime = false;
        }
        if(second < 0 || second > 59) {
            isValidTime = false;
        }

        return isValidTime;
    }

    private boolean isMinusOrPlus(char symbol) {
        boolean isMinusOrPlus = (symbol == '+' || symbol == '-') ? true : false;

        return isMinusOrPlus;
    }

    private int convert(char symbol, int hourTimeZone, int hour) {
        int resHour;

        if(symbol == '+') {
            resHour = add(hour, hourTimeZone);
        } else {
            resHour = subtract(hour, hourTimeZone);
        }

        return  resHour;
    }

    private int subtract(int hour, int localHour) {
        int hourTimeZone =  localHour % 24;

        while(hourTimeZone > 0){
            if(hour > 0 ){
                hour = hour -1;
            }
            if(hour == 0){
                hour = 23;
            }
            hourTimeZone = hourTimeZone - 1;
        }

        return hour;
    }

    private int add(int hour, int localHour) {
        int hourTimeZone =  localHour % 24;

        while(hourTimeZone > 0){
            if(hour < 24 ){
                hour = hour + 1;
            }
            if(hour == 24){
                hour = 0;
            }
            hourTimeZone = hourTimeZone - 1;
        }

        return hour;
    }
}
