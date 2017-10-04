package SistemaSuporte;

import JavaDb.*;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by filip on 27/09/2017.
 */
public class PessoaDao {

    DbHelper sqlite;
    public PessoaDao(){
        sqlite = new DbHelper();
    }

    public void save(Object pessoa){

        if (pessoa instanceof Cliente) {
            Cliente c = (Cliente) pessoa;
            if(pessoa!=null){
                String sql= "INSERT INTO PESSOAS (TIPO_USUARIO, ID, NOME, TELEFONE, EMAIL, LOGIN, SENHA) " +
                        "VALUES ('"+c.getTipoUsuario()+"'," +
                                 "'"+c.getId()+"'," +
                                 "'"+c.getNome()+"', " +
                                 ""+c.getTelefone()+", " +
                                 "'"+c.getEmail()+"', " +
                                 "'"+c.getLogin()+"', " +
                                 "'"+c.getSenha()+"' );";
                sqlite.executarSQL(sql);
            }
        }

        else if (pessoa instanceof Gerente) {
            Gerente g = (Gerente) pessoa;
            if(pessoa!=null){
                String sql= "INSERT INTO PESSOAS ( ID, TIPO_USUARIO, NOME, TELEFONE, EMAIL, LOGIN, SENHA) " +
                        "VALUES ('"+g.getId()+"'," +
                                " '"+g.getTipoUsuario()+"'," +
                                " '"+g.getNome()+"'," +
                                " '"+g.getTelefone()+"'," +
                                " '"+g.getEmail()+"'," +
                                " '"+g.getLogin()+"'," +
                                " '"+g.getSenha()+"' );";
                sqlite.executarSQL(sql);
            }
        }

        else if (pessoa instanceof Tecnico) {
            Tecnico t = (Tecnico) pessoa;
            if(pessoa!=null){
                String sql= "INSERT INTO PESSOAS (ID, TIPO_USUARIO, NOME, TELEFONE, EMAIL, LOGIN, SENHA) " +
                        "VALUES ('"+t.getId()+"'," +
                                 "'"+t.getTipoUsuario()+"'," +
                                 "'"+t.getNome()+"', " +
                                 ""+t.getTelefone()+", " +
                                 "'"+t.getEmail()+"', " +
                                 "'"+t.getLogin()+"', " +
                                 "'"+t.getSenha()+"' );";
                sqlite.executarSQL(sql);
            }
        }
    }


    public Object verificaLogin(String login, String senha){
        String sql = "SELECT * FROM PESSOAS WHERE LOGIN == '"+login+"' AND SENHA == '"+senha+"'";
        ResultSet rs= sqlite.querySql(sql);
        Pessoa rp = new Pessoa();
        try {
            while (rs.next()){
                int id= rs.getInt("ID");
                int tipoUsuario = rs.getInt("TIPO_USUARIO");
                String  nome = rs.getString("NOME");
                String  telefone = rs.getString("TELEFONE");
                String  email = rs.getString("EMAIL");
                String  loginn = rs.getString("LOGIN");
                String  senhaa = rs.getString("SENHA");
                //System.out.println( "ID = " + id );
                //System.out.println( "TIPO USUÁRIO = " + tipoUsuario);
                //System.out.println( "NOME = " + nome );
                //System.out.println( "TELEFONE = " + telefone );
                //System.out.println( "EMAIL = " + email );
                //System.out.println( "LOGIN = " + loginn );
                //System.out.println( "SENHA = " + senhaa );
                //System.out.println();
                rp = new Pessoa(tipoUsuario,id,nome,telefone,email,login,senha);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (rp.getTipoUsuario()==100) {
            Cliente cLogado = new Cliente(rp.getId(),rp.getNome(),rp.getTelefone(),rp.getEmail(),rp.getLogin(),rp.getSenha());
            return cLogado;
        }
        else if (rp.getTipoUsuario()==200) {
            Tecnico tLogado = new Tecnico(rp.getId(),rp.getNome(),rp.getTelefone(),rp.getEmail(),rp.getLogin(),rp.getSenha());
            return tLogado;
        }
        else if (rp.getTipoUsuario()==300) {
            Gerente gLogado = new Gerente(rp.getId(),rp.getNome(),rp.getTelefone(),rp.getEmail(),rp.getLogin(),rp.getSenha());
            return gLogado;
        }
        else{
            return rp;
        }
    }


    public ArrayList<Pessoa> list (){
        ArrayList<Pessoa> lista= new ArrayList<>();
        String sql= "SELECT * FROM PESSOAS";
        ResultSet rs= sqlite.querySql(sql);
        try {
            while (rs.next()){
                int id= rs.getInt("ID");
                int tipoUsuario = rs.getInt("TIPO_USUARIO");
                String  nome = rs.getString("NOME");
                String  telefone = rs.getString("TELEFONE");
                String  email = rs.getString("EMAIL");
                String  login = rs.getString("LOGIN");
                String  senha = rs.getString("SENHA");
                System.out.println( "ID = " + id );
                System.out.println( "TIPO USUÁRIO = " + tipoUsuario);
                System.out.println( "NOME = " + nome );
                System.out.println( "TELEFONE = " + telefone );
                System.out.println( "EMAIL = " + email );
                System.out.println( "LOGIN = " + login );
                System.out.println( "SENHA = " + senha );
                System.out.println();
                Pessoa p =new Pessoa(tipoUsuario,id,nome,telefone,email,login,senha);
                lista.add(p);
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
