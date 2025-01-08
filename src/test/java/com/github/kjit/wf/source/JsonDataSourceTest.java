package com.github.kjit.wf.source;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class JsonDataSourceTest {

    
    @Test
    void shouldReturnCorrectData() {
        
        JsonDataSource source = new JsonDataSource(new ObjectMapper());
        
        var result = source.getWeatherFor(LocalDate.of(2025, 1, 8));
        
        assertThat(result).hasSize(10);
        
    }
    
}
