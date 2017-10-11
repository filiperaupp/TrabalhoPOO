package SistemaSuporte;

import java.util.Scanner;
public class Controller {
    static Scanner tc = new Scanner(System.in);

    public static void telaCliente(Object pessoaLogada){
        int operacao=0;
        Cliente clienteLogado = (Cliente) pessoaLogada;
        System.out.println("** Cliente "+clienteLogado.getNome()+" logado no sistema.");
        int numeroIdCliente = clienteLogado.getId();
        do {
            System.out.println("");
            System.out.println("-- Menu Cliente -- ");
            System.out.println("1- Abrir Chamado");
            System.out.println("2- Editar Chamado");
            System.out.println("3- Cancelar Chamado");
            System.out.println("4- Mostrar meus Chamados");
            System.out.println("5- Sair da conta");
            operacao = tc.nextInt();
            switch(operacao){
                case 1: {
                    clienteLogado.abrirChamado(numeroIdCliente);
                    break;
                }
                case 2: {
                    clienteLogado.editarChamado(numeroIdCliente);
                    break;
                }
                case 3: {
                    clienteLogado.cancelarChamado(numeroIdCliente);
                    break;
                }
                case 4: {
                    clienteLogado.mostrarTodosChamados(numeroIdCliente);
                    break;
                }
                default:{
                    System.out.println("Operação inexistente.");
                }
            }
        } while (operacao!=5);
    }
    public static void telaTecnico(Object pessoaLogada){
        int operacaoT = 0;
        do {
            Tecnico tecnicoLogado = (Tecnico) pessoaLogada;
            System.out.println("");
            System.out.println("** Técnico " + ((Tecnico) pessoaLogada).getNome() + " logado no sistema.**");
            System.out.println("-- Menu Técnico --");
            System.out.println("1- Mostrar Chamados Pendentes");
            System.out.println("2- Finalizar Chamado");
            System.out.println("3- Tarefas realizadas");
            System.out.println("4- Sair da conta");
            operacaoT = tc.nextInt();
            switch (operacaoT) {
                case 1: {
                    tecnicoLogado.chamadosPendentes(tecnicoLogado.getId());
                    break;
                }
                case 2: {
                    tecnicoLogado.finalizarChamado(tecnicoLogado.getId());
                    break;
                }
                case 3: {
                    tecnicoLogado.chamdosFinalizados(tecnicoLogado.getId());
                    break;
                }
                case 4: {
                    break;
                }
                default: {
                    System.out.println("Operação inexistente");
                }
            }
        }while (operacaoT!=4);
    }
    public static void telaGerente(Object pessoaLogada){
        int ope = 0;
        do {
            Gerente gerenteLogado = (Gerente) pessoaLogada;
            System.out.println("");
            System.out.println("**Gerente " + gerenteLogado.getNome() + " logado no sistema.**");
            System.out.println("-- Menu Gerente --");
            System.out.println("1- Cadastrar novo Gerente/Técnico/Cliente");
            System.out.println("2- Atualizar dados de Gerente/Téccnico/Cliente");
            System.out.println("3- Excluir Técnico/Cliente");
            System.out.println("4- Alterar Técnico responsável por um Chamado");
            System.out.println("5- Sair da conta");
            ope = tc.nextInt();
            switch (ope) {
                case 1: {
                    gerenteLogado.cadastrarUsuario();
                    break;
                }
                case 2: {
                    gerenteLogado.editarUsuario();
                    break;
                }
                case 3: {
                    gerenteLogado.excluir();
                    break;
                }
                case 4:{
                    gerenteLogado.alterarTenico();
                    break;
                }
                case 5:{
                    break;
                }
                default: {
                    System.out.println("Operação inválida.");
                }
            }
        } while (ope!=5);
    }

}