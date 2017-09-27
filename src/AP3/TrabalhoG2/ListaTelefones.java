package AP3.TrabalhoG2;

import java.util.Scanner;

/**
 * Created by filip on 13/06/2017.
 */
public class ListaTelefones {
    Scanner tc = new Scanner(System.in);
    public Fone inicio;
    public Fone fim;
    public int qtd;

    public void addFone() {
        int ope = 0;
        do {
            Fone fonezinho = new Fone();
            fonezinho.add();
            this.qtd++;
            if (this.inicio==null) {
                this.inicio = fonezinho;
                this.fim = fonezinho;
            }
            else {
                this.fim.proximo = fonezinho;
                this.fim = fonezinho;
            }
            System.out.println("Deseja adicionar outro telefone?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            ope = tc.nextInt();
        }while(ope!=2);
    }

    public void mostrarFones() {
        Fone aux = this.inicio;
        int perma = 1;
        do {
            System.out.println(aux.telefone);
            if (aux.proximo==null) {
                break;
            }
            aux = aux.proximo;
        } while (perma==1);
    }
}
