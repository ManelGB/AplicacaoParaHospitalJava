package control;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import models.Anamnese;
import models.Paciente;
import models.Sexo;
import models.Tipo;
import models.Usuario;
import models.Validacao;

public class Sistema {

    Scanner sc = new Scanner(System.in);

    Validacao validacao = new Validacao();

    List<Paciente> pacientes = new ArrayList<>();
    Paciente pacientesA[] = new Paciente[30];
    Anamnese anamneses[] = new Anamnese[30];
    Usuario usuarios[] = new Usuario[30];

    /*---------------------------------------------------- Sistema ----------------------------------------------------------*/

   

    public boolean autenticar(String login, String senha) {
        return validacao.validaUsuario(login, senha, usuarios);
    }

    public String getNome(String login, String senha) {
        for (int i = 0; i < usuarios.length; i++) {
            if (login.equals(usuarios[i].getNomeLogin()) && senha.equals(usuarios[i].getSenha())) {
                return usuarios[i].getNome();
            }
        }
        return null;
    }

    public void init() {

        for (int i = 0; i < 30; i++) {
            pacientesA[i] = new Paciente();
            usuarios[i] = new Usuario();
            anamneses[i] = new Anamnese();
        }

        pacientesA[0].setPaciente("Emanuel Gon", "Josefina da Silva", "52264982098", "20/02/2004", 'm',
                "Rua dos Bobo", "Ipatinga", "MG", 123);
        pacientesA[1].setPaciente("TATÁ Bacanudo", "Elis Condoisélle", "12345678912", "01/02/2004", 'o',
                "Avenida Brasil", "Timóteo", "MG", 159);
        pacientesA[2].setPaciente("Lidiane Morais", "Rosalina Condoisélle", "98745632198", "01/02/1960", 'f',
                "Avenida Macapá", "Santos", "SP", 147);
        pacientes.add(0, pacientesA[0]);
        pacientes.add(1, pacientesA[1]);
        pacientes.add(2, pacientesA[2]);

        usuarios[0].setUsuario("Emanuel", "Emanuel", "123456789", 'a');
        usuarios[1].setUsuario("Tatá", "Thalles", "987654321", 'm');
        usuarios[2].setUsuario("Lidiane Morais", "Rosalina Condoisélle", "123qwe", 'a');

        anamneses[0].setAnamnese("Emanuel", "dor de carregar o peso de ser um tremendo feioso", "Dor de cabeça",
                pacientes.get(0));
        anamneses[1].setAnamnese("TATÁ", "dor de carregar o peso de ser um tremendo gostoso", "Dor no olho",
                pacientes.get(1));
        anamneses[2].setAnamnese("Lidiane", "Programadora", "Dor lombar",
                pacientes.get(2));
    }

    public Tipo tipoUsuario(String login, String senha) {

        for (int i = 0; i < usuarios.length; i++) {
            if (login.equals(usuarios[i].getNomeLogin()) && senha.equals(usuarios[i].getSenha())) {
                Tipo tipo = usuarios[i].getTipo();
                return tipo;
            }
        }
        return null;
    }

    /*----------------------------------------------------------------------------------------------------------------------*/

    /*---------------------------------------------------- Atendente ----------------------------------------------------------*/

    public void boasVindasAtendente(String login, String senha) {
        System.out.println("Olá Atendente " + getNome(login, senha));
        menuPrincipalAtendente();
    }

