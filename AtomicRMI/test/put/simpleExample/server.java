package put.simpleExample;

import java.rmi.registry.*;
import java.rmi.Naming; 

public class server{
	public static void main(String [] args) throws Exception{
		System.setProperty("java.rmi.server.hostname", "127.0.0.1");
		LocateRegistry.createRegistry(1099);

		Account a = new AccountImpl(1000);
		Account b = new AccountImpl(500);

		Naming.rebind("rmi://127.0.0.1:"+ Integer.toString(1099) + "/A", a); 
		Naming.rebind("rmi://127.0.0.1:"+ Integer.toString(1099) + "/B", b); 

		System.out.println("Server ok");


	}
}