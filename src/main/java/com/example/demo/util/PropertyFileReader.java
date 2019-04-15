package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Configuration
@PropertySource("classpath:errormsg.properties")
public class PropertyFileReader {
    @Autowired
    private Environment env;

    public String  get(String key) {
       return env.getProperty(key);
    }
}
