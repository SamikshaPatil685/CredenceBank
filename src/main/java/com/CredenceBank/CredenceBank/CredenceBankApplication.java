package com.CredenceBank.CredenceBank;

import com.CredenceBank.CredenceBank.auth_Users.entity.User;
import com.CredenceBank.CredenceBank.enums.NotificationType;
import com.CredenceBank.CredenceBank.notification.dtos.NotificationDTO;
import com.CredenceBank.CredenceBank.notification.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@RequiredArgsConstructor
public class CredenceBankApplication {

	private final NotificationService notificationService;

	public static void main(String[] args) {
		SpringApplication.run(CredenceBankApplication.class, args);

	}

//	@Bean
//	CommandLineRunner runner(){
//		return  args -> {
//			NotificationDTO notificationDTO = NotificationDTO.builder()
//					.recipient("credencebank.app@gmail.com")
//					.subject("Hello Testing Email")
//					.body("Hey , This is test Email")
//					.type(NotificationType.EMAIL)
//					.build();
//
//			notificationService.sendEmail(notificationDTO , new User());
//		};
//	}

}
