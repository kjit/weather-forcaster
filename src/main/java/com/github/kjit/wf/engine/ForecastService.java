package com.github.kjit.wf.engine;

import com.github.kjit.wf.source.JsonDataSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class ForecastService {
    private LocationService locationService;
    private JsonDataSource jsonDataSource;
    
    ForecastService(LocationService locationService, JsonDataSource jsonDataSource) {
        this.locationService = locationService;
        this.jsonDataSource = jsonDataSource;
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

    public Weather fetchWeatherFor(LocalDate date, String location) {
        return jsonDataSource.getWeatherFor(date).stream().filter(weather -> location.equals(weather.location().name()))
                .findFirst()
         .orElse(null);
        
    }
    
}
