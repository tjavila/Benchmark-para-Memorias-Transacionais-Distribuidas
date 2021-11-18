# Benchmark-para-Memorias-Transacionais-Distribuidas

Versão RMI Puro:

-- EXECUTAR BENCHMARK --

 - Executar clienteServer.sh;

 São adicionados parâmetros na execução do script clientServer.sh. Os parâmetros são os seguintes:

 	- arg1 = Numero de transações para cada cliente;
 	- arg2 = Numero de objetos acessados em cada transação;
 	- arg3 = percentual de escritas;
 	- arg4 = Numero máximo de máquinas que cada cliente pode acessar;
 	- arg5 = Numero de clientes criados;
 	- arg6 = Numero de servidores criados;
 	- arg7 = Numero de objetos criados por servidor;
 	- arg8 = Numero de iterações entre cada transação;
 	- arg9 = Numero de repetições do benchmark (cada cliente);
  
 -- COMANDOS --

 Exemplo para executar benchmark: ./clientServer.sh > out.txt
 Gerando a tabela: java TabelaCreate out.txt
 Arquivos out.xlsx gerado, pronto para ser importado em formato tabela


Versão ATOMIC RMI:

-- COMPILAR --

 - Instalar Apache ANT;
 - Executar Apache ANT com comando "ant compile";

 -- EXECUTAR BENCHMARK --

 - Executar clienteServer2.sh dentro do diretório "/bin/";
 

 -- CONFIGURAÇÃO BENCHMARK --

 São adicionados parâmetros na execução do script clientServer2.sh. Os parâmetros são os seguintes:

 	- arg1 = Numero de transações para cada cliente;
 	- arg2 = Numero de objetos acessados em cada transação;
 	- arg3 = percentual de escritas;
 	- arg4 = Numero máximo de máquinas que cada cliente pode acessar;
 	- arg5 = Numero de clientes criados;
 	- arg6 = Numero de servidores criados;
 	- arg7 = Numero de objetos criados por servidor;
 	- arg8 = Numero de iterações entre cada transação;
 	- arg9 = Numero de repetições do benchmark (cada cliente);


 -- COMANDOS --

 Exemplo para executar benchmark: ./clientServer2.sh > out.txt
 Gerando a tabela: java TabelaCreate out.txt
 Arquivos out.xlsx gerado, pronto para ser importado em formato tabela
