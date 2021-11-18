package put.simpleExample;

import put.atomicrmi.optsva.Access;
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Account extends Remote {
	@Access(Access.Mode.READ_ONLY) int getBalance() throws RemoteException;
	@Access(Access.Mode.WRITE_ONLY) void deposit(int amount)throws RemoteException;
	@Access(Access.Mode.WRITE_ONLY) void withdraw(int amount) throws RemoteException;
	@Access(Access.Mode.ANY) void reset() throws RemoteException;
}