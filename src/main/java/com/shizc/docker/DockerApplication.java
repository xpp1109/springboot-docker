package com.shizc.docker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public String getDataSource() throws SQLException, JsonProcessingException {
        return "数据库的连接元数据信息是: " + new ObjectMapper().writeValueAsString(dataSource.getConnection().getMetaData());
    }
}
