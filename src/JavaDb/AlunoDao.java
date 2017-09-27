package JavaDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by ramon on 19/10/16.
 */
public class AlunoDao {

    DbHelper sqlite;
    public AlunoDao(){
        sqlite = new DbHelper();
    }

    public void save(Aluno a){

        if(a!=null){
            String sql= "INSERT INTO ALUNO (NOME,IDADE,CODIGO,SALARIO) " +
                    "VALUES ('"+a.getNome()+"', "+a.getIdade()+", '"+a.getCodigo()+"', " +a.getSalario()+" );";
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
