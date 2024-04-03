package com.github.kjit.wf.engine;

import java.time.LocalDateTime;

public record Weather(
    double temperature,
    int humidity,
    int precipitation,
    int cloudCover,
    Direction windDirection,
    int windSpeed,
    Location location,
    LocalDateTime occurenceTime)   
{
    }
