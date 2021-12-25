package com.example.government;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class GovernmentApplication {

  @PostConstruct
  public void setDefaultTimezone() {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
  }
  public static void main(String[] args) {
    SpringApplication.run(GovernmentApplication.class, args);
//    //起socket服务
//    SocketServer server = new SocketServer();
//    server.startSocketServer(8088);
  }
}
