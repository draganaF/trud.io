package com.sbnz.trud.io.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Notification;
import com.sbnz.trud.io.service.contracts.INotificationService;
import com.sbnz.trud.io.sockets.SocketsModule;

@Service
public class NotificationService implements INotificationService {
	private SocketsModule sockets;
	
	@Autowired
	public NotificationService(SocketsModule sockets) {
		this.sockets = sockets;
	}
	@Override
	public void sendNotification(Notification notification) {
		sockets.brodcast(String.valueOf(notification.getId()), notification);
		
	}
}
