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

//------ Mostra chamado PENDENTES dos Tecnicos -------------------------------------------------------------------------
    public void chamadosPendentes(int idOfTecnico){
        ArrayList<Chamado> meusChamados = daoChamado.listChamadosTecnico(idOfTecnico);
        if (meusChamados==null) {
            System.out.println("Sem chamados pendentes");
        }
        else {
            for (int i=4;i>=1;i--) {
                for (Chamado chamado : meusChamados) {
                    if (chamado.getPrioridade()==i)
                        System.out.println("--> ID: " + chamado.getId() + " |Descrição: " + chamado.getDescricao() + " |Prioridade: " + chamado.getPrioridade());
                }
            }
        }
    }
//--------------------------------------------------------------------------------------------------------------------
//------    Mostra chamado FINALIZADOS dos Tecnicos
    public void chamdosFinalizados(int idOfTecnico){
        ArrayList<Chamado> meusChamados = daoChamado.listChamadosFinalizados(idOfTecnico);
        if (meusChamados==null) {
            System.out.println("Sem chamados finalizados");
        }
        else {
            for (Chamado chamado : meusChamados) {
                System.out.println("--> ID: " + chamado.getId() + " |Descroção: " + chamado.getDescricao() + " |Prioridade: " + chamado.getPrioridade());
                System.out.println("Data finalização: " + chamado.getDataFim() + " |Hora finalização: " + chamado.getHoraFim());
            }
        }
    }
//------------------------------------------------------------------------------------------------------------
//----- Finalizar chamado ------------------------------------------------------------------------------------
    public void finalizarChamado(int idOfTenico){
        int escolhaChamado = 0;
        Chamado chamado = new Chamado();
        System.out.println("-- Digite o ID do chamdo que será finalizado: ");
        chamadosPendentes(idOfTenico);
        escolhaChamado = tc.nextInt();
        chamado = chamado.getByIdChamado(escolhaChamado);
        chamado.finalizar();
        daoChamado.finalize(chamado);

    }
//------------------------------------------------------------------------------------------------------------
//------- Encontra o tecnico com Menos chamados ---------------------------------------------------
    public int verificarMenosTarefas() {
        // fazer um for onde compara o id dos tecnicos com o registrado nos chamados
        // gravar o id do tecnico com menos chamados para atribuir a ele o novo chamado
        ArrayList<Chamado> listaChamados = daoChamado.getAllChamados();
        ArrayList<Tecnico> listaTenicos = daoPessoa.getAllTecnico(200);
        boolean firstNumber = false;
        int idTecnicoMenosChamados = 0;
        int numeroDeChamados = 0;
        PessoaDao tecnico = new PessoaDao();

        for (Tecnico esseTecnico : listaTenicos) {
            int contaChamadados = 0;
            for (Chamado esseChamado : listaChamados) {
                if (esseTecnico.getId() == esseChamado.getIdTecnico()) {
                    contaChamadados++;
                }
            }
            if (!firstNumber) {
                idTecnicoMenosChamados = esseTecnico.getId();
                numeroDeChamados = contaChamadados;
                firstNumber = true;
            } else {
                if (contaChamadados < numeroDeChamados) {
                    numeroDeChamados = contaChamadados;
                    idTecnicoMenosChamados = esseTecnico.getId();
                }
            }
        }
        return idTecnicoMenosChamados;
//        return tecnico.getTec(); // ta no PessoaDAO, vai pegar o tec com menos chamados e já adc na hora que o chamado for criado..
    }
//---------------------------------------------------------------------------------------------------------------------
    public void mostrarTodosTecnicos() {
        ArrayList<Tecnico> todosTecnicos = daoPessoa.getAllTecnico(200);
        for (Tecnico tecnico: todosTecnicos) {
            System.out.println("* ID: "+tecnico.getId()+"  Nome: "+tecnico.getNome());
        }
    }
}
