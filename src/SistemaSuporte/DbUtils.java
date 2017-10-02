package SistemaSuporte;

import JavaDb.DbHelper;

public class DbUtils {
    JavaDb.DbHelper sqlite;

    public DbUtils(){
        sqlite = new DbHelper();
    }
    public  void criarDB()
    {
        String sql = "CREATE TABLE PESSOAS" +
                "(ID                INTEGER NOT NULL PRIMARY KEY," +
                " TIPO_USUARIO      INTEGER NOT NULL, " +
                " NOME              TEXT    NOT NULL, " +
                " TELEFONE          TEXT    ,         " +
                " EMAIL             TEXT    ,         " +
                " LOGIN             TEXT    NOT NULL, " +
                " SENHA             TEXT    NOT NULL)";
        sqlite.executarSQL(sql);

    }


    public  void dropTable() {

        String sql = "DROP TABLE IF EXISTS PESSOAS";
        sqlite.executarSQL(sql);
    }
}
