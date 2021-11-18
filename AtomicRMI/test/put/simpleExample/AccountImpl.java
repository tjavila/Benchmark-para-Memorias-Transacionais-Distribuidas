package put.simpleExample;

import java.rmi.RemoteException;
import java.rmi.Remote;
import put.atomicrmi.optsva.objects.TransactionalUnicastRemoteObject;


public class AccountImpl extends TransactionalUnicastRemoteObject implements Account{

	private int balance = 0;

	public AccountImpl(int amount) throws RemoteException  
    { 
    	balance = amount;
    } 

	public int getBalance() throws RemoteException{
		return balance;
	}

	public void deposit(int amount) throws RemoteException{
		balance += amount;
	}

	public void withdraw(int amount) throws RemoteException{
		balance -= amount;
	}

	public void reset() throws RemoteException{
		balance = 0;
	}
}
