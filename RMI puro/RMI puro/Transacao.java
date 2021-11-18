import java.rmi.Naming; 
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.ArrayDeque;

public class Transacao{
	private int op;
	private int n_obj;
	private Conta [] array_obj;
	private ArrayDeque <Integer> locks_get;
	private int read;

	public Transacao(int op, int n_obj, int n_mach, long n_iter){
		this.op = op;
		this.n_obj = n_obj;
		this.array_obj = new Conta[n_obj];
		this.locks_get = new ArrayDeque<Integer>();
	}

	public void setOp(int op){
		this.op = op;
	}
	public void setConta(int n_obj){
		this.n_obj = n_obj;
	}

	public int acesso(){
		boolean locks = true;
		while(locks){
			this.lookup();
			locks = this.commit(this.lock());
			this.unlock();
		}
		return read;
	}

	public void lookup(){
		Random random = new Random();
		for(int i = 0; i < n_obj; i++){
			try{
				array_obj[i] = new Conta(random.nextInt(10000));
				//System.out.println("Saldo da conta" + i);
				//System.out.println(array_obj[i].getSaldo());
				//array_obj[i] = (Conta) Naming.lookup("//127.0 .0.1:"+ Integer.toString(porta) + "/" + Integer.toString(i));
			}
			catch(RemoteException ex){
					System.out.println("Problema de acesso ao servidor, tentando novamente ...");
					System.out.println(ex);
				this.lookup();
				return;
			}
		}
		return;
	}

	public int lock(){
		int num_locks = 0;
		for(int i = 0; i < n_obj; i++){
			try{
				if(!array_obj[i].isLocked()){
					array_obj[i].lock();
					locks_get.add(i);
					num_locks++;
				}
			}catch(RemoteException e){
				System.out.println(e);
			}
		}
		return num_locks;
	}

	public void unlock(){
		int i = 0;
		try{
			while(!locks_get.isEmpty()){
				i = locks_get.poll();
				array_obj[i].unlock();
			}

		}catch(RemoteException e){
			System.out.println(e);
		}
	}

	public boolean commit(int num_locks){
		Random random = new Random();
		if(num_locks == n_obj){
			System.out.println("Transacao efetuada!");
			for(int i = 0; i < n_obj; i++){
				try{
					switch(op){
						case 1: array_obj[i].deposito(random.nextInt(1000));
						break;
						case 2: array_obj[i].saque(random.nextInt(1000));
						break;
						case 3: 
							int c = random.nextInt(n_obj);
							if(c!=i){
								array_obj[i].transferencia(random.nextInt(1000), array_obj[c]);
							}
							break;	
						case 4: array_obj[i].le_saldo();
						break;
		
					}
				}catch(RemoteException ex){
					System.out.println(ex);
				}
			}

			return false;
		}else{
			System.out.println("Transacao abortada... Tentando novamente ...");
			return true;
		} 
	}
}