package SistemaSuporte;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        String login,senha;
        PessoaDao daoPessoa = new PessoaDao();
        try {
            DbUtils dataBase = new DbUtils();
            dataBase.criarDB();
            Gerente admin = new Gerente("admin","0000-0000","@yahoo.com","admin1","admin1");
            daoPessoa.save(admin);
        }
        catch (Exception e) {
            System.out.println("Banco e Admin1 ja criado.");
        }
        int ope=1,opeLogin=0;
        int operacao=0;


        do {
            System.out.println("---Sistema de Chamados---");
            System.out.println("Login: ");
            login =  tc.next(); // Vai pesquisar no banco se já existe esse login e senha
            System.out.println("Senha: ");
            senha = tc.next();

            Object retornoLogin = daoPessoa.verificaLogin(login,senha);

            if(retornoLogin instanceof Cliente) {
                Controller.telaCliente(retornoLogin);
            }
            else if(retornoLogin instanceof Tecnico) {
                Controller.telaTecnico(retornoLogin);
            }
            else if (retornoLogin instanceof Gerente) {
                Controller.telaGerente(retornoLogin);
            }
            else {
                System.out.println("Login não existente");
            }
        } while (ope!=0);

    }
}
