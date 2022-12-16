package view;

import java.util.Scanner;
import control.Sistema;

public class padraoView {

    static Scanner sc = new Scanner(System.in);
    static Sistema sistema = new Sistema();
    static AtendenteView atendenteview = new AtendenteView();

    public static void menutotal() {

        System.out.println("Por favor indentifique-se");
        System.out.println("Insira o seu login:");
        String login = sc.next();
        login += sc.nextLine();
        System.out.println();
        System.out.println("Agora por favor, insira a sua senha:");
        String senha = sc.nextLine();
        System.out.println("");

        if (sistema.autenticar(login, senha)) {
            if (sistema.tipoUsuario(login, senha) == models.Tipo.ATENDENTE) {
                atendenteview.boasVindasAtendente(login, senha);
            } else {
                sistema.boasVindasMedico(login, senha);
            }
        } else {
            while (!sistema.autenticar(login, senha)) {
                System.out.println("\nDados incorretos, por favor  indentifique-se novamente");
                System.out.println("Insira o seu login:");
                login = sc.nextLine();
                System.out.println("Agora por favor, insira a sua senha:");
                senha = sc.nextLine();
                System.out.println("");
            }
            if (sistema.tipoUsuario(login, senha) == models.Tipo.ATENDENTE) {
                sistema.boasVindasAtendente(login, senha);
            } else {
                sistema.boasVindasMedico(login, senha);
            }
        }

        System.out.println();
    }

    public static void padraoViewInit() {
        sistema.init();
    }

}