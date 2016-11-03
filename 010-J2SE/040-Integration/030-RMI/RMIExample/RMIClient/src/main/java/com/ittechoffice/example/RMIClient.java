package com.ittechoffice.example;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException{
        String name = "Service";
        Registry registry = LocateRegistry.getRegistry(8080);
        Service service = (Service) registry.lookup(name);
        Message message = new Message();
        message.setContent("From Client Message");
        Message serverMessage = service.doSothing(message);
        System.out.println(serverMessage.getContent());
	}
}
