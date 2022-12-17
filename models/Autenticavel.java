package models;

import java.util.List;

interface Autenticavel {
    public boolean validaUsuario(String login, String senha, List<Usuario> usuario);
}
