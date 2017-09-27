package AP3.Canil_G2;

import java.util.Scanner;

/**
 * Created by filip on 19/06/2017.
 */
public class Main_Canil {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        CanilG2 meucanil = new CanilG2();
        int ope;
        do {
            System.out.println("--- Menu ---");
            System.out.println("1- Cadastrar cao");
            System.out.println("2- Remover cao");
            System.out.println("3- Listar caes");
            System.out.println("4- Sair");
            meucanil.mostrarInformacoes();
            ope = entrada.nextInt();
            switch (ope) {
                case 1: {
                    meucanil.cadastrar();
                    break;
                }
                case 2: {
                    meucanil.remover();
                    break;
                }
                case 3: {
                    meucanil.listar();
                    break;
                }
                default: {
                    System.out.println("Numero inválido.");
                }
            }

        } while (ope!=4);
    }
}
