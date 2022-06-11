package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.model.Notification;

public interface INotificationService {
	void sendNotification(Notification notification);
}
