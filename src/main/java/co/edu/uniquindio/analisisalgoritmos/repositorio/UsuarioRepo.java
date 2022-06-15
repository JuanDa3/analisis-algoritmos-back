package co.edu.uniquindio.analisisalgoritmos.repositorio;

import co.edu.uniquindio.analisisalgoritmos.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    //metodo para hallar el coeficiente de correlacion
    @Query("select sum(p.calificacion) from PreguntaTest p group by (p.usuario.idUsuario)")
    List<Integer>hallarX();

    @Query("select f.calificacion from Formulario f where f.pregunta = 'pregunta1'")
    List<Integer>hallarY();
}
