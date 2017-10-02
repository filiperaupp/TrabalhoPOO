package JavaDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbUtils {
    DbHelper sqlite;

    public DbUtils(){
        sqlite = new DbHelper();
    }
    public  void criarDB()
    {
        String sql = "CREATE TABLE PESSOAS" +
                "(ID  INTEGER NOT NULL PRIMARY KEY," +
                " NOME           TEXT    NOT NULL, " +
                " IDADE            INT     NOT NULL, " +
                " CODIGO        CHAR(50), " +
                " SALARIO         REAL)";
        sqlite.executarSQL(sql);

    }

    public  void dropTable() {

        String sql = "DROP TABLE IF EXISTS ALUNO ";
        sqlite.executarSQL(sql);
    }
}
