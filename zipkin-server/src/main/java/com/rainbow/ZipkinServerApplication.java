package com.rainbow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import zipkin.server.EnableZipkinServer;
import zipkin.storage.mysql.MySQLStorage;

import javax.sql.DataSource;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
//@EnableZipkinStreamServer //开启zipkinStreamserver
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

	/**
	 * http传输的链路数据就可以存在mysql数据库中
	 * @param dataSource
	 * @return
	 */
	@Bean
	public MySQLStorage mySQLStorage(DataSource dataSource){
		return MySQLStorage.builder().datasource(dataSource).executor(Runnable::run).build();
	}
}
