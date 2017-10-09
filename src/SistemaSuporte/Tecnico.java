package SistemaSuporte;

import java.util.ArrayList;
import java.util.Scanner;

public class Tecnico extends Pessoa {
    //  ver as tarefas pendentes a ele
    // informar a data e hora que foi finalizado o chamado
    // mostrado ao técnico às tarefas a serem realizadas pela sua prioridade

    private static int identificador=200;
    Scanner tc = new Scanner(System.in);
    PessoaDao daoPessoa = new PessoaDao();
    ChamadosDao daoChamado = new ChamadosDao();

    public Tecnico(){

    }

    public Tecnico(int id, String nome, String telefone, String email, String login, String senha) {
        super(identificador, id, nome, telefone, email, login, senha);
    }

    public Tecnico(String nome, String telefone, String email, String login, String senha) {
        super(identificador, nome, telefone, email, login, senha);
    }

    public int getIdentificador() {
        return identificador;
    }

    public void verificarChamadosPorTenico(){
        // fazer um for onde compra o id dos tenicos com o registrado nos chamados
        // gravar o id do tenico com menos chamados para atribuir a ele o novo chamado
        ArrayList<Chamado> listaChamados = daoChamado.getAllChamados();
        ArrayList<Tecnico> listaTenicos = daoPessoa.getAllTecnico(200);

    }
}
