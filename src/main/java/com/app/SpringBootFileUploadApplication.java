package com.app;

import java.time.LocalDate;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.services.FilesStorageService;

@SpringBootApplication
@EnableScheduling
public class SpringBootFileUploadApplication implements CommandLineRunner {
	  @Resource
	  FilesStorageService storageService;
	  
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFileUploadApplication.class, args);
		System.out.println("Hello FileUpload code===>");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		  storageService.init();
	}
	
	@Scheduled(cron = "0 */5 * ? * *")
	 public void scheduleTaskWithCronExpression() {
	     System.out.println("Example to show how cron expression can be used");
	     System.out.println("Current time is ::"+ LocalDate.now());
	 }


   
//
//    @Scheduled(fixedRate = 2000)
//    public void sayHello(){
//        System.out.println("Hello from our simple scheduled method");
//    }
}
