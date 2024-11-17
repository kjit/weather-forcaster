package com.github.kjit.wf.engine;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    public Location getLoco(String locationName) {
        
        return new Location(BigDecimal.valueOf(33.4d), BigDecimal.valueOf(68), locationName);
    }

}
