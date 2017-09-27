package AP3.TrabalhoG2;

import java.util.Scanner;

/**
 * Created by filip on 13/06/2017.
 */
public class ListaEmails {
    Scanner tc = new Scanner(System.in);
    public Email inicio;
    public Email fim;
    public int qtd;

    public void addEmail() {
        int ope = 0;
        do {
            Email emailzinho = new Email();
            emailzinho.add();
            this.qtd++;
            if (this.inicio==null) {
                this.inicio = emailzinho;
                this.fim = emailzinho;
            }
            else {
                this.fim.proximo = emailzinho;
                this.fim = emailzinho;
            }
            System.out.println("Deseja adicionar outro email?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            ope = tc.nextInt();
        }while(ope!=2);
    }

    public void mostrarEmails() {
        Email aux = this.inicio;
        int perma = 1;
        do {
            System.out.println(aux.email);
            if (aux.proximo==null) {
                break;
            }
            aux = aux.proximo;
        } while (perma==1);
    }
}
