package SistemaSuporte;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by filip on 04/10/2017.
 */
public class ChamadosDao {

    DbHelper sqlite;
    public ChamadosDao() {sqlite = new DbHelper();}
// SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE SAVE
    public void save(Chamado chamado){
        String sql= "INSERT INTO CHAMADOS (ID_CLIENTE, ID_TECNICO, DESCRICAO, DATA_FIM, HORA_FIM, PRIORIDADE) " +
                "VALUES ("+chamado.getIdCliente()+",  " +
                ""+chamado.getIdTecnico()+", " +
                "'"+chamado.getDescricao()+"', " +
                "'"+chamado.getDataFim()+"', " +
                "'"+chamado.getHoraFim()+"', " +
                ""+chamado.getPrioridade()+");";
        sqlite.executarSQL(sql);
    }
// -------- Edição simples feita pelo cliente ------------------------------------------------------------------
    public void edit(Chamado chamadoEdit){
        String sql = "UPDATE CHAMADOS " +
                "SET DESCRICAO= '"+chamadoEdit.getDescricao()+"'," +
                "PRIORIDADE= '"+chamadoEdit.getPrioridade()+"' " +
                "WHERE ID=" +chamadoEdit.getId()+";";
        sqlite.executarSQL(sql);
    }
//------------------------------------------------------------------------------------------------------------
//----------Finalizar chamado --------------------------------------------------------------------------------
    public void finalize(Chamado chamadoUpdate){
        String sql = "UPDATE CHAMADOS " +
                "SET DATA_FIM= '"+chamadoUpdate.getDataFim()+"', " +
                "HORA_FIM= '"+chamadoUpdate.getHoraFim()+"' " +
                "WHERE ID= "+chamadoUpdate.getId()+";";
        sqlite.executarSQL(sql);
    }
//------------------------------------------------------------------------------------------------------------
// --------------- Altera o tecnico responsável --------------------------------------------------------------
    public void editResponsability(int idOfChamado, int idOfTecnico){
        String sql = "UPDATE CHAMADOS " +
                "SET ID_TECNICO= "+idOfTecnico+" " +
                "WHERE ID= "+idOfChamado+";";
        sqlite.executarSQL(sql);
    }
//------------------------------------------------------------------------------------------------------------
// DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE
    public void delete(Chamado chamado){
        String sql = "DELETE FROM CHAMADOS WHERE ID="+chamado.getId()+";";
        sqlite.executarSQL(sql);
    }
//------------------------------------------------------------------------------------------------------------
//--------- Chamados por Tecnico -----------------------------------------------------------------------------
    public ArrayList<Chamado> listChamadosTecnico(int idOfTecnico){
        ArrayList<Chamado> lista= new ArrayList<>();
        String sql= "SELECT * FROM CHAMADOS WHERE ID_TECNICO ="+idOfTecnico+" AND DATA_FIM = 'em andamento';";
        ResultSet rs= sqlite.querySql(sql);
        try {
            while (rs.next()){
                int id = rs.getInt("ID");
                int idCliente= rs.getInt("ID_CLIENTE");
                int idTecnico= rs.getInt("ID_TECNICO");
                String  descricao = rs.getString("DESCRICAO");
                String  horaFim = rs.getString("HORA_FIM");
                String  dataFim = rs.getString("DATA_FIM");
                int  prioridade = rs.getInt("PRIORIDADE");
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
//------------------------------------------------------------------------------------------------------------
//---- Mostrar chamados finalizados --------------------------------------------------------------------------
    public ArrayList<Chamado> listChamadosFinalizados(int idOfTecnico){
        ArrayList<Chamado> lista= new ArrayList<>();
        String sql= "SELECT * FROM CHAMADOS WHERE ID_TECNICO ="+idOfTecnico+" AND DATA_FIM IS NOT 'em andamento';";
        ResultSet rs= sqlite.querySql(sql);
        try {
            while (rs.next()){
                int id = rs.getInt("ID");
                int idTecnico= rs.getInt("ID_TECNICO");
                int idCliente= rs.getInt("ID_CLIENTE");
                String  descricao = rs.getString("DESCRICAO");
                String  horaFim = rs.getString("HORA_FIM");
                String  dataFim = rs.getString("DATA_FIM");
                int  prioridade = rs.getInt("PRIORIDADE");
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
//------------------------------------------------------------------------------------------------------------
//---------- Lista chamados por cliente ----------------------------------------------------------------------
    public ArrayList<Chamado> list (int idOfCliente){
        ArrayList<Chamado> lista= new ArrayList<>();
        String sql= "SELECT * FROM CHAMADOS WHERE ID_CLIENTE ="+idOfCliente+";";
        ResultSet rs= sqlite.querySql(sql);
        try {
            while (rs.next()){
                int id = rs.getInt("ID");
                int idCliente= rs.getInt("ID_CLIENTE");
                int idTecnico= rs.getInt("ID_TECNICO");
                String  descricao = rs.getString("DESCRICAO");
                String  dataFim = rs.getString("DATA_FIM");
                String  horaFim = rs.getString("HORA_FIM");
                int  prioridade = rs.getInt("PRIORIDADE");
//                System.out.println( "ID = " + id );
//                System.out.println( "ID CLIENTE = " + idCliente);
//                System.out.println( "ID TECNICO = " + idTecnico );
//                System.out.println( "DESCRICAO = " + descricao);
//                System.out.println( "DATA_FIM = " + dataFim );
//                System.out.println( "HORA_FIM = " + horaFim );
//                System.out.println( "PRIOrIDADE = " + prioridade );
//                System.out.println();
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
//------------------------------------------------------------------------------------------------------------
//------ Pega todos os chamados ------------------------------------------------------------------------------
    public ArrayList<Chamado> getAllChamados (){
        ArrayList<Chamado> lista= new ArrayList<>();
        String sql= "SELECT * FROM CHAMADOS";
        ResultSet rs= sqlite.querySql(sql);
        try {
            while (rs.next()){
                int id= rs.getInt("ID");
                int idCliente= rs.getInt("ID_CLIENTE");
                int idTecnico= rs.getInt("ID_TECNICO");
                String  dataFim = rs.getString("DATA_FIM");
                String  descricao = rs.getString("DESCRICAO");
                String  horaFim = rs.getString("HORA_FIM");
                int  prioridade = rs.getInt("PRIORIDADE");
                Chamado c = new Chamado(id,idCliente,idTecnico,descricao,dataFim,horaFim,prioridade);
                lista.add(c);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;


    }
}
