package com.xiaoshu.seudcarsmallprograms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tk.mybatis.spring.annotation.MapperScan;

@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = "com.xiaoshu.seudcarsmallprograms.mapper")
public class SeudcarsmallprogramsApplication  implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SeudcarsmallprogramsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SeudcarsmallprogramsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("服务启动完成!");
    }
}
