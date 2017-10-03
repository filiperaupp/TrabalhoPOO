package SistemaSuporte;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        String login,senha;
        PessoaDao daoPessoa = new PessoaDao();


        try {
            DbUtils dataBase = new DbUtils();
            // dataBase.criarDB();
            //Gerente admin = new Gerente(1,"admin","0000-0000","@yahoo.com","admin1","admin1");
            //daoPessoa.save(admin);
        }
        catch (Exception e) {
            System.out.println("Banco e Admin1 ja criado.");
        }
        int ope=0;
        int operacao;


        do {
            System.out.println("---Sistema de Chamados---");
            System.out.println("Login: ");
            login =  tc.next(); // Vai pesquisar no banco se já existe esse login e senha
            System.out.println("Senha: ");
            senha = tc.next();
            Pessoa retornoLogin = daoPessoa.verificaLogin(login,senha);
            if(retornoLogin.getTipoUsuario()==300){
                // se o identificador for 100 quer dizer que é um cliente
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

            if (retornoLogin.getTipoUsuario()==200){
                int operacaoT = 0;
                System.out.println("Tecnico " + daoPessoa.getClass().getName()+ "está logado no sistema...");
                System.out.println("Escolha uma opção: ");
                System.out.println("1-Mostrar Chamados Pendentes");
                System.out.println("2-Finalizar Chamado");
                System.out.println("3-Mostrar por prioridade");
                System.out.println("4-Sair da conta");
                operacaoT = tc.nextInt();

                switch (operacaoT){

                    case 1:
                        System.out.println("Chamados Pendentes: ");

                }

            }


        } while (ope!=0);
    }
}
