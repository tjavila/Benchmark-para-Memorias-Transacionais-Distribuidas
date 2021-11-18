import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject; 
import java.util.concurrent.locks.ReentrantLock;

public class Conta extends UnicastRemoteObject implements Objeto{
	private ReentrantLock lock;
    private double saldo;

	protected Conta(double saldo) throws RemoteException{
    	super();
		lock = new ReentrantLock();
    	this.saldo = saldo;
	}


    public double getSaldo() throws RemoteException{
        return saldo;
    }

    public void setSaldo(double saldo) throws RemoteException {
        this.saldo = saldo;
    }

    boolean saque(double valor) throws RemoteException{
        if (this.saldo < valor || this.saldo < 0)
            return false;
         else {
            this.saldo = this.saldo - valor;
            return true; 
        }
    }

    boolean deposito(double valor) throws RemoteException {
        if(valor>0){
            this.saldo = this.saldo + valor;
            return true;
        }
        else    
            return false;
    }

	boolean transferencia(double valor, Conta c2) throws RemoteException {
		if (valor > 0){
			boolean retirou = this.saque(valor);
			if (retirou == false){
				return false;
			}else{
				c2.deposito(valor);
				return true;
			}
		}else{
			return false;
		}
	}

    double le_saldo() throws RemoteException{
            return this.getSaldo(); 
    }

    public boolean isHeldByThread() throws RemoteException{
		return lock.isHeldByCurrentThread();
	}
	public void lock() throws RemoteException{
		lock.lock();
	}
	public void unlock() throws RemoteException{
		lock.unlock();
	}
	public boolean isLocked() throws RemoteException{
		return lock.isLocked();
	}
    
}
