import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Objeto extends Remote{
	public boolean isHeldByThread() throws RemoteException;
	public void lock() throws RemoteException;
	public void unlock() throws RemoteException;
	public boolean isLocked() throws RemoteException;
}