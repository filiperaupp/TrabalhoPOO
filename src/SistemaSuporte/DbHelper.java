package SistemaSuporte;

import JavaDb.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by filip on 27/09/2017.
 */
public class DbHelper {
    private Connection con;
    private Statement stmt;

    public DbHelper(){ // usamos um construtor para ao criamos um objeto ele ja obtenha uma conexao;
        con = new ConnectionFactory().getConnection() ;

    }

    public void executarSQL(String sql){ /// agora temos um método mais genérico par as insercoes..
        ///sendo necessario passar apenas a String de do sql..
        try { // bloco para controle de excecoes
            stmt = con.createStatement();
            stmt.executeUpdate(sql); /// execuçao do comando no BD
            stmt.close(); // Fechamento da comunicacao
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ":  " + e.getMessage() );
        }
        System.out.println("Sucesso!!!");
    }


    public ResultSet querySql(String sql){
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            return rs;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ":  " + e.getMessage() );
        }
        System.out.println("Sucesso");
        return null;
    }

}
