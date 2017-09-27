package SistemaSuporte;

import java.util.Scanner;

public class Pessoa {

    private String nome;
    private String telefone;
    private String email;
    private String login;
    private String senha;
    private int id=0;
    private int tipoUsuario;

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

    public void cadastrarPessoa(int identificador){
        Scanner tc = new Scanner (System.in);
        System.out.println("Cadastrando Usuário...");
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

        this.id++;

    }
}
