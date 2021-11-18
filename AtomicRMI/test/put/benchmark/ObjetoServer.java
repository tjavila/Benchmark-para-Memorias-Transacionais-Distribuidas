package put.benchmark;

import java.rmi.Naming; 
import java.rmi.registry.*;
import java.rmi.RemoteException;
import java.util.Random;

public class ObjetoServer{
	public ObjetoServer(int arg, int n_obj){
		try{
			System.setProperty("java.rmi.server.hostname", "127.0.0.1");
			
			LocateRegistry.createRegistry(15555 + arg);
			//System.out.println("Server " + arg);

			Objeto []obj_array = new Conta[n_obj]; 

			for(int i = 0; i < n_obj; i++){
				Random random = new Random();
				obj_array[i] = new Conta(random.nextInt(10000));
				Naming.rebind("rmi://127.0.0.1:"+ Integer.toString(15555 + arg) + "/" + Integer.toString(i), obj_array[i]); 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		new ObjetoServer(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	}
}