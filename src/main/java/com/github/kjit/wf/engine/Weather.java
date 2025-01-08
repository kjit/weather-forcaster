package com.github.kjit.wf.engine;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record Weather(
    double temperature,
    int humidity,
    int precipitation,
    int cloudCover,
    Direction windDirection,
    int windSpeed,
    Location location,
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'") LocalDateTime occurrenceTime
    )   
{
    }
