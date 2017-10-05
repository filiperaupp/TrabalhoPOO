package SistemaSuporte;

import java.util.Date;

public class Chamado {
    private int id;
    private int idCliente;
    private int idTecnico;
    private String descricao;
    private String dataFim;
    private String horaFim;
    private int prioridade; // 1- baixa 2- moderada, 3-alta, 4-urgente

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

    public boolean criaChamado(){
        //Cria chamado
        return true;
    };

    public Chamado procuraChamado(Chamado chamado,String nome){
        //procura chamado pelo nome
        return chamado;
    }

    public void editarChamado(){

    }

    public void cancelarChamado(){

    }
}
