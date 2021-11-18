package put.benchmark;

import java.rmi.RemoteException;
import java.rmi.Remote;
import put.atomicrmi.optsva.objects.TransactionalUnicastRemoteObject;


public class ObjetoImpl extends TransactionalUnicastRemoteObject implements Objeto{

	private int mem;
	private int mem2;
	private int mem3;
	private int mem4;

	public ObjetoImpl() throws RemoteException  
    { 
    	mem = 0;
    	mem2 = 0;
    	mem3 = 0;
    	mem4 = 0;
    } 

	public int get(int num) throws RemoteException{
		//System.out.println("Leitura memoria");
		switch(num){
			case 0: return mem;
					//break;
			case 1: return mem2;
					//break;
			case 2: return mem3;
					//break;
			default: return mem4;
		}
	}

	public void set(int mem, int num) throws RemoteException{
		//System.out.println("Escrita memoria");
		switch(num){
			case 0: this.mem = mem;
					break;
			case 1: mem2 = mem;
					break;
			case 2: mem3 = mem;
					break;
			default: mem4 = mem;
		}
	}

}
