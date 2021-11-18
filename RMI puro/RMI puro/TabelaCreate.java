import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class TabelaCreate{
	public static void main(String[] args){
		String tabela = "";
		String escrever = "";
		try{
			Scanner in = new Scanner(new FileReader("out.xlsx"));
			while (in.hasNextLine()) {
				tabela += in.nextLine();
				tabela += '\n';
			}
			//System.out.print(tabela);
		}
		catch(FileNotFoundException e){
			System.out.println("ERRO");
		}
		try{
			Scanner in = new Scanner(new FileReader(args[0]));
			while (in.hasNextLine()) {
				escrever += in.nextLine();
				escrever += ',';
			}
			//System.out.print(tabela);
		}
		catch(FileNotFoundException e){
			System.out.println("ERRO");
		}
		try{
			FileWriter arq = new FileWriter("out.xlsx");
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.print(tabela);
			gravarArq.print(escrever);

			arq.close();
		}
		catch(IOException e){System.out.println("ERRO");}


	}
}