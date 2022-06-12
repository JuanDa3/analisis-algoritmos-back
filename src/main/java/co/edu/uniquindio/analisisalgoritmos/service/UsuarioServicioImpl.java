package co.edu.uniquindio.analisisalgoritmos.service;

import co.edu.uniquindio.analisisalgoritmos.entidades.Usuario;
import co.edu.uniquindio.analisisalgoritmos.repositorio.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl  implements UsuarioServicio{


    private final UsuarioRepo usuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws Exception {
        usuarioRepo.save(usuario);
    }
}
