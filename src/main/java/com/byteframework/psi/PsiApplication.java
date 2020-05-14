package com.byteframework.psi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.byteframework.psi.mapper"})
public class PsiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PsiApplication.class, args);
    }

}
