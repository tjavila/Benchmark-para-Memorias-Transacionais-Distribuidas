//import java.rmi.Naming; 
import java.util.Random;

public class ObjetoClient{
	public ObjetoClient(int n_trans, int n_obj, int rw, int n_mach, long n_iter){

		for(int i = 0; i < n_trans; i++){
			Random random = new Random();
			Transacao trans = new Transacao(random.nextInt(4), n_obj, n_mach, n_iter);
			trans.acesso();
		}

	}

	public static void main(String[] args){
		//System.out.println(Integer.parseInt(args[5]));

		for(int i = 0; i < Integer.parseInt(args[5]); i++){
			long start = System.currentTimeMillis(); 
			new ObjetoClient(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]) );
			long end = System.currentTimeMillis();

			System.out.println(Long.toString(end - start));

		}

		System.exit(0);
	}
}