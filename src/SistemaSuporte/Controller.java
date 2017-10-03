package SistemaSuporte;

import java.util.Scanner;

public class Controller {
    static Scanner tc = new Scanner(System.in);

    public static void telaCliente(Object pessoaLogada){
        int operacao=0;
        Cliente clienteLogado = (Cliente) pessoaLogada;
        System.out.println("Cliente "+clienteLogado.getNome()+" logado no sistema.");
        do {
            System.out.println("Cliente está logado no sistema...");
            System.out.println("Escolha uma opção: ");

            System.out.println("1-Abrir Chamado");
            System.out.println("2-Editar Chamado");
            System.out.println("3-Mostrar meus Chamados");
            System.out.println("4-Sair da conta");
            operacao = tc.nextInt();

            switch(operacao){
                case 1:
                    System.out.println("Criando Chamado...");
                    Chamado chamado = new Chamado();

                    if(chamado.criaChamado()){
                        System.out.println("Chamado criado com Sucesso!");
                    }   else {
                        System.out.println("O Chamado não foi criado com Sucesso!");
                    }
                    break;

                case 2:
                    System.out.println("Editando Chamado...");
                    System.out.println("Digite o nome do chamado: ");
                    String nomeChamado;
                    nomeChamado = tc.next();
                    //Chamado editar = chamado.procuraChamado(chamado, nomeChamado);

                    System.out.println("O que você deseja fazer? ");
                    System.out.println("1-Editar");
                    System.out.println("2-Cancelar Chamado");
                    System.out.println("3-Voltar");
                    int edita;
                    edita = tc.nextInt();
                    if(edita==1){
                        //editar.editarChamado();
                        break;
                    }   else if(edita==2){
                        // editar.cancelarChamado();
                        break;
                    }
                    else break;

                case 3:
                    System.out.println("Mostrando Chamados");
                    //chamado.mostraChamados();
                    break;

                case 4:
                    break;
            }
        } while (operacao!=4);
    }
    public static void telaTecnico(Object pessoaLogada){

    }
    public static void telaGerente(Object pessoaLogada){
        int operacao=0;
        Gerente gerenteLogado = (Gerente) pessoaLogada;
        System.out.println("Gerente "+gerenteLogado.getNome()+" logado no sistema.");
    }

}
