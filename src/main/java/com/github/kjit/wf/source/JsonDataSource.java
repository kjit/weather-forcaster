package com.github.kjit.wf.source;

import com.github.kjit.wf.engine.Weather;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class JsonDataSource implements DataSource {

    private final ObjectMapper objectMapper; // = new ObjectMapper();
    
    public JsonDataSource(ObjectMapper objectMapper) {
        objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper = objectMapper;
    }
    
    public List<Weather> getWeatherFor(LocalDate date) {
            try {
                File jsonData = new File(generateFileName(date));
                System.out.println(jsonData.getAbsolutePath());
                
                List<Weather> weatherList = objectMapper.readValue(jsonData,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Weather.class));

                return weatherList;    
            } catch (IOException e) {
                e.printStackTrace();
                return List.of();
            }
    }

    private String generateFileName(LocalDate date) {
        return String.format("data/results_%s.json", DateTimeFormatter.ofPattern("uuuu_MM_dd").format(date));
    }
    

}
