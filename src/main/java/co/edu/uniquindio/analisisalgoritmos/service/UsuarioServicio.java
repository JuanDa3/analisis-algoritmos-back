package co.edu.uniquindio.analisisalgoritmos.service;

import co.edu.uniquindio.analisisalgoritmos.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    void registrarUsuario(Usuario usuario) throws Exception;

    List<Integer>hallarX() throws Exception;
    List<Integer>hallarY() throws Exception;
}
