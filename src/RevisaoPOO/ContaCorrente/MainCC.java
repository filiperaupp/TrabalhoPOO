package RevisaoPOO.ContaCorrente;

import java.util.Scanner;

/**
 * Created by filip on 23/08/2017.
 */
public class MainCC {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        ContaCorrente conta1 = new ContaCorrente();
        ContaCorrente conta2 = new ContaCorrente();

        conta1.criarConta();
        System.out.println("Próxima.");
        conta2.criarConta();

        if (conta1.depositar(500))
            System.out.println("Sucesso!");
        else
            System.out.println("Erro!");

        if (conta2.depositar(200))
            System.out.println("Sucesso!");
        else
            System.out.println("Erro!");

        if (conta1.sacar(1000))
            System.out.println("Sucesso");
        else
            System.out.println("Erro");

        if (conta2.sacar(100))
            System.out.println("Sucesso");
        else
            System.out.println("Erro");

        System.out.println("oi");

        conta1.mostrarSaldo();
        conta2.mostrarSaldo();
        conta1.transferir(conta2,300);
        conta1.mostrarSaldo();
        conta2.mostrarSaldo();

        if (conta1.compararConta(conta2))
            System.out.println("Contas iguais");
        else
            System.out.println("Contas diferentes");


        System.out.println(conta1.titular.nome);
        System.out.println(conta2.titular.nome);
    }
}
