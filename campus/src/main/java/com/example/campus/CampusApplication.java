package com.example.campus;

import netty.NettyWebSocketServer;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(annotationClass = Mapper.class, basePackages = "com.example.campus.dao")
@EnableTransactionManagement
public class CampusApplication {



    public static void main(String[] args) {
        SpringApplication.run(CampusApplication.class, args);
        NettyWebSocketServer nettyServer = new NettyWebSocketServer();
        nettyServer.start(9090);
    }

}
