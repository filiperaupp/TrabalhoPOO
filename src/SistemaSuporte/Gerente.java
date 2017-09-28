package SistemaSuporte;

public class Gerente extends Pessoa {

    // manter gerentes,clientes e tecnicos
    // acesso a todas as informacoes
    // altera o tecnico responsável por algum

    private static int identificador=300;

    public void criaGerente(){

        this.setLogin("admin");
        this.setSenha("admin");
    }
}
