package SistemaSuporte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbHelper{
    private Connection con;
    private Statement stmt;

    public DbHelper(){ // usamos um construtor para ao criamos um objeto ele ja obtenha uma conexao;
        con = new ConnectionFactory().getConnection() ;

    }

    public void executarSQL(String sql){ /// agora temos um método mais genérico para as insercoes..
        ///sendo necessario passar apenas a String de do sql..
        try { // bloco para controle de excecoes
            stmt = con.createStatement();
            stmt.executeUpdate(sql); /// execuçao do comando no BD
            stmt.close(); // Fechamento da comunicacao
            System.out.println("Código SQL executado");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ":  " + e.getMessage() );
            System.out.println("Falha execução SQL");
        }
    }


    public ResultSet querySql(String sql){
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            return rs;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ":  " + e.getMessage() );
        }
        System.out.println("Sucesso querySQL");
        return null;
    }

}
