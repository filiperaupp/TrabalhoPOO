package SistemaSuporte;

import JavaDb.*;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by filip on 27/09/2017.
 */
public class PessoaDao {

    JavaDb.DbHelper sqlite;
    public PessoaDao(){
        sqlite = new JavaDb.DbHelper();
    }

    public void save(Object pessoa){

        if (pessoa instanceof Cliente) {
            Cliente c = (Cliente) pessoa;
            if(pessoa!=null){
                String sql= "INSERT INTO PESSOAS (TIPO_USUARIO, ID, NOME, TELEFONE, EMAIL, LOGIN, SENHA) " +
                        "VALUES ('"+c.getTipoUsuario()+"','"+c.getId()+"','"+c.getNome()+"', "+c.getTelefone()+", '"+c.getEmail()+"', '"+c.getLogin()+"', '"+c.getSenha()+"' );";
                sqlite.executarSQL(sql);
            }
        }

        else if (pessoa instanceof Gerente) {
            Gerente g = (Gerente) pessoa;
            if(pessoa!=null){
                String sql= "INSERT INTO PESSOAS (TIPO_USUARIO, ID, NOME, TELEFONE, EMAIL, LOGIN, SENHA) " +
                        "VALUES ('"+g.getTipoUsuario()+"','"+g.getId()+"','"+g.getNome()+"', "+g.getTelefone()+", '"+g.getEmail()+"', '"+g.getLogin()+"', '"+g.getSenha()+"' );";
                sqlite.executarSQL(sql);
            }
        }

        else if (pessoa instanceof Tecnico) {
            Tecnico t = (Tecnico) pessoa;
            if(pessoa!=null){
                String sql= "INSERT INTO PESSOAS (TIPO_USUARIO, ID, NOME, TELEFONE, EMAIL, LOGIN, SENHA) " +
                        "VALUES ('"+t.getTipoUsuario()+"','"+t.getId()+"','"+t.getNome()+"', "+t.getTelefone()+", '"+t.getEmail()+"', '"+t.getLogin()+"', '"+t.getSenha()+"' );";
                sqlite.executarSQL(sql);
            }
        }
    }

    public ArrayList<Pessoa> list (){
        ArrayList<Pessoa> lista= new ArrayList<>();
        String sql= "SELECT * FROM PESSOAS";
        ResultSet rs= sqlite.querySql(sql);
        try {
            while (rs.next()){
                int tipoUsuario = rs.getInt("TIPO_USUARIO");
                int id= rs.getInt("ID");
                String  nome = rs.getString("NOME");
                String  telefone = rs.getString("TELEFONE");
                String  email = rs.getString("EMAIL");
                String  login = rs.getString("LOGIN");
                String  senha = rs.getString("SENHA");
                System.out.println( "TIPO USUÁRIO = " + tipoUsuario);
                System.out.println( "ID = " + id );
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
