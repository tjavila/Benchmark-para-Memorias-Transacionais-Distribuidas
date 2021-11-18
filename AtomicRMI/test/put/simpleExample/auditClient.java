package put.simpleExample;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.registry.*;
import java.rmi.Naming;
import put.atomicrmi.optsva.Transaction;
import put.atomicrmi.optsva.objects.TransactionalUnicastRemoteObject;

public class auditClient{
	public static void main(String [] args) throws RemoteException, NotBoundException, MalformedURLException{

		//System.setProperty("java.rmi.server.hostname", "127.0.0.1");

		Transaction tr = new Transaction();
		Account a = (Account) Naming.lookup("//127.0.0.1:"+ Integer.toString(1099) + "/A");
		Account b = (Account) Naming.lookup("//127.0.0.1:"+ Integer.toString(1099) + "/B");

		//AccountImpl c = new AccountImpl(1000);
		Account ta = (Account) tr.accesses(a,1);
		Account tb = (Account) tr.accesses(b,1);
		
		tr.start();
		
		int balanceA = ta.getBalance();
		int balanceB = tb.getBalance();

		tr.commit();

		System.out.println(balanceA + " " + balanceB);

	}
}