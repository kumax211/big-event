package com.itheima;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Slf4j
public class BigEventApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(BigEventApplication.class,args);
        log.info("启动成功");
    }
}
