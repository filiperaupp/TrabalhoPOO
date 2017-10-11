package SistemaSuporte;

import JavaDb.*;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by filip on 27/09/2017.
 */
public class PessoaDao {

    DbHelper sqlite;

    public PessoaDao() {
        sqlite = new DbHelper();
    }

    // SALVAR SALVAR SALVAR SALVAR SALVAR SALVAR SALVAR SALVAR SALVAR SALVAR SALVAR SALVAR SALVAR SALVAR SALVAR
    public void save(Object pessoa) {
        if (pessoa instanceof Cliente) {
            Cliente c = (Cliente) pessoa;
            if (pessoa != null) {
                String sql = "INSERT INTO PESSOAS (TIPO_USUARIO, NOME, TELEFONE, EMAIL, LOGIN, SENHA) " +
                        "VALUES (" + c.getTipoUsuario() + "," +
                        "'" + c.getNome() + "', " +
                        "'" + c.getTelefone() + "', " +
                        "'" + c.getEmail() + "', " +
                        "'" + c.getLogin() + "', " +
                        "'" + c.getSenha() + "' );";
                sqlite.executarSQL(sql);
            }
        } else if (pessoa instanceof Gerente) {
            Gerente g = (Gerente) pessoa;
            if (pessoa != null) {
                String sql = "INSERT INTO PESSOAS (TIPO_USUARIO, NOME, TELEFONE, EMAIL, LOGIN, SENHA) " +
                        "VALUES (" + g.getTipoUsuario() + "," +
                        " '" + g.getNome() + "'," +
                        " '" + g.getTelefone() + "'," +
                        " '" + g.getEmail() + "'," +
                        " '" + g.getLogin() + "'," +
                        " '" + g.getSenha() + "' );";
                sqlite.executarSQL(sql);
            }
        } else if (pessoa instanceof Tecnico) {
            Tecnico t = (Tecnico) pessoa;
            if (pessoa != null) {
                String sql = "INSERT INTO PESSOAS (TIPO_USUARIO, NOME, TELEFONE, EMAIL, LOGIN, SENHA) " +
                        "VALUES (" + t.getTipoUsuario() + "," +
                        "'" + t.getNome() + "', " +
                        "'" + t.getTelefone() + "', " +
                        "'" + t.getEmail() + "', " +
                        "'" + t.getLogin() + "', " +
                        "'" + t.getSenha() + "' );";
                sqlite.executarSQL(sql);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------
// DELETAR DELETAR DELETAR DELETAR DELETAR DELETAR DELETAR DELETAR DELETAR DELETAR DELETAR DELETAR DELETAR
    public void delete(Object pessoa) {
        if (pessoa instanceof Cliente) {
            Cliente c = (Cliente) pessoa;
            if (pessoa != null) {
                String sql = "DELETE FROM PESSOAS WHERE ID=" + c.getId() + ";";
                sqlite.executarSQL(sql);
            }
        } else if (pessoa instanceof Gerente) {
            Gerente g = (Gerente) pessoa;
            if (pessoa != null) {
                String sql = "DELETE FROM PESSOAS WHERE ID=" + g.getId();
                sqlite.executarSQL(sql);
            }
        } else if (pessoa instanceof Tecnico) {
            Tecnico t = (Tecnico) pessoa;
            if (pessoa != null) {
                String sql = "DELETE FROM PESSOAS WHERE ID=" + t.getId();
                sqlite.executarSQL(sql);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------
// EDITAR EDITAR EDITAR EDITAR EDITAR EDITAR EDITAR EDITAR EDITAR EDITAR EDITAR EDITAR EDITAR EDITAR EDITAR
    public void editar(Cliente clienteEdit) {
        String sql = "UPDATE PESSOAS " +
                "SET NOME = '" + clienteEdit.getNome() + "',  " +
                "TELEFONE = '" + clienteEdit.getTelefone() + "', " +
                "EMAIL = '" + clienteEdit.getEmail() + "', " +
                "LOGIN = '" + clienteEdit.getLogin() + "', " +
                "SENHA = '" + clienteEdit.getSenha() + "'  " +
                "WHERE ID=" + clienteEdit.getId() + ";";
        sqlite.executarSQL(sql);
    }

    public void editar(Tecnico tecnicoEdit) {
        String sql = "UPDATE PESSOAS " +
                "SET NOME   = '" + tecnicoEdit.getNome() + "',  " +
                "TELEFONE   = '" + tecnicoEdit.getTelefone() + "', " +
                "EMAIL      = '" + tecnicoEdit.getEmail() + "', " +
                "LOGIN      = '" + tecnicoEdit.getLogin() + "', " +
                "SENHA      = '" + tecnicoEdit.getSenha() + "'  " +
                "WHERE ID=" + tecnicoEdit.getId() + ";";
        sqlite.executarSQL(sql);
    }

    public void editar(Gerente gerenteEdit) {
        String sql = "UPDATE PESSOAS " +
                "SET NOME   = '" + gerenteEdit.getNome() + "',  " +
                "TELEFONE   = '" + gerenteEdit.getTelefone() + "', " +
                "EMAIL      = '" + gerenteEdit.getEmail() + "', " +
                "LOGIN      = '" + gerenteEdit.getLogin() + "', " +
                "SENHA      = '" + gerenteEdit.getSenha() + "'  " +
                "WHERE ID=" + gerenteEdit.getId() + ";";
        sqlite.executarSQL(sql);
    }

    //------------------------------------------------------------------------------------------------------
// PEGAR TODOS OS CLIENTES --PEGAR TODOS OS CLIENTES --PEGAR TODOS OS CLIENTES --PEGAR TODOS OS CLIENTES
    public ArrayList<Cliente> getAllCliente(int tipoDeUsuario) {
        String sql = "SELECT * FROM PESSOAS WHERE TIPO_USUARIO = " + tipoDeUsuario;
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        Cliente retornoCliente = new Cliente();
        ResultSet rs = sqlite.querySql(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("ID");
                int tipoUsuario = rs.getInt("TIPO_USUARIO");
                String nome = rs.getString("NOME");
                String telefone = rs.getString("TELEFONE");
                String email = rs.getString("EMAIL");
                String loginn = rs.getString("LOGIN");
                String senhaa = rs.getString("SENHA");
                retornoCliente = new Cliente(id, nome, telefone, email, loginn, senhaa);
                listaCliente.add(retornoCliente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaCliente;
    }

    //------------------------------------------------------------------------------------------------------
// PEGAR TODOS OS TECNICOS PEGAR TODOS OS TECNICOS PEGAR TODOS OS TECNICOS PEGAR TODOS OS TECNICOS
    public ArrayList<Tecnico> getAllTecnico(int tipoDeUsuario) {
        String sql = "SELECT * FROM PESSOAS WHERE TIPO_USUARIO = " + tipoDeUsuario;
        ArrayList<Tecnico> listaTecnico = new ArrayList<>();
        Tecnico retornoTecnico = new Tecnico();
        ResultSet rs = sqlite.querySql(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("ID");
                int tipoUsuario = rs.getInt("TIPO_USUARIO");
                String nome = rs.getString("NOME");
                String telefone = rs.getString("TELEFONE");
                String email = rs.getString("EMAIL");
                String loginn = rs.getString("LOGIN");
                String senhaa = rs.getString("SENHA");
                retornoTecnico = new Tecnico(id, nome, telefone, email, loginn, senhaa);
                listaTecnico.add(retornoTecnico);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (listaTecnico.isEmpty()) {
            return null;
        }
        else {
            return listaTecnico;
        }
    }

    //------------------------------------------------------------------------------------------------------
// PEGAR TODOS OS GERENTES PEGAR TODOS OS GERENTES PEGAR TODOS OS GERENTES PEGAR TODOS OS GERENTES
    public ArrayList<Gerente> getAllGerente(int tipoDeUsuario) {
        String sql = "SELECT * FROM PESSOAS WHERE TIPO_USUARIO = " + tipoDeUsuario;
        ArrayList<Gerente> listaGerente = new ArrayList<>();
        Gerente retornoGerente = new Gerente();
        ResultSet rs = sqlite.querySql(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("ID");
                int tipoUsuario = rs.getInt("TIPO_USUARIO");
                String nome = rs.getString("NOME");
                String telefone = rs.getString("TELEFONE");
                String email = rs.getString("EMAIL");
                String loginn = rs.getString("LOGIN");
                String senhaa = rs.getString("SENHA");
                retornoGerente = new Gerente(id, nome, telefone, email, loginn, senhaa);
                listaGerente.add(retornoGerente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaGerente;
    }

    //------------------------------------------------------------------------------------------------------
// VERIFICAR LOGIN VERIFICAR LOGIN VERIFICAR LOGIN VERIFICAR LOGIN VERIFICAR LOGIN VERIFICAR LOGIN VERIFICAR LOGIN
    public Object verificaLogin(String login, String senha) {
        String sql = "SELECT * FROM PESSOAS WHERE LOGIN == '" + login + "' AND SENHA == '" + senha + "'";
        ResultSet rs = sqlite.querySql(sql);
        Pessoa rp = new Pessoa();
        try {
            while (rs.next()) {
                int id = rs.getInt("ID");
                int tipoUsuario = rs.getInt("TIPO_USUARIO");
                String nome = rs.getString("NOME");
                String telefone = rs.getString("TELEFONE");
                String email = rs.getString("EMAIL");
                String loginn = rs.getString("LOGIN");
                String senhaa = rs.getString("SENHA");
                //System.out.println( "ID = " + id );
                //System.out.println( "TIPO USUÁRIO = " + tipoUsuario);
                //System.out.println( "NOME = " + nome );
                //System.out.println( "TELEFONE = " + telefone );
                //System.out.println( "EMAIL = " + email );
                //System.out.println( "LOGIN = " + loginn );
                //System.out.println( "SENHA = " + senhaa );
                //System.out.println();
                rp = new Pessoa(tipoUsuario, id, nome, telefone, email, login, senha);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (rp.getTipoUsuario() == 100) {
            Cliente cLogado = new Cliente(rp.getId(), rp.getNome(), rp.getTelefone(), rp.getEmail(), rp.getLogin(), rp.getSenha());
            return cLogado;
        } else if (rp.getTipoUsuario() == 200) {
            Tecnico tLogado = new Tecnico(rp.getId(), rp.getNome(), rp.getTelefone(), rp.getEmail(), rp.getLogin(), rp.getSenha());
            return tLogado;
        } else if (rp.getTipoUsuario() == 300) {
            Gerente gLogado = new Gerente(rp.getId(), rp.getNome(), rp.getTelefone(), rp.getEmail(), rp.getLogin(), rp.getSenha());
            return gLogado;
        } else {
            return rp;
        }
    }


    public ArrayList<Pessoa> list() {
        ArrayList<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM PESSOAS";
        ResultSet rs = sqlite.querySql(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("ID");
                int tipoUsuario = rs.getInt("TIPO_USUARIO");
                String nome = rs.getString("NOME");
                String telefone = rs.getString("TELEFONE");
                String email = rs.getString("EMAIL");
                String login = rs.getString("LOGIN");
                String senha = rs.getString("SENHA");
                System.out.println("ID = " + id);
                System.out.println("TIPO USUÁRIO = " + tipoUsuario);
                System.out.println("NOME = " + nome);
                System.out.println("TELEFONE = " + telefone);
                System.out.println("EMAIL = " + email);
                System.out.println("LOGIN = " + login);
                System.out.println("SENHA = " + senha);
                System.out.println();
                Pessoa p = new Pessoa(tipoUsuario, id, nome, telefone, email, login, senha);
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;

        }
    }

    //////////////// PROCURA TECNICO MENOS CHAMADOS ///////////////////////////////////////////
//    public int getTecMenos(){
//        int n = 0;
//        String sql = "SELECT CHAMADOS.ID_TECNICO AS TECNICO, COUNT(CHAMADOS.ID_TECNICO) AS QUANTIDADE FROM CHAMADOS, PESSOAS AS P WHERE P.TIPO_USUARIO=200 GROUP BY(TECNICO) ORDER BY (QUANTIDADE) ASC;";
//        ResultSet rs= sqlite.querySql(sql);
//        try {
//            while (rs.next()){
//                int id = rs.getInt("TECNICO");
//                return id;
//            }
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return -1;
//    }
}