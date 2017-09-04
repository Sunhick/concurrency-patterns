package com.pattern.marker;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MathRemote extends UnicastRemoteObject implements Math {

	/**
	 * Serial version uid is used to make sure that sender and receiver are using
	 * the same version of the object to serialize and de-serialize the object. IF
	 * the uid doesn't match java runtime will throw exception.
	 * 
	 * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
	 */
	private static final long serialVersionUID = 1L;

	protected MathRemote() throws RemoteException {
		super();
	}

	@Override
	public int add(int a, int b) throws RemoteException {
		System.out.println("adding " + a + ", " + b);
		return a + b;
	}

}
