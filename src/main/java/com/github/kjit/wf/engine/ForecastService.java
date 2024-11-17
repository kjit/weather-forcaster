package com.github.kjit.wf.engine;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ForecastService {
    
    public Weather fetchCurrentWeatherFor(Location location) {
        Weather w = new Weather(4d, 32, 4, 20, Direction.N, 32, location, LocalDateTime.now());
        return w;
    }

    public Weather fetchAfrica() {
        Weather w = new Weather(43d, 32, 4, 20, Direction.N, 32, new Location(BigDecimal.valueOf(32d), BigDecimal.valueOf(12d), "Africa"), LocalDateTime.now());
        return w;
    }
    
}
