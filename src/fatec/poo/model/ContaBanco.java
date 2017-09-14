package fatec.poo.model;

public class ContaBanco {
    private int numero;
    private double saldo;

    public ContaBanco(int num, double sal){
        numero = num;
        saldo = sal;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void sacar(double valSaque){
        saldo -= valSaque; // mesma coisa que: saldo = saldo - valSaque
        
    }
    
    public void depositar(double valDeposito){ //mesma coisa que: saldo = saldo + valDeposito
        saldo += valDeposito;
    }
}