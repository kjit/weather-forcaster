package com.github.kjit.wf.api;

import com.github.kjit.wf.engine.Direction;
import com.github.kjit.wf.engine.ForecastService;
import com.github.kjit.wf.engine.Location;
import com.github.kjit.wf.engine.Weather;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    private ForecastService forecastService;
    
    public RootController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/")
    public Weather rootPathController() {
        
        return new Weather(2d, 12, 32, 72, Direction.N, 76, new Location(new BigDecimal(54), new BigDecimal(24), "Here"), LocalDateTime.now());
    }
    
    @GetMapping("/query")
    public ResponseEntity<Weather> queryController(@RequestParam String date, @RequestParam String location) {
        Weather result = forecastService.fetchWeatherFor(parseDate(date), location);
        return ResponseEntity.ofNullable(result);
    }

    private LocalDate parseDate(String date) {
        return LocalDate.parse(date);
    }
    
}
