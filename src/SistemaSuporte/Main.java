package SistemaSuporte;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        String login,senha;
        PessoaDao daoPessoa = new PessoaDao();
        try {
            DbUtils dataBase = new DbUtils();
            //dataBase.criarDB();
            //Gerente admin = new Gerente(1,"admin","0000-0000","@yahoo.com","admin1","admin1");
            //daoPessoa.save(admin);
        }
        catch (Exception e) {
            System.out.println("Banco e Admin1 ja criado.");
        }
        int ope=0,opeLogin=0;
        int operacao=0;


        do {
            System.out.println("---Sistema de Chamados---");
            System.out.println("Login: ");
            login =  tc.next(); // Vai pesquisar no banco se já existe esse login e senha
            System.out.println("Senha: ");
            senha = tc.next();

            Pessoa retornoLogin = daoPessoa.verificaLogin(login,senha);

            opeLogin=retornoLogin.getTipoUsuario();
            switch (opeLogin) {
                case 100:{
                    Controller.telaCliente(retornoLogin);
                    break;
                }
                case 200:{
                    System.out.println("Técnico "+retornoLogin.getNome()+" logado no sistema.");
                    int operacaoT = 0;
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
                    break;
                }
                case 300:{
                    Controller.telaGerente(retornoLogin);
                    break;
                }
                default:
                    System.out.println("Login não existente");
            }
            if (retornoLogin.getTipoUsuario()==200){


            }


        } while (ope!=0);
    }
}
