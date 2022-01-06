package com.shizc.docker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
@RestController
@Slf4j
public class DockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
    }

    @Autowired
    private DataSource dataSource;

    @GetMapping("/")
    public String getDataSource() throws SQLException {
        return "mysql的Schema是" + dataSource.getConnection().getSchema();
    }
}
