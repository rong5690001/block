package com.rong.block;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.rong.block", exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = {"com.rong.block.mapper","com.rong.block.dao"})
public class BlockApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlockApplication.class, args);
    }

}
