package AP3.Agenda;

import java.util.Scanner;

/**
 * Created by filip on 30/05/2017.
 */
public class TesteAgenda {
    public static void main(String[] args) {
        String seleccontato = "teste";
        AgendaSystem minhaagenda = new AgendaSystem();
        int ope;
        Scanner tc = new Scanner(System.in);
        do {
            System.out.println("---- Menu ----");
            System.out.println("1- Adicionar contato");
            System.out.println("2- Remover contato");
            System.out.println("3- Editar contato");
            System.out.println("4- Mostrar TODOS os contatos");
            System.out.println("5- Mostrar contato ESPECÌFICO");
            System.out.println("6- Sair");
            ope = tc.nextInt();
            switch (ope) {
                case 1: {
                    Contato contatinho = new Contato();
                    contatinho.ler();
                    minhaagenda.addContato(contatinho);
                    break;
                }
                case 2: {
                    System.out.println("Nome do contato para remoção: ");
                    tc.nextLine();
                    seleccontato = tc.nextLine();
                    minhaagenda.removerContato(seleccontato);
                    break;
                }
                case 3: {
                    System.out.println("Nome do contato para edição: ");
                    seleccontato = tc.next();
                    minhaagenda.editarContato(seleccontato);
                    break;
                }
                case 4: {
                    minhaagenda.mostrarContatos();
                    break;
                }
                case 5: {
                    System.out.println("Nome do contato: ");
                    tc.nextLine();
                    seleccontato = tc.nextLine();
                    minhaagenda.mostrarOnlyOne(seleccontato);
                    break;
                }
                case 6: {
                    break;
                }
            }
        } while (ope!=6);
    }
}
