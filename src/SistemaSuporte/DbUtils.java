package SistemaSuporte;



public class DbUtils {
    DbHelper sqlite;

    public DbUtils() {
        sqlite = new DbHelper();
    }

    public void criarDB() {
        String sql = "CREATE TABLE PESSOAS" +
                "(ID                INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " TIPO_USUARIO      INTEGER NOT NULL, " +
                " NOME              TEXT    NOT NULL, " +
                " TELEFONE          TEXT    ,         " +
                " EMAIL             TEXT    ,         " +
                " LOGIN             TEXT    NOT NULL, " +
                " SENHA             TEXT    NOT NULL  " +
                ");"                                    +
                "CREATE TABLE CHAMADOS"+
                "(ID                INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " ID_CLIENTE        INTEGER NOT NULL,          " +
                " ID_TECNICO        INTEGER NOT NULL,          " +
                " DESCRICAO         TEXT,             " +
                " DATA_FIM          TEXT,             " +
                " HORA_FIM          TEXT,             " +
                " PRIORIDADE        TEXT," +
                "FOREIGN KEY (ID_CLIENTE) REFERENCES PESSOAS (ID)," +
                "FOREIGN KEY (ID_TECNICO) REFERENCES PESSOAS (ID));";

        sqlite.executarSQL(sql);
    }



    public void dropTable() {

        String sql = "DROP TABLE IF EXISTS PESSOAS";
        sqlite.executarSQL(sql);
    }
}
