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
                String  name = rs.getString("NOME");
                int age  = rs.getInt("IDADE");
                String  codigo = rs.getString("CODIGO");
                double salary = rs.getDouble("SALARIO");
                System.out.println( "ID = " + id );
                System.out.println( "NOME = " + name );
                System.out.println( "IDADE = " + age );
                System.out.println( "ENDERECO = " + codigo );
                System.out.println( "SALARIO = " + salary );
                System.out.println();
                Pessoa p =new Pessoa(id,name,age,codigo,salary);
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
