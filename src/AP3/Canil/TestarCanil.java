package AP3.Canil;

import java.util.Scanner;

/**
 * Created by filip on 30/05/2017.
 */
public class TestarCanil {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        Caes caozinho[] = new Caes[20];
        int ope;
        int qtd = 0;

        do {
            System.out.println("--- Menu ---");
            System.out.println("1- Registrar cão");
            System.out.println("2- Total de caes");
            System.out.println("3- Caes castrados");
            System.out.println("4- Caes vacinados");
            System.out.println("5- Mostrar Caes");
            System.out.println("6- Sair");
            ope = tc.nextInt();
            switch (ope) {
                case 1: {
                    if (qtd==20) {
                        System.out.println("AP3.Canil lotado.");
                    }
                    Caes caoope = new Caes();
                    caoope.registrar();
                    caozinho[qtd] = caoope;
                    qtd++;
                    break;
                }
                case 2: {

                    System.out.println("Total de caes: " + qtd);
                    break;
                }
                case 3: {
                    Caes caoope = new Caes();
                    caoope.contarCaesEsterilizados(caozinho, qtd);
                    break;
                }
                case 4: {
                    Caes caoope = new Caes();
                    caoope.contarCaesVacinas(caozinho, qtd);
                    break;
                }
                case 5: {
                    Caes caoope = new Caes();
                    caoope.mostrarCaes(caozinho, qtd);
                    break;
                }
                case 6: {
                    break;
                }
            }
        } while (ope!=6);
    }
}