    public int mostraMenuAtendente() {

        System.out.println("por favor escolha o que deseja fazer:");
        System.out.println(
                "1- Criar \n2- Listar\n3- Atualizar\n4- Deletar\n5- Trocar de usuário\n6- Sair");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public int mostraMenuAtualizarAtendente() {
        System.out.println("Selecione o que você deseja atualizar:");
        System.out.println("1- Paciente\n2- Usuário");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public int mostraMenuCriarAtendente() {
        System.out.println("Selecione o que você deseja criar:");
        System.out.println("1- Paciente\n2- Usuário");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public int mostraMenuExcluirAtendente() {
        System.out.println("Selecione o que você deseja excluir:");
        System.out.println("1- Paciente\n2- Usuário");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public int mostraMenuListarAtendente() {
        System.out.println("Selecione o que você deseja listar:");
        System.out.println("1- Paciente\n2- Usuário");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public void menuPrincipalAtendente() {
        int op = mostraMenuAtendente();
        while (op < 1 || op > 6) {
            System.out.println("Opção impossível");
            op = mostraMenuAtendente();
        }
        while (op != 6) {

            switch (op) {
                case 1:
                    int opç = mostraMenuCriarAtendente();
                    while (opç < 1 || opç > 2) {
                        System.out.println("Opção impossível");
                        opç = mostraMenuCriarAtendente();
                    }
                    switch (opç) {
                        case 1:
                            criarPaciente();
                            break;

                        case 2:
                            criarUsuario();
                            break;
                    }
                    break;

                case 2:
                    opç = mostraMenuListarAtendente();
                    while (opç < 1 || opç > 2) {
                        System.out.println("Opção impossível");
                        opç = mostraMenuListarAtendente();
                    }
                    switch (opç) {
                        case 1:
                            listarPacientes();
                            break;

                        case 2:
                            listarUsuarios();
                            break;
                    }
                    break;

                case 3:
                    opç = mostraMenuAtualizarAtendente();
                    while (opç < 1 || opç > 2) {
                        System.out.println("Opção impossível");
                        opç = mostraMenuAtualizarAtendente();
                    }
                    switch (opç) {
                        case 1:
                            atualizarPaciente();
                            break;

                        case 2:
                            atualizarUsuario();
                            break;
                    }
                    break;

                case 4:
                    opç = mostraMenuExcluirAtendente();
                    while (opç < 1 || opç > 2) {
                        System.out.println("Opção impossível");
                        opç = mostraMenuExcluirAtendente();
                    }
                    switch (opç) {
                        case 1:
                            String cpf;
                            System.out.println("Digite o CPF do paciente a ser excluído : ");
                            cpf = sc.next();
                            excluirPaciente(cpf);
                            break;

                        case 2:
                            excluirUsuario();
                            break;
                    }
                    break;
                case 5:
                    menutotal();
                    break;
            }
            op = mostraMenuAtendente();
            while (op < 1 || op > 6) {
                System.out.println("Opção impossível");
                op = mostraMenuAtendente();
            }
        }
        System.out.println("Até mais!");
        System.exit(0);
    }

    /*---------------------------------------------------- Paciente ----------------------------------------------------------*/

    public void atualizarPaciente() {

        System.out.println("Insira o CPF do usuário que você deseja mudar:");
        String CPF = sc.next();
        System.out.println();

        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i) != null && pacientes.get(i).getCPF() != null) {
                if (pacientes.get(i).getCPF().equals(CPF)) {
                    System.out.println("Insira o nome do paciente:");
                    String nome = sc.next();
                    nome += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira nome da Mãe do paciente:");
                    String nomeMae = sc.next();
                    nomeMae += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira a data de nascimento do cliente,utilizando do modelo" +
                            " dd/mm/aaaa ( é necessário colocar a barra )");
                    String datanasc = sc.next();
                    System.out.println();

                    System.out.println("Insira o sexo do paciente ( m - masculino, f - feminino, o -" +
                            " outro )");
                    char sexo = sc.next().toLowerCase().charAt(0);
                    System.out.println();

                    System.out.println("Insira o logradouro do paciente: ");
                    String logradouro = sc.next();
                    logradouro += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira a cidade do paciente: ");
                    String cidade = sc.next();
                    cidade += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira a sigla do estado do paciente: ");
                    String uf = sc.next();
                    System.out.println();

                    System.out.println("Insira o número da residência do paciente: ");
                    int numero = sc.nextInt();
                    System.out.println();

                    pacientes.get(i).setAtualizaPaciente(nome, nomeMae, datanasc, sexo, logradouro, cidade, uf, numero);
                }
            }
        }
    }

    public boolean criarPaciente() {

        String CPF = receberCPF();
        if (validacao.validaCPF(CPF)) {
            if (validacao.validaCPF(CPF, pacientes)) {
                inserirDadosPaciente(CPF);

            } else {
                while (!validacao.validaCPF(CPF)) {
                    System.out.println("\nErro com o CPF inserido, por favor tente novamente!");
                    CPF = receberCPF();
                }
                inserirDadosPaciente(CPF);
            }
        } else {
            while (!validacao.validaCPF(CPF)) {
                System.out.println("\nInsira somente números");
                CPF = receberCPF();
            }
            if (validacao.validaCPF(CPF, pacientes)) {
                inserirDadosPaciente(CPF);

            } else {
                while (!validacao.validaCPF(CPF, pacientes)) {
                    System.out.println("\nErro com o CPF inserido, por favor tente novamente!");
                    CPF = receberCPF();
                }
                inserirDadosPaciente(CPF);
            }
        }

        return true;
    }

    public boolean excluirPaciente(String CPF) {
        validacao.validaCPF(CPF);
        validacao.validaCPF(CPF, pacientes);
        int idExcluir = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i) != null && pacientes.get(i).getNome() != null) {
                if (pacientes.get(i).getCPF().equals(CPF)) {
                    idExcluir = i;
                }
            }
        }

        if (idExcluir < 0) {
            System.out.println("\nO CPF não foi encontrado! \n");
            return false;
        }

        for (int i = 0; i < anamneses.length; i++) {
            if (anamneses[i].getMotivo() != null) {

                if (anamneses[i].getPaciente().getCPF().equals(pacientes.get(idExcluir).getCPF())) {
                    System.out.println("Não é possível excluir este paciente, pois o mesmo tem anamneses");
                    return false;
                }
            }
        }
        pacientes.add(idExcluir, null);
        System.out.println("Paciente excluído\n");
        return true;
    }

    public void inserirDadosPaciente(String CPF) {

        System.out.println("Insira o nome do paciente:");
        String nome = sc.next();
        nome += sc.nextLine();
        System.out.println();

        System.out.println("Insira nome da Mãe do paciente:");
        String nomeMae = sc.next();
        nomeMae += sc.nextLine();
        System.out.println();

        System.out.println("Insira a data de nascimento do cliente,utilizando do modelo" +
                " dd/mm/aaaa ( é necessário colocar a barra )");
        String datanasc = sc.next();
        System.out.println();

        System.out.println("Insira o sexo do paciente ( m - masculino, f - feminino, o -" +
                " outro )");
        char sexo = sc.next().toLowerCase().charAt(0);
        System.out.println();

        System.out.println("Insira o logradouro do paciente: ");
        String logradouro = sc.next();
        logradouro += sc.nextLine();
        System.out.println();

        System.out.println("Insira a cidade do paciente: ");
        String cidade = sc.next();
        cidade += sc.nextLine();
        System.out.println();

        System.out.println("Insira a sigla do estado do paciente: ");
        String uf = sc.next();
        System.out.println();

        System.out.println("Insira o número da residência do paciente: ");
        int numero = sc.nextInt();
        System.out.println();

        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(pacientes.get(i).getCPF());
            Paciente newP = new Paciente();
            newP.setPaciente(nome, nomeMae, CPF, datanasc, sexo, logradouro, cidade, uf, numero);

            pacientes.add(newP);

            System.out.println("Paciente cadastrado com sucesso\n");
            break;
        }
    }

    public void listarPacientes() {
        String leftAlignFormat = "|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%n";

        System.out.format(
                "+---------------+---------------+---------------+---------------+---------------+-----------------------+---------------+%n");
        System.out.format(
                "|CNS            |Nome           |CPF            | Data de Nasc  |Sexo           | Nome da mãe           |%n");
        System.out.format(
                "+---------------+---------------+---------------+---------------+---------------+-----------------------+---------------+%n");
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i) != null && pacientes.get(i).getCPF() != null) {

                String nome = pacientes.get(i).getNome();
                String dtNasc = pacientes.get(i).getDtNasc();
                String nomeMae = pacientes.get(i).getNomeMae();
                String CPF = pacientes.get(i).getCPF();
                Sexo sexo = pacientes.get(i).getSexo();
                long CNS = pacientes.get(i).getCNS();

                if (nome != null) {

                    System.out.printf(leftAlignFormat, CNS, nome, CPF, dtNasc, sexo, nomeMae);
                    System.out.format(
                            "+---------------+---------------+---------------+---------------+---------------+-----------------------+---------------+%n");

                }

            }
        }
    }

    public String receberCPF() {
        System.out.println("Insira o CPF do paciente (Somente os números):");
        String CPF = sc.next();
        System.out.println();
        return CPF;
    }

    /*----------------------------------------------------------------------------------------------------------------------*/

    /*---------------------------------------------------- Usuário ----------------------------------------------------------*/

    public void atualizarUsuario() {
        System.out.println("Entre com o id do usuário que você deseja mudar");
        long id = sc.nextInt();
        System.out.println();

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getNome() != null) {
                if (usuarios[i].getId() == id) {
                    System.out.println("Insira o nome do Usuário:");
                    String nome = sc.next();
                    nome += sc.nextLine();

                    System.out.println("Insira o nome do Login do Usuário:");
                    String nomeLogin = sc.next();
                    nomeLogin += sc.nextLine();

                    System.out.println("Insira a senha do Usuário:");
                    String senha = sc.next();
                    senha += sc.nextLine();

                    System.out.println("Insira o tipo do Usuário ( a - Atendente , m - Médico ):");
                    char tipo = sc.next().toLowerCase().charAt(0);

                    usuarios[i].setAtualizarUsuario(nome, nomeLogin, senha, tipo);
                }
            }
        }
    }

    public void criarUsuario() {

        System.out.println("Insira o nome do Usuário:");
        String nome = sc.next();
        nome += sc.nextLine();

        System.out.println("Insira o nome do Login do Usuário:");
        String nomeLogin = sc.next();
        nomeLogin += sc.nextLine();

        System.out.println("Insira a senha do Usuário:");
        String senha = sc.next();
        senha += sc.nextLine();

        System.out.println("Insira o tipo do Usuário ( a - Atendente , m - Médico ):");
        char tipo = sc.next().toLowerCase().charAt(0);

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].getSenha() == null) {
                usuarios[i].setUsuario(nome, nomeLogin, senha, tipo);
                System.out.println("Usuário cadastrado com sucesso!");
                break;
            }
        }

    }

    public void excluirUsuario() {
        System.out.println("Digite o ID do usuario a ser excluído : ");
        int idUser = sc.nextInt();
        String senha;
        boolean validacao = false;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getNome() != null) {
                if (usuarios[i].getId() == idUser) {
                    System.out.println("Usuario encontrado! Digite a senha do usuario a ser excluído : ");
                    senha = sc.next();
                    senha += sc.nextLine();
                    System.out.println();
                    if (usuarios[i].getSenha().equals(senha)) {
                        usuarios[i] = null;
                        validacao = true;
                    }
                }
            }
        }
        if (validacao) {
            System.out.println("Usuario excluído\n");
        } else {
            System.out.println("Usuario não excluido\n");
        }
    }

    public void listarUsuarios() {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {

                long Id = usuarios[i].getId();
                String nome = usuarios[i].getNome();
                String nomeLogin = usuarios[i].getNomeLogin();
                Tipo tipo = usuarios[i].getTipo();

                if (nome != null) {

                    System.out.println(
                            "--------------------------------------------------------------------------------\n"
                                    + "ID : " + Id + "\n" + "nome : " + nome +
                                    "\n" + "Nome de login : " + nomeLogin + "\n" +
                                    "Tipo : " + tipo +
                                    "\n");
                }
            }
        }
    }

    /*----------------------------------------------------------------------------------------------------------------------*/

    /*----------------------------------------------------------------------------------------------------------------------*/

    /*---------------------------------------------------- Médico ----------------------------------------------------------*/

    public void boasVindasMedico(String login, String senha) {
        System.out.println("Olá Médico " + getNome(login, senha));
        menuPrincipalMedico();
    }

    public int mostraMenuMedico() {

        System.out.println("por favor escolha o que deseja fazer:");
        System.out.println(
                "1- Criar Anamnese \n2- Listar Anamnese\n3- Atualizar Anamnese\n4- Deletar Anamnese\n5- Trocar o usuário\n6- Sair");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public void menuPrincipalMedico() {
        int op = mostraMenuMedico();
        while (op < 1 || op > 6) {
            System.out.println("Opção impossível");
            op = mostraMenuMedico();
        }
        while (op != 6) {

            switch (op) {
                case 1:
                    criarAnamnese();
                    break;

                case 2:
                    listarAnamneses();
                    break;

                case 3:
                    atualizarAnamnse();
                    break;

                case 4:
                    System.out.println("Insira o id da Anamnese a ser excluída:");
                    int escolhaID = sc.nextInt();
                    excluirAnamnese(escolhaID);
                    break;
                case 5:
                    menutotal();
                    break;
            }
            op = mostraMenuMedico();
            while (op < 1 || op > 6) {
                System.out.println("Opção impossível");
                op = mostraMenuMedico();
            }
        }
        System.out.println("Até mais!");
        System.exit(0);
    }

    /*---------------------------------------------------- Anamnese ----------------------------------------------------------*/

    public void atualizarAnamnse() {
        System.out.println("Insira o ID da anamnese que será modificada:");
        int id = sc.nextInt();

        for (int i = 0; i < anamneses.length; i++) {
            if (anamneses[i] != null && anamneses[i].getMotivo() != null) {

                if (anamneses[i].getId() == id) {
                    System.out.println("Insira o motivo da anamnese:");
                    String motivo = sc.next();
                    motivo += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira o historico do paciente:");
                    String historico = sc.next();
                    historico += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira a queixa do paciente:");
                    String queixa = sc.next();
                    queixa += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira o CPF do paciente (apenas numeros) :");
                    String CPF = sc.next();
                    System.out.println();

                    Paciente pacienteAnamnese = encontrarPaciente(CPF);

                    anamneses[i].setAtualizarAnamnese(motivo, historico, queixa, pacienteAnamnese);
                }
            }
        }
    }

    public boolean criarAnamnese() {
        System.out.println("Insira o motivo da anamnese:");
        String motivo = sc.next();
        motivo += sc.nextLine();
        System.out.println();

        System.out.println("Insira o historico do paciente:");
        String historico = sc.next();
        historico += sc.nextLine();
        System.out.println();

        System.out.println("Insira a queixa do paciente:");
        String queixa = sc.next();
        queixa += sc.nextLine();
        System.out.println();

        System.out.println("Insira o CPF do paciente (apenas numeros) :");
        String CPF = sc.next();
        System.out.println();

        Paciente pacienteAnamnese = encontrarPaciente(CPF);
        for (int i = 0; i < anamneses.length; i++) {
            if (anamneses[i].getQueixa() == null) {
                anamneses[i].setAnamnese(motivo, historico, queixa, pacienteAnamnese);
                System.out.println("Anamnese criada com sucesso!\n");
                break;

            }
        }
        return true;
    }

    public void excluirAnamnese(long id) {
        boolean validacao = false;
        for (int i = 0; i < anamneses.length; i++) {
            if (anamneses[i].getId() == id) {
                anamneses[i] = null;
                validacao = true;
            }
        }
        if (validacao) {

            System.out.println("Anamnese excluída\n");
        } else {
            System.out.println("Anamnese não encontrada\n");
        }
    }

    public Paciente encontrarPaciente(String CPF) {
        String cpf = CPF;
        if (!validacao.validaCPF(cpf, pacientes)) {
            while (!validacao.validaCPF(cpf, pacientes)) {
                System.out.println("CPF não encontrado, por favor:");
                System.out.println("Insira o CPF do paciente (apenas numeros) :");
                cpf = sc.next();
                cpf += sc.nextLine();
                System.out.println();
            }
        }
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i) != null && pacientes.get(i).getNome() != null) {
                if (pacientes.get(i).getCPF().equals(cpf)) {
                    return pacientes.get(i);
                }
            }
        }
        return null;
    }

    public void listarAnamneses() {
        for (int i = 0; i < anamneses.length; i++) {
            if (anamneses[i] != null && anamneses[i].getMotivo() != null) {
                String motivo = anamneses[i].getMotivo();
                String historico = anamneses[i].getHistorico();
                String queixa = anamneses[i].getQueixa();
                String pacienteNome = anamneses[i].getPaciente().getNome();
                long id = anamneses[i].getId();

                System.out.println("--------------------------------------------------------------------------------\n"
                        + "Id : " + id + "\n" + "Nome do paciente : " + pacienteNome + "\n" + "Queixa : " + queixa
                        + "\n"
                        + "Motivo : " + motivo + "\n" + "Histórico : " + historico + "\n");
            }

        }
        System.out.println();
    }

    /*----------------------------------------------------------------------------------------------------------------------*/

}
