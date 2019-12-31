package com.bob.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
 * @Author  :bob
 * @Date    :Created in 17:36 2019/12/31
 * @Description:
 *
 */
@SpringBootApplication
// 开启通用注解扫描
@MapperScan(basePackages = {"com.bob.sys.mapper"})
public class MyWarehouseApp extends SpringBootServletInitializer {
    /**
     * 实现SpringBootServletInitializer可以让spring-boot项目在web容器中运行
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(this.getClass());
        return super.configure(builder);
    }

    public static void main(String[] args) {
        SpringApplication.run(MyWarehouseApp.class, args);

    }
}
