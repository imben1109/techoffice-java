package com.ittechoffice.example;

import java.rmi.RemoteException;

public class ServiceImpl implements Service{
	
	public Message doSothing(Message message) throws RemoteException {
		System.out.println(message.getContent());
		System.out.println("Do Somethig");
		Message serverMessage = new Message();
		serverMessage.setContent("From Server Message");
		return serverMessage;
	}

}
