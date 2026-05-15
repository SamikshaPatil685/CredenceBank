package com.CredenceBank.CredenceBank.notification.repo;

import com.CredenceBank.CredenceBank.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification , Long> {
}
