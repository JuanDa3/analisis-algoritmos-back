package co.edu.uniquindio.analisisalgoritmos.service;

import co.edu.uniquindio.analisisalgoritmos.entidades.Usuario;
import co.edu.uniquindio.analisisalgoritmos.repositorio.UsuarioRepo;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl  implements UsuarioServicio{

    private final UsuarioRepo usuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {
        return usuarioRepo.save(usuario);
    }
}
