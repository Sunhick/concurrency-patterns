package com.pattern.marker;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Math extends Remote {
	int add(int a, int b) throws RemoteException;
}
