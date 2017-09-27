package RevisaoPOO.ContaCorrente;

import java.util.Scanner;

/**
 * Created by filip on 16/08/2017.
 */
public class ContaCorrente {
    private double saldo = 0;
    private String numeroConta;
    private String senha;
    private double limite;
    public Cliente titular = new Cliente();

    public void mostrarSaldo() {
        System.out.println("Saldo da conta: " + this.saldo);
    }

    public void criarConta(){
        Scanner tc = new Scanner(System.in);
        System.out.println("Nome do titular: ");
        this.titular.nome = tc.next().toUpperCase();
        System.out.println("CPF: ");
        this.titular.cpf = tc.next();
        System.out.println("Idade: ");
        this.titular.idade = tc.nextInt();
        if (titular.idade>60) {
            this.limite = 300;
        }else{
            this.limite = 200;
        }
        System.out.println("Numero da conta: ");
        this.numeroConta = tc.next();
        System.out.println("Senha: ");
        this.senha = tc.next();
    }

    public boolean compararConta(ContaCorrente x){
        if (this.titular.cpf.equals(x.titular.cpf) && this.numeroConta.equals(x.numeroConta)) {
            return true;
        }else{
            return false;
        }
    }



    public boolean depositar(double valor) {
        if (valor>0) {
            this.saldo += valor;
            return true;
        }else{
            return false;
        }
    }

    public boolean sacar(double valor){
        if (valor>0 && saldo+limite>valor) {
            this.saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

    public boolean transferir(ContaCorrente x, double valor){
        if (valor>0) {
            this.sacar(valor);
            x.depositar(valor);
            return true;
        }else{
            return false;
        }
    }


}
