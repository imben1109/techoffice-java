package com.ittechoffice.example;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMISever {
	public static void main(String[] args) throws RemoteException{
        String name = "Service";
        Service service = new ServiceImpl();
        Service stub = (Service) UnicastRemoteObject.exportObject(service, 0);
        Registry registry = LocateRegistry.createRegistry(8080);
        registry.rebind(name, stub);
        System.out.println("RMI Server is running");
	}
}
