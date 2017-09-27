package AP3.Pizzaria;

import java.util.Scanner;

/**
 * Created by filip on 29/05/2017.
 */
public class Pizza {
    private double valorTotal = 0;
    private int saborDoPedido[] = {0,0,0,0};
    public String sabores[] = {"Calabresa","Mussarela","Camarão","4 Queijos","Bacon","Franfo","Strogonoff","Portuguesa"};
    public double valores[] = {0,25,20,40,25,30,25,35,25};
    public int qtd = 0;

    public void listarSabores() {
        System.out.println("------*-----*-----");
        System.out.println("1- Calabresa - R$25");
        System.out.println("2- Mussarela - R$20");
        System.out.println("3- Camarão - R$40");
        System.out.println("4- 4 Queijos - R$25");
        System.out.println("5- Bacon - R$30");
        System.out.println("6- Frango - R$25");
        System.out.println("7- Strogonoff - R$35");
        System.out.println("8- Portugesa - R$25");
        System.out.println("----***----***----");
    }

    public void pedidrPizza() {
        Scanner tc = new Scanner(System.in);
        System.out.println("-----------------");
        System.out.println("Numero de sabores (max. quatro): ");
        this.qtd = tc.nextInt();
        if (this.qtd<1 || this.qtd>4) {
            do {
                System.out.println("Numero inválido. Digite novamente.");
            } while (this.qtd<1 || this.qtd>4);
        }
        for (int i=0;i<4;i++) {
            System.out.println("Numero do Sabor " + (i+1) + ":");
            this.saborDoPedido[i] = tc.nextInt();
            if (this.qtd == (i+1)) {
                break;
            }
        }
        this.valorTotal += (valores[saborDoPedido[0]]/qtd) + (valores[saborDoPedido[1]]/qtd) + (valores[saborDoPedido[2]]/qtd) + (valores[saborDoPedido[3]]/qtd);
        System.out.println("Pizza montada com sucesso.");
    }

    public void mostrarValor() {
        System.out.println("Valor total: " + this.valorTotal);
    }
}
