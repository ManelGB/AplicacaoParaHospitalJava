
//Emanuel Gonçalves e Thalles Augusto

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import view.padraoView;
import models.Paciente;
import models.Anamnese;
import models.Usuario;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Paciente> pacientes = new ArrayList<>();
        List<Anamnese> anamneses = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();

        System.out.println();

        padraoView.padraoViewInit(pacientes, anamneses, usuarios);

        view.padraoView.menutotal(pacientes, anamneses, usuarios);
    }

}
