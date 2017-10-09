package SistemaSuporte;

/**
 * Created by filip on 25/09/2017.
 */
public class Cliente extends Pessoa {
    // abrir um chamado
    // define prioridade (Urgente,alta,moderada,baixa)
    // sistema deve atribuir as tarefas geralmente aos técnicos com menos chamados em aberto.
    // consulta,edita,cancela chamados
    // pode ver apenas os seus chamados//

    public Cliente() {

    }

    public Cliente(int id, String nome, String telefone, String email, String login, String senha) {
        super(identificador,id, nome, telefone, email, login, senha);
    }

    public Cliente(String nome, String telefone, String email, String login, String senha) {
        super(identificador, nome, telefone, email, login, senha);
    }

    private static int identificador=100;

    public int getIdentificador() {
        return identificador;
    }
}
