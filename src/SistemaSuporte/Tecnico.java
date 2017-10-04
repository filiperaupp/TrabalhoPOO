package SistemaSuporte;

public class Tecnico extends Pessoa {
    //  ver as tarefas pendentes a ele
    // informar a data e hora que foi finalizado o chamado
    // mostrado ao técnico às tarefas a serem realizadas pela sua prioridade

    private static int identificador=200;

    public Tecnico(){

    }

    public Tecnico(int id, String nome, String telefone, String email, String login, String senha) {
        super(identificador, id, nome, telefone, email, login, senha);
    }

    public static int getIdentificador() {
        return identificador;
    }
}
