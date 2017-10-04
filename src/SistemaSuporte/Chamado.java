package SistemaSuporte;

import java.util.Date;

public class Chamado {
    private int id;
    private String descricao;
    private String dataFinalizacao;
    private String horaFinalizacao;
    private int nivelPrioridade; // 1- baixa 2- moderada, 3-alta, 4-urgente

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
