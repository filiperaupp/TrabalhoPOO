package AP3.Pizzaria;

import java.util.Scanner;

/**
 * Created by filip on 29/05/2017.
 */
public class TestePizza {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        Pizza minhapizza = new Pizza();
        int ope;
        double valortotal = 0;

        do {
            System.out.println("-----   Menu -----");
            System.out.println("1- Lista sabores");
            System.out.println("2- Pedir/acrescentar pizza");
            System.out.println("3- Valor total");
            System.out.println("4- Sair");
            ope = tc.nextInt();
            switch (ope) {
                case 1: {
                    minhapizza.listarSabores();
                    break;
                }
                case 2: {
                    minhapizza.pedidrPizza();
                    break;
                }
                case 3: {
                    minhapizza.mostrarValor();
                    break;
                }
                case 4: {
                    break;
                }
            }

        } while (ope != 4);
    }
}
