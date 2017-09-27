package AP3.Suporte;

import java.util.Scanner;

/**
 * Created by filip on 20/05/2017.
 */
public class Ticket {
    int codigo;
    String titulo;
    String descricao;
    String grauPrioridade;
    String status;
    Person pessoa = new Person();

    void  addChamado() {
        Scanner tc = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Codigo: " );
        this.codigo = tc.nextInt();
        System.out.println("Título: ");
        tc.nextLine();
        this.titulo = tc.nextLine();
        System.out.println("Descrição: ");
        this.descricao = tc.nextLine();
        System.out.println("Prioridade: ");
        this.grauPrioridade = tc.next();
        System.out.println("Status: ");
        tc.nextLine();
        this.status = tc.nextLine();
        System.out.println("Pessoa: ");
        this.pessoa.nome = tc.nextLine();
        System.out.println("Matriula: ");
        this.pessoa.matricula = tc.next();
        System.out.println("Email: ");
        this.pessoa.email = tc.next();
    }

    void verChamado() {
        System.out.println("------------------");
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Título: " + this.titulo);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Prioridade: " + this.grauPrioridade);
        System.out.println("Status: " + this.status);
        System.out.println("Pessoa: " + this.pessoa.nome);
        System.out.println("Matriula: " + this.pessoa.matricula);
        System.out.println("Email: " + this.pessoa.email);
    }

    void alterarStatus() {
        Scanner tc = new Scanner(System.in);
        System.out.println("Novo status do ticket: ");
        this.status = tc.nextLine();
    }

    void alterarPrioridade() {
        Scanner tc = new Scanner(System.in);
        System.out.println("Novo nível de prioridade: ");
        this.grauPrioridade = tc.next();

    }
}
