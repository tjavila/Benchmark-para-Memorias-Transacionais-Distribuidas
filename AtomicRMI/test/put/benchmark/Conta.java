package put.benchmark;

import java.rmi.RemoteException;
import java.rmi.Remote;
import put.atomicrmi.optsva.objects.TransactionalUnicastRemoteObject;

public class Conta extends TransactionalUnicastRemoteObject implements Objeto{
    private double saldo;
    private int mem;
	private int mem2;
	private int mem3;
	private int mem4;

	protected Conta(double saldo) throws RemoteException{
    	this.saldo = saldo;
    	mem = 0;
		mem2 = 0;
		mem3 = 0;
		mem4 = 0;
	}

	public void set(int mem, int num) throws RemoteException{
		//System.out.println("Escrita memoria");
		switch(num){
			case 0: this.mem = mem;
			break;
			case 1: this.mem2 = mem2;
			break;
			case 2: this.mem3 = mem3;
			break;
			default: this.mem4 = mem4;
			break;
		}
	}
	public int get(int num_att) throws RemoteException{
		//System.out.println("Leitura memoria");
		switch(num_att){
			case 0: return mem;

			case 1: return mem2;

			case 2: return mem3;

			default: return mem4;

		}
	}

    public double getSaldo() throws RemoteException{
        return saldo;
    }

    public void setSaldo(double saldo) throws RemoteException {
        this.saldo = saldo;
    }

    public boolean saque(double valor) throws RemoteException{
        if (this.saldo < valor || this.saldo < 0)
            return false;
         else {
            this.saldo = this.saldo - valor;
            return true; 
        }
    }

    public boolean deposito(double valor) throws RemoteException {
        if(valor>0){
            this.saldo = this.saldo + valor;
            return true;
        }
        else    
            return false;
    }

	public boolean transferencia(double valor, Conta c2) throws RemoteException {
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

    public double le_saldo() throws RemoteException{
		return this.getSaldo();
    }
    
}
