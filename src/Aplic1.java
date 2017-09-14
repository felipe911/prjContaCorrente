import fatec.poo.model.ContaBanco;
import java.util.Scanner;

public class Aplic1 {

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
       
        int opcao, numConta, qtdContas, c;
        double saldoConta, valSaque;
        
        System.out.println("Digite quantas contas serão cadastradas: ");
        qtdContas = S.nextInt();
        
        ContaBanco[] Banco = new ContaBanco[qtdContas];
        
        for(c = 0 ; c < Banco.length ; c++){
            System.out.println("Digite o numero da conta: ");
            numConta = S.nextInt();
            System.out.println("Digite o saldo dessa conta: ");
            saldoConta = S.nextDouble();
            
            Banco[c] =  new ContaBanco(numConta, saldoConta); 
        }
        
        do{  //Menu
            System.out.println("\n\n******Banco******\n");
            System.out.println("1-Depositar");
            System.out.println("2-Sacar");
            System.out.println("3-Consultar Saldo");
            System.out.println("4-Sair");
            
            System.out.println("\nDigite a opção: ");
            opcao = S.nextInt();
            
            switch(opcao)
            {
                case 1:
                    System.out.println("Informe o numero da conta para depositar: ");
                    numConta = S.nextInt();               
                                
                    if( pesqContaBanco(Banco, numConta) == -1 ){
                        System.out.println("Conta não encontrada");
                    }else{
                        System.out.println("Digite o valor a depositar: ");
                        Banco[pesqContaBanco(Banco, numConta)].depositar(S.nextDouble());
                    }
                break;
                
                case 2:
                    System.out.println("Informe o numero da conta para sacar: ");
                    numConta = S.nextInt();               
                                
                    if( pesqContaBanco(Banco, numConta) == -1 ){
                        System.out.println("Conta não encontrada");
                    }else{
                        System.out.println("Digite o valor a sacar: ");
                        valSaque = S.nextDouble();

                        if((Banco[pesqContaBanco(Banco, numConta)].getSaldo() - valSaque) < 0){
                            System.out.println("Desculpe, você não possui esse valor em sua conta para sacar.");
                        }else{
                            Banco[pesqContaBanco(Banco, numConta)].sacar(valSaque);
                        }
                    }
                break;
                
                case 3:
                    System.out.println("Informe o número da conta para Consultar o Saldo: ");
                    numConta = S.nextInt();               

                    if( pesqContaBanco(Banco, numConta) == -1 ){
                        System.out.println("Conta não encontrada");
                    }else{
                        System.out.println("O saldo da conta é de : " + Banco[pesqContaBanco(Banco, numConta)].getSaldo());
                    }
                break;
                
            }
        }while(opcao != 4); 
    }
    
    public static int pesqContaBanco(ContaBanco[] h, int NC){
        int Cont, Resultado = -1;
        
        Cont = 0; 
        while(Cont < h.length && h[Cont].getNumero() != NC){ 
             Cont++;
        }
        if (Cont < h.length)
            Resultado = Cont;
        return(Resultado);
    }
}