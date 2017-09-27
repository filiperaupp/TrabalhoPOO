package JavaDb;

/**
 * Created by ramon on 19/10/16.
 */
public class Aluno {

    private long id;
    private String nome;
    private int idade;
    private String codigo;
    private Double salario;

    public Aluno(){

    }

    public Aluno(long id, String nome, int idade, String codigo, Double salario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.codigo = codigo;
        this.salario = salario;
    }
    public Aluno(String nome, int idade, String codigo, Double salario) {

        this.nome = nome;
        this.idade = idade;
        this.codigo = codigo;
        this.salario = salario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
