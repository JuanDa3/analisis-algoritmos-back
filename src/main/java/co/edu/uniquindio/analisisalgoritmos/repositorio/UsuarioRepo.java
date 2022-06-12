package co.edu.uniquindio.analisisalgoritmos.repositorio;

import co.edu.uniquindio.analisisalgoritmos.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

}
