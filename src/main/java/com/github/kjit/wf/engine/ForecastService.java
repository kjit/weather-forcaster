package com.github.kjit.wf.engine;

import java.time.LocalDateTime;

public class ForecastService {
    
    public Weather fetchCurrentWeatherFor(Location location) {
        Weather w = new Weather(4d, 32, 4, 20, Direction.N, 32, location, LocalDateTime.now());
        return w;
    }

}
