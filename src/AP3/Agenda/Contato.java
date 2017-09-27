package AP3.Agenda;

import java.util.Scanner;

/**
 * Created by filip on 30/05/2017.
 */
public class Contato {
    Scanner tc = new Scanner(System.in);
    public String nome;
    public String email;
    public String telefone;
    public Contato proximo;

    public void ler() {
        System.out.println("---Dados---");
        System.out.println("Nome: ");
        this.nome = tc.next();
        System.out.println("Email: ");
        this.email = tc.next();
        System.out.println("Telefone:");
        this.telefone = tc.next();
    }

    public void mostrar() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.println("Telefone: " + this.telefone);
    }
}
