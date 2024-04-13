package org.example.javaspringseminar2crud.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "db")
@Getter
@Setter
public class DbQueries {
    private String findAll;
    private String addUser;
    private String deleteUser;
    private String updateUser;
}
