package SistemaSuporte;

import java.util.ArrayList;
import java.util.Scanner;

public class Chamado {
    private int id;
    private int idCliente;
    private int idTecnico;
    private String descricao;
    private String dataFim;
    private String horaFim;
    private int prioridade; // 1- baixa 2- moderada, 3-alta, 4-urgente
    Scanner tc = new Scanner(System.in);
    ChamadosDao daoChamado = new ChamadosDao();
    public Chamado(){

    }
    // CONSTRUTOR PARA SALVAR
    public Chamado(int idCliente, int idTecnico, String descricao, String dataFim, String horaFim, int prioridade) {
        this.idCliente = idCliente;
        this.idTecnico = idTecnico;
        this.descricao = descricao;
        this.dataFim = dataFim;
        this.horaFim = horaFim;
        this.prioridade = prioridade;
    }
    // CONSTRUTOR PARA RETORNO/CONSULTA
    public Chamado(int id, int idCliente, int idTecnico, String descricao, String dataFim, String horaFim, int prioridade) {
        this.id = id;
        this.idCliente = idCliente;
        this.idTecnico = idTecnico;
        this.descricao = descricao;
        this.dataFim = dataFim;
        this.horaFim = horaFim;
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFinalizacao) {
        this.dataFim= dataFinalizacao;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFinalizacao) {
        this.horaFim= horaFinalizacao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int nivelPrioridade) {
        this.prioridade = nivelPrioridade;
    }

    public boolean criaChamado(int idOfCliente){
        ChamadosDao chamado = new ChamadosDao();
        Tecnico t = new Tecnico();
        System.out.println("Descrição do problema: ");
        this.descricao = tc.nextLine();
        System.out.println();
        System.out.println("Digite o número correspondente à prioridade:");
        System.out.println("(1) - Baixa | (2) - Moderada| (3) - Alta | (4) - Urgente ");
        this.prioridade = tc.nextInt();
        this.dataFim = null;
        this.horaFim = null;
        this.idCliente = idOfCliente;
        this.idTecnico = t.verificarChamadosPorTecnico();
        chamado.save(this);
        return true;
    }

    public ArrayList<Chamado> mostraChamados(int idCliente) {
        ArrayList<Chamado> todosChamados = new ArrayList<>();
        todosChamados = daoChamado.list(idCliente);
        for (Chamado chamado: todosChamados) {
            System.out.println("--> ID: "+chamado.getId());
            System.out.println("Descroção: "+chamado.getDescricao());
            System.out.println("Prioridade: "+chamado.getPrioridade());
        }
        return todosChamados;
    }

    public Chamado getByIdChamado(int id) {
        Chamado retornoChamado = new Chamado();
        ArrayList<Chamado> todosChamados = new ArrayList<>();
        for (Chamado chamado: todosChamados) {
            if (chamado.getId()==id) {
                retornoChamado = chamado;
            }
        }
        return retornoChamado;
    }

}
