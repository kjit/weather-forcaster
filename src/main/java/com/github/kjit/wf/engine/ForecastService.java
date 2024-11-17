package com.github.kjit.wf.engine;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class ForecastService {
    private LocationService locationService;
    
    ForecastService(LocationService locationService) {
        this.locationService = locationService;
    }
    
    public Weather fetchCurrentWeatherFor(Location location) {
        Weather w = new Weather(4d, 32, 4, 20, Direction.N, 32, location, LocalDateTime.now());
        return w;
    }
    
    public Weather fetchCurrentWeatherFor(String locationName) {
        Location location = locationService.getLoco(locationName);
        Weather w = new Weather(4d, 32, 4, 20, Direction.N, 32, location, LocalDateTime.now());
        return w;
    }

    public Weather fetchAfrica() {
        Weather w = new Weather(43d, 32, 4, 20, Direction.N, 32, new Location(BigDecimal.valueOf(32d), BigDecimal.valueOf(12d), "Africa"), LocalDateTime.now());
        return w;
    }
    
}
