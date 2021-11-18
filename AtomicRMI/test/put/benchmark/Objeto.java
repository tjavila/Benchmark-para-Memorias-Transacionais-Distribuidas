package put.benchmark;

import put.atomicrmi.optsva.Access;
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Objeto extends Remote {
	@Access(Access.Mode.READ_ONLY) int get(int num) throws RemoteException;
	@Access(Access.Mode.WRITE_ONLY) void set(int mem, int num)throws RemoteException;
	@Access(Access.Mode.WRITE_ONLY) public double getSaldo() throws RemoteException;
	@Access(Access.Mode.WRITE_ONLY) public void setSaldo(double saldo) throws RemoteException;
	@Access(Access.Mode.WRITE_ONLY) boolean saque(double valor) throws RemoteException;
	@Access(Access.Mode.WRITE_ONLY) boolean deposito(double valor) throws RemoteException;
	@Access(Access.Mode.WRITE_ONLY) boolean transferencia(double valor, Conta c2) throws RemoteException;
	@Access(Access.Mode.WRITE_ONLY) double le_saldo() throws RemoteException;
}