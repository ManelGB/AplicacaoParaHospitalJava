package models;

import java.util.List;

public class Validacao {

    public boolean validaCPF(String CPF, List<Paciente> paciente) {
        if ((CPF != null) && CPF.length() == 11) {
            for (int i = 0; i < paciente.size(); i++) {
                if (CPF.equals(paciente.get(i).getCPF())) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }

    }

    public boolean validaCPF(String CPF) {
        String[] cpf = CPF.split("");
        try {
            for (int i = 0; i < cpf.length; i++) {
                Integer.parseInt(cpf[i]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validaUsuario(String login, String senha, Usuario[] usuario) {

        for (int i = 0; i < usuario.length; i++) {
            if (login.equals(usuario[i].getNomeLogin()) && senha.equals(usuario[i].getSenha())) {
                return true;
            }
        }
        return false;
    }

}