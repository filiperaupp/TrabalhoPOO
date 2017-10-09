package SistemaSuporte;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by filip on 04/10/2017.
 */
public class ChamadosDao {

    DbHelper sqlite;
    public ChamadosDao() {sqlite = new DbHelper();}

    public void save(Chamado chamado){
        String sql= "INSERT INTO PESSOAS (ID, ID_CLIENTE, ID_TECNICO, DESCRICAO, DATA_FIM, HORA_FIM, PRIORIDADE) " +
                "VALUES ('"+chamado.getId()+"'," +
                "'"+chamado.getIdCliente()+"'," +
                "'"+chamado.getIdTecnico()+"', " +
                ""+chamado.getDescricao()+", " +
                "'"+chamado.getDataFim()+"', " +
                "'"+chamado.getHoraFim()+"', " +
                "'"+chamado.getPrioridade()+"' );";
        sqlite.executarSQL(sql);
    }

    public ArrayList<Chamado> list (){
        ArrayList<Chamado> lista= new ArrayList<>();
        String sql= "SELECT * FROM CHAMADOS";
        ResultSet rs= sqlite.querySql(sql);
        try {
            while (rs.next()){
                int id= rs.getInt("ID");
                int idCliente= rs.getInt("ID_CLIENTE");
                int idTecnico= rs.getInt("ID_TECNICO");
                String  descricao = rs.getString("DESCRICAO");
                String  dataFim = rs.getString("DATA_FIM");
                String  horaFim = rs.getString("HORA_FIM");
                int  prioridade = rs.getInt("PRIORIDADE");
                System.out.println( "ID = " + id );
                System.out.println( "ID CLIENTE = " + idCliente);
                System.out.println( "ID TECNICO = " + idTecnico );
                System.out.println( "DESCRICAO = " + descricao);
                System.out.println( "DATA_FIM = " + dataFim );
                System.out.println( "HORA_FIM = " + horaFim );
                System.out.println( "PRIOrIDADE = " + prioridade );
                System.out.println();
                Chamado c = new Chamado(id,idCliente,idTecnico,descricao,dataFim,horaFim,prioridade);
                lista.add(c);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if(lista.isEmpty()) {
            return null;
        }else {
            return lista;

        }


    }
}