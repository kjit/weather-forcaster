package com.github.kjit.wf.api;

import com.github.kjit.wf.engine.Direction;
import com.github.kjit.wf.engine.Location;
import com.github.kjit.wf.engine.Weather;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public Weather rootPathController() {
        
        return new Weather(2d, 12, 32, 72, Direction.N, 76, new Location(new BigDecimal(54), new BigDecimal(24), "Here"), LocalDateTime.now());
    }
    
}
