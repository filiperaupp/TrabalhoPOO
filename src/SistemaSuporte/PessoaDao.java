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

    public void save(Pessoa pessoa){

        if(pessoa!=null){
            String sql= "INSERT INTO ALUNO (NOME,IDADE,CODIGO,SALARIO) " +
                    "VALUES ('"+pessoa.getTipoUsuario()+"','"+pessoa.getId()+"','"+pessoa.getNome()+"', "+pessoa.getTelefone()+", '"+pessoa.getEmail()+"', '"+pessoa.getLogin()+"', '"+pessoa.getSenha()+"' );";
            sqlite.executarSQL(sql);
        }

    }

    public ArrayList<Aluno> list (){
        ArrayList<Aluno> lista= new ArrayList<>();
        String sql= "SELECT * FROM ALUNO";
        ResultSet rs= sqlite.querySql(sql);
        try {
            while (rs.next()){
                long id = rs.getLong("ID");
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
                Aluno a =new Aluno(id,name,age,codigo,salary);
                lista.add(a);
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
