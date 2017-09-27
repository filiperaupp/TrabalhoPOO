package AP3.TrabalhoG2;

import java.util.Scanner;

/**
 * Created by filip on 11/06/2017.
 */
public class Pessoa {
    Scanner tc = new Scanner(System.in);
    String CSI = "\u001B[";
    public String nome;
    public String profissao;
    public String endereco;
    public ListaEmails meusemails = new ListaEmails();
    public ListaTelefones meustelefones = new ListaTelefones();
    public Pessoa proximo;
    public Pessoa anterior;

    public void ler() {
        System.out.println("Nome: ");
        this.nome = tc.next();
        System.out.println("Profissao: ");
        tc.nextLine();
        this.profissao = tc.nextLine();
        System.out.println("Endereço: ");
        this.endereco = tc.nextLine();
        meusemails.addEmail();
        meustelefones.addFone();
    }

    public void mostrarDados() {
        System.out.print (CSI + "34" + "m");
        System.out.println("Nome: " + (CSI+"m") + this.nome);
        System.out.print (CSI + "34" + "m");
        System.out.println("Profissão: " + (CSI+"m") + this.profissao);
        System.out.print (CSI + "34" + "m");
        System.out.println("Endereço: " + (CSI+"m") + this.endereco);
        System.out.print (CSI + "34" + "m");
        System.out.println("Email(s):" + (CSI+"m"));
        meusemails.mostrarEmails();
        System.out.print (CSI + "34" + "m");
        System.out.println("Telefone(s): " + (CSI+"m") );
        meustelefones.mostrarFones();
    }
}