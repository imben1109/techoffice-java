package com.ittechoffice.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote{
	
	public Message doSothing(Message message) throws RemoteException;
	
}
