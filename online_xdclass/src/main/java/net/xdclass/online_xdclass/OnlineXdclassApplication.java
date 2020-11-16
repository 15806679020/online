package net.xdclass.online_xdclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description:启动类
 * @Author: LD
 * @Date: 2020/8/19 21:15
 **/
@SpringBootApplication
@MapperScan("net.xdclass.online_xdclass.mapper")
@EnableTransactionManagement
public class OnlineXdclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineXdclassApplication.class, args);
	}

}