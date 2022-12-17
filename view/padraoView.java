package view;

import java.util.List;
import java.util.Scanner;
import control.Sistema;
import models.Anamnese;
import models.Paciente;
import models.Usuario;

public class padraoView {

    static Scanner sc = new Scanner(System.in);
    static Sistema sistema = new Sistema();
    static AtendenteView atendenteview = new AtendenteView();
    static MedicoView medicoView = new MedicoView();

    public static void menutotal(List<Paciente> pacientes, List<Anamnese> anamneses, List<Usuario> usuarios) {

        System.out.println("Por favor indentifique-se");
        System.out.println("Insira o seu login:");
        String login = sc.next();
        login += sc.nextLine();
        System.out.println();
        System.out.println("Agora por favor, insira a sua senha:");
        String senha = sc.nextLine();
        System.out.println("");

        if (sistema.autenticar(login, senha, usuarios)) {
            if (sistema.tipoUsuario(login, senha, usuarios) == models.Tipo.ATENDENTE) {
                atendenteview.boasVindasAtendente(login, senha, pacientes, anamneses, usuarios);
            } else {
                medicoView.boasVindasMedico(login, senha, usuarios, anamneses, pacientes);
            }
        } else {
            while (!sistema.autenticar(login, senha, usuarios)) {
                System.out.println("\nDados incorretos, por favor  indentifique-se novamente");
                System.out.println("Insira o seu login:");
                login = sc.nextLine();
                System.out.println("Agora por favor, insira a sua senha:");
                senha = sc.nextLine();
                System.out.println("");
            }
            if (sistema.tipoUsuario(login, senha, usuarios) == models.Tipo.ATENDENTE) {
                atendenteview.boasVindasAtendente(login, senha, pacientes, anamneses, usuarios);
            } else {
                medicoView.boasVindasMedico(login, senha, usuarios, anamneses, pacientes);
            }
        }

        System.out.println();
    }

    public static void padraoViewInit(List<Paciente> pacientes, List<Anamnese> anamneses, List<Usuario> usuarios) {
        sistema.init(pacientes, anamneses, usuarios);
    }

}