package SistemaSuporte;


import java.util.Scanner;

public class Gerente extends Pessoa {
    // manter gerentes,clientes e tecnicos
    // acesso a todas as informacoes
    // altera o tecnico responsável por algum
    Scanner tc = new Scanner(System.in);
    private static int identificador=300;
    PessoaDao daoPessoa = new PessoaDao();
    int salvarId = 0;

    public Gerente(){
    }

    public Gerente(int id, String nome, String telefone, String email, String login, String senha) {
        super(id, nome, telefone, email, login, senha);
    }

    public Gerente(String nome, String telefone, String email, String login, String senha) {
        super(identificador, nome, telefone, email, login, senha);
    }

//------------------------------------------------------------------------------------------------------
    public void cadastrarUsuario(){
        int ope;
        do {
            System.out.println("-- Qual tipo de usuário deseja criar? ");
            System.out.println("1- Novo Gerente");
            System.out.println("2- Novo Técnico");
            System.out.println("3- Novo Cliente");
            System.out.println("4- Voltar");
            ope = tc.nextInt();
            switch (ope) {
                case 1: {
                    Gerente novoGerente = new Gerente();
                    novoGerente.cadastrar(identificador);
                    daoPessoa.save(novoGerente);
                    System.out.println("Novo Gerente criado com sucesso");
                    break;
                }
                case 2: {
                    Tecnico novoTecnico = new Tecnico();
                    novoTecnico.cadastrar(novoTecnico.getIdentificador());
                    daoPessoa.save(novoTecnico);
                    System.out.println("Novo Ténico criado com sucesso");
                    break;
                }
                case 3: {
                    Cliente novoCliente = new Cliente();
                    novoCliente.cadastrar(novoCliente.getIdentificador());
                    daoPessoa.save(novoCliente);
                    System.out.println("Novo Cliente criado com sucesso");
                    break;
                }
                case 4: {
                    break;
                }
                default: {
                    System.out.println("Operação inexistente.");
                }
            }
            System.out.println("Deseja fazer novo cadastro? ");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            ope = tc.nextInt();
            if (ope==1) {

            }else {
                ope = 4;
            }
        }while (ope!=4);
    }
//------------------------------------------------------------------------------------------------------
    public void editarUsuario(){
        int ope;
        String nome;
        do {
            System.out.println("-- Qual tipo de usuário deseja editar? ");
            System.out.println("1- Gerente");
            System.out.println("2- Técnico");
            System.out.println("3- Cliente");
            System.out.println("4- Voltar");
            ope = tc.nextInt();
            switch (ope) {
                case 1: {
                    System.out.println("-- Nome do Gerente a ser editado:");
                    nome = tc.next();
                    Gerente gerenteEditar = new Gerente();
                    gerenteEditar = gerenteEditar.getByNameGerente(nome,300);
                    gerenteEditar.cadastrar(300);
                    daoPessoa.editar(gerenteEditar);
                    break;
                }
                case 2: {
                    System.out.println("-- Nome do Tecnico a ser editado:");
                    nome = tc.next();
                    Tecnico tecnicoEditar = new Tecnico();
                    tecnicoEditar = tecnicoEditar.getByNameTecnico(nome,200);
                    tecnicoEditar.cadastrar(200);
                    daoPessoa.editar(tecnicoEditar);
                    break;
                }
                case 3: {
                    System.out.println("-- Nome do cliente a ser editado:");
                    nome = tc.next();
                    Cliente clienteEditar = new Cliente();
                    clienteEditar = clienteEditar.getByNameCliente(nome,100);
                    clienteEditar.cadastrar(100);
                    daoPessoa.editar(clienteEditar);
                    break;
                }
                case 4: {
                    break;
                }
                default: {
                    System.out.println("Operação inexistente.");
                }
            }
            System.out.println("Deseja fazer nova edição? ");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            ope = tc.nextInt();
            if (ope==1) {

            }else {
                ope = 4;
            }
        }while (ope!=4);
    }
//------------------------------------------------------------------------------------------------------
    public void excluir(){
        int ope;
        String nome;
        do {
            System.out.println("-- Qual tipo de usuário deseja excluir? ");
            System.out.println("1- Cliente");
            System.out.println("2- Tecnico");
            System.out.println("3- Voltar");
            ope = tc.nextInt();
            switch (ope) {
                case 1: {
                    System.out.println("-- Nome do Cliente a ser excluído:");
                    nome = tc.next();
                    Cliente clienteExcluir = new Cliente();
                    clienteExcluir = clienteExcluir.getByNameCliente(nome,100);
                    daoPessoa.delete(clienteExcluir);
                    break;
                }
                case 2: {
                    System.out.println("-- Nome do Tecnico a ser excluído:");
                    nome = tc.next();
                    Tecnico tecnicoExcluir = new Tecnico();
                    tecnicoExcluir = tecnicoExcluir.getByNameTecnico(nome,200);
                    daoPessoa.delete(tecnicoExcluir);
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    System.out.println("Operação inexistente.");
                }
            }
            System.out.println("Deseja fazer nova exclusão? ");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            ope = tc.nextInt();
            if (ope==1) {

            }else {
                ope = 3;
            }
        }while (ope!=3);
    }
//-------------------------------------------------------------------------------------------------------
    public void alterarTenico(){
        Chamado chamado = new Chamado();
        Tecnico tecnico = new Tecnico();
        int escolhaChamado = 0;
        int escolheTecnico = 0;
        System.out.println("-- Digite o ID do chamado que deseja alterar a responsabilidade tecnica: ");
        chamado.mostraTodosChamados();
        escolhaChamado = tc.nextInt();
        System.out.println("-- Digite o ID do técnico que irá receber a tarefa: ");
        tecnico.mostrarTodosTecnicos();
        escolheTecnico = tc.nextInt();
        chamado.editarTecnico(escolhaChamado,escolheTecnico);
        System.out.println("Tecnico alterado");
    }
}
