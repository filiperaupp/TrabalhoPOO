package SistemaSuporte;

import java.util.ArrayList;
import java.util.Scanner;

public class Pessoa {
    private int tipoUsuario;
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String login;
    private String senha;
    public PessoaDao daoPessoa = new PessoaDao();


    public Pessoa(){

    }

    public Pessoa(int tipoUsuario, String nome, String telefone, String email, String login, String senha) {
        this.tipoUsuario = tipoUsuario;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public Pessoa(int tipoUsuario, int id, String nome, String telefone, String email, String login, String senha) {
        this.tipoUsuario = tipoUsuario;
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void cadastrar(int identificador){
        Scanner tc = new Scanner (System.in);
        System.out.println("Nome: ");
        this.nome = tc.next();
        System.out.println("Telefone: ");
        this.telefone = tc.next();
        System.out.println("Email: ");
        this.email = tc.next();
        System.out.println("Digite um login: ");
        this.login = tc.next();
        System.out.println("Senha: ");
        this.senha = tc.next();
        this.tipoUsuario = identificador;
    }

    public Tecnico getByNameTecnico(String nome, int tipoDeUsuario){
        ArrayList<Tecnico> listaTenico = daoPessoa.getAllTecnico(tipoDeUsuario);
        Tecnico tecnicoVazio = new Tecnico();
        for (Tecnico tecnico: listaTenico) {
            if (tecnico.getNome().equals(nome)) {
                return tecnico;
            }else {
                continue;
            }
        }
        return tecnicoVazio;
    }

    public Gerente getByNameGerente (String nome, int tipoDeUsuario){
        ArrayList<Gerente> listaGeretnes = daoPessoa.getAllGerente(tipoDeUsuario);
        Gerente gerenteVazio = new Gerente();
        for (Gerente gerente: listaGeretnes) {
            if (gerente.getNome().equals(nome)) {
                return gerente;
            }else {
                continue;
            }
        }
        return gerenteVazio;
    }

    public Cliente getByNameCliente (String nome, int tipoDeUsuario){
        ArrayList<Cliente> listaClientes = daoPessoa.getAllCliente(tipoDeUsuario);
        Cliente clienteVazio = new Cliente();
        for (Cliente cliente: listaClientes) {
            if (cliente.getNome().equals(nome)) {
                System.out.println();
                return cliente;
            }else {
                continue;
            }
        }
        return clienteVazio;
    }


}
