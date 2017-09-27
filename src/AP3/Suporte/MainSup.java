package AP3.Suporte;

import java.util.Scanner;

/**
 * Created by filip on 20/05/2017.
 */
public class MainSup {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        Ticket[] meustickets = new Ticket[10];
        Ticket novoticket = new Ticket();
        int ope, num;
        int qtd=0;

        do {
            System.out.println("----- Menu -----");
            System.out.println("1- Adicionar chamado");
            System.out.println("2- Vizualizar Ticket");
            System.out.println("3- Vizualizar chamados");
            System.out.println("4- Alterar Status");
            System.out.println("5- Alterar prioridade");
            System.out.println("6- Sair");
            ope = tc.nextInt();
            switch (ope) {
                case 1: {
                    if (qtd == 9) {
                        System.out.println("Lista de tickets cheia.");
                        break;
                    } else {
                        novoticket.addChamado();
                        meustickets[qtd] = novoticket;
                        qtd++;
                        break;
                    }
                }
                case 2: {
                    System.out.println("Numero do Ticket: ");
                    num = tc.nextInt();
                    meustickets[num].verChamado();
                    break;
                }
                case 3: {
                    int ope2;
                    System.out.println("-/-/-/-/-/-");
                    System.out.println("1- Em aberto");
                    System.out.println("2- Finalizado");
                    ope2 = tc.nextInt();
                    if (ope2 == 1) {
                        for (int i=0;i<qtd;i++) {
                            if (meustickets[i].status.equals("Em aberto")) {
                                meustickets[i].verChamado();
                            }
                        }
                    }
                    else {
                        for (int i=0;i<qtd;i++) {
                            if (meustickets[i].status.equals("Finalizado")) {
                                meustickets[i].verChamado();
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Numero do Ticket: ");
                    num = tc.nextInt();
                    System.out.println("Novo Status: ");
                    meustickets[num].alterarStatus();
                    break;
                }
                case 5: {
                    System.out.println("Numero do Ticket: ");
                    num = tc.nextInt();
                    System.out.println("Nova Prioridade: ");
                    meustickets[num].alterarStatus();
                    break;
                }
                default: {
                    break;
                }
            }
        } while (ope!=6);
    }
}
