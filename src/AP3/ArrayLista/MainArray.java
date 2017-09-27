package AP3.ArrayLista;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by filip on 12/06/2017.
 */
public class MainArray {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        StringList sl = new StringList();
        ArrayList <String> meuarray = new ArrayList<String>();
        String string;
        int indice;
        int ope=0;
        do {
            System.out.println("--Menu--");
            System.out.println("1- Adicionar String");
            System.out.println("2- Remover String");
            System.out.println("3- Tamanho da lista");
            System.out.println("4- Retornar o tamanho de uma String");
            System.out.println("5- Soma de todas as Strings");
            System.out.println("6- Alterar String");
            System.out.println("7- Adicionar no final");
            System.out.println("8- Todas as Strings em maiúsuclo");
            System.out.println("9- Somente Strings com determinada letra");
            System.out.println("10- Sair");
            ope = tc.nextInt();
            switch (ope) {
                case 1: {
                    System.out.println("String: ");
                    string = tc.next();
                    System.out.println("Posição: ");
                    indice = tc.nextInt();
                    if (indice>meuarray.size()) {
                        do {
                            System.out.println("Indice maior que array. Digite novamente.");
                            System.out.println("Posição: ");
                            indice = tc.nextInt();
                        } while (indice>meuarray.size());
                    }
                    sl.addNoLocal(string,indice,meuarray);
                    break;
                }
                case 2: {
                    System.out.println("String para remover:");
                    string = tc.next();
                    sl.remover(string,meuarray);
                    break;
                }
                case 3: {
                    sl.mostrarTamanhoLista(meuarray);
                    break;
                }
                case 4: {
                    System.out.println("Posição da String: ");
                    indice = tc.nextInt();
                    int tamanho = sl.tamanhoString(meuarray,indice);
                    System.out.println("Tamanho da String: " + tamanho);
                    break;
                }
                case 5: {
                    int soma;
                    soma = sl.somaStrings(meuarray);
                    System.out.println("Soma total: " + soma);
                    break;
                }
                case 6: {
                    boolean teste;
                    System.out.println("Nova String: ");
                    string = tc.next();
                    System.out.println("Indice para troca: ");
                    indice = tc.nextInt();
                    teste = sl.alterarString(meuarray,string,indice);
                    if (teste==true) {
                        System.out.println("Troca realizada.");
                    }
                    else {
                        System.out.println("Erro.");
                    }
                    break;
                }
                case 7: {
                    sl.addNoFim(meuarray);
                    break;
                }
                case 8: {
                    sl.mostrarMaiuscula(meuarray);
                    break;
                }
                case 9: {
                    char letra;
                    System.out.println("Letra inicial: ");
                    letra = tc.next().charAt(0);
                    sl.mostrarComLetraInicial(meuarray,letra);
                    break;
                }
                case 10: {
                    break;
                }
            }
        } while (ope!=10);
    }
}
