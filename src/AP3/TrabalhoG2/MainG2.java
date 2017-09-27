package AP3.TrabalhoG2;

import java.util.Scanner;

/**
 * Created by filip on 11/06/2017.
 */
public class MainG2 {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        String CSI = "\u001B[";
        String nomecontato;
        MinhaLista meuscontatos = new MinhaLista();
        int ope;
        do {
            System.out.print (CSI + "31" + "m");
            System.out.println("---- Menu ----");
            System.out.print (CSI + "33" + "m");
            System.out.println("1- Adicionar contato");
            System.out.println("2- Remover contato");
            System.out.println("3- Editar contato");
            System.out.println("4- Mostrar contato: TODOS");
            System.out.println("5- Mostrar contato: ESPECÌFICO");
            System.out.println("6- Informações Gerais");
            System.out.println("7- Sair");
            System.out.print (CSI + "m");
            ope = tc.nextInt();
            switch (ope) {
                case 1: {
                    Pessoa pessoinha = new Pessoa();
                    pessoinha.ler();
                    meuscontatos.addContato(pessoinha);
                    System.out.println("Contato adicionado com sucesso.");
                    break;
                }
                case 2: {
                    System.out.println("Nome do contato para remoção: ");
                    tc.nextLine();
                    nomecontato = tc.nextLine();
                    meuscontatos.removerContato(nomecontato);
                    System.out.println("Contato removido.");
                    break;
                }
                case 3: {
                    System.out.println("Nome do contato para edição: ");
                    nomecontato = tc.next();
                    meuscontatos.editarContato(nomecontato);
                    System.out.println("Contato Editado");
                    break;
                }
                case 4: {
                    meuscontatos.mostrarTodos();
                    break;
                }
                case 5: {
                    System.out.println("Nome do contato: ");
                    tc.nextLine();
                    nomecontato = tc.nextLine();
                    meuscontatos.mostrarApenasUm(nomecontato);
                    break;
                }
                case 6: {
                    meuscontatos.informacoesGerais();
                    break;
                }
                case 7: {
                    break;
                }
                default: {
                    System.out.println("Numero inválido.");
                    break;
                }
            }
        } while (ope!=7);
    }
}