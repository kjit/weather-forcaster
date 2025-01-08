package com.github.kjit.wf.source;

import com.github.kjit.wf.engine.Weather;
import java.time.LocalDate;
import java.util.List;

public interface DataSource {

    List<Weather> getWeatherFor(LocalDate date);
    
}
