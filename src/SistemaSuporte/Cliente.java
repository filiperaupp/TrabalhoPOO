package SistemaSuporte;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by filip on 25/09/2017.
 */
public class Cliente extends Pessoa {
    // abrir um chamado
    // define prioridade (Urgente,alta,moderada,baixa)
    // sistema deve atribuir as tarefas geralmente aos técnicos com menos chamados em aberto.
    // consulta,edita,cancela chamados
    // pode ver apenas os seus chamados//
    private static int identificador=100;
    Scanner tc = new Scanner(System.in);
    ChamadosDao daoChamado = new ChamadosDao();

    public int getIdentificador() {
        return identificador;
    }

    public Cliente() {

    }

    public Cliente(int id, String nome, String telefone, String email, String login, String senha) {
        super(identificador,id, nome, telefone, email, login, senha);
    }

    public Cliente(String nome, String telefone, String email, String login, String senha) {
        super(identificador, nome, telefone, email, login, senha);
    }

    public void abrirChamado(int idCliente) {
        ArrayList<Tecnico> listaTecnicos = daoPessoa.getAllTecnico(200);
        if (listaTecnicos==null) {
            System.out.println("Não há tecnicos registrados.");
        }else {
            Tecnico tecnicoRegistro = new Tecnico();
            System.out.println("-- Criando Chamado");
            Chamado chamado = new Chamado();
            chamado.criaChamado(idCliente,tecnicoRegistro.verificarMenosTarefas());
            daoChamado.save(chamado);
            System.out.println("Chamado criado");
        }
    }

    public void editarChamado(int idCliente){
        int escolhaChamado=0;
        Chamado chamado = new Chamado();
        System.out.println("-- Editando Chamado");
        System.out.println("Digite o id do chamado que deseja editar:  ");
        chamado.mostraChamados(idCliente);
        escolhaChamado = tc.nextInt();
        chamado = chamado.getByIdChamado(escolhaChamado);
        chamado.editarChamado();
        daoChamado.edit(chamado);
        System.out.println("Chamado editado.");
    }

    public void mostrarTodosChamados(int idCliente){
        Chamado chamado = new Chamado();
        chamado.mostraChamados(idCliente);
    }

    public void cancelarChamado(int idCliente){
        int escolheChamado=0;
        Chamado chamado = new Chamado();
        System.out.println("-- Cancelando Chamado");
        System.out.println("Digite o id do chamado que deseja excluir:  ");
        chamado.mostraChamados(idCliente);
        escolheChamado = tc.nextInt();
        chamado = chamado.getByIdChamado(escolheChamado);
        daoChamado.delete(chamado);
    }


}
