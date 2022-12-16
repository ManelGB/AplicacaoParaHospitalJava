
//Emanuel Gonçalves e Thalles Augusto

import java.util.Scanner;

import control.Sistema;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println();

        Sistema sistema = new Sistema();

        sistema.init();

        sistema.menutotal();
    }

    
}
