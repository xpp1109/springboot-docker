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
import java.sql.DatabaseMetaData;
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
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        return "数据库的连接地址是: " + metaData.getURL() + ", 数据库的用户名是" + metaData.getUserName() + ",数据库的驱动是" + metaData.getDriverName();
    }
}
