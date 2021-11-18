package put.benchmark;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.registry.*;
import java.rmi.Naming;
import put.atomicrmi.optsva.Transaction;
import put.atomicrmi.optsva.objects.TransactionalUnicastRemoteObject;
import java.util.Random;

public class ObjetoClient{
	public ObjetoClient(int n_trans, int n_obj, int rw, int n_mach, int n_iter) throws RemoteException, NotBoundException, MalformedURLException{

		Random random = new Random();

		//long read = (long)((double)n_obj * (double)((double)rw/(double)100));
		//long write = n_obj - read;

		//System.out.println("leitura - " + Long.toString(  read * n_trans) );
		//System.out.println("escrita - " + Long.toString(  write * n_trans) );

		Transaction []array_trans = new Transaction[n_trans];
		Objeto []array_obj = new Conta[n_obj];
		for(int i = 0; i < n_trans; i++){
			array_trans[i] = new Transaction();
		}

		for(int i = 0; i < n_trans; i++){
			//int porta = (random.nextInt(n_mach) + 15555);
			for(int j = 0; j < n_obj; j++){
				try{
					array_obj[j] = new Conta(random.nextInt(10000));
				}catch(RemoteException e){ new ObjetoClient(n_trans, n_obj, rw, n_mach, n_iter); return; }
			}

			array_trans[i].start();
			//long w = write;
			for(int j = 0; j < n_obj; j++){
				Random random2 = new Random();
				int op = random2.nextInt(4);
				try{
					switch(op){
						case 0: array_obj[i].deposito(random.nextInt(10000));
						break;
						case 1: array_obj[i].saque(random.nextInt(10000));
						break;
						case 2: 
							int c = random.nextInt(n_obj);
							if(c!=i){
								Conta c2 = (Conta) array_obj[c];
								array_obj[i].transferencia(random.nextInt(10000), c2);
							}
						break;	
						case 3: //System.out.println("Seu saldo: " + array_obj[i].le_saldo());
							array_obj[i].le_saldo();
						break;
					}
				}catch(RemoteException ex){
					//System.out.println(ex);
				}
			}

			array_trans[i].commit();
		}

		return;

	}

	public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException{
		for(int c = 0; c < Integer.parseInt(args[5]); c++){
			long start = System.currentTimeMillis(); 
			new ObjetoClient(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]) );
			long end = System.currentTimeMillis();

			System.out.println("Tempo: " + Long.toString(end - start));
		}

		System.exit(0);
	}
}