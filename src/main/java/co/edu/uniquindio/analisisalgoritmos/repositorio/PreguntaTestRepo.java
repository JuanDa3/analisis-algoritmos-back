package co.edu.uniquindio.analisisalgoritmos.repositorio;

import co.edu.uniquindio.analisisalgoritmos.entidades.PreguntaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaTestRepo extends JpaRepository<PreguntaTest, Integer> {

    @Query("select p.pregunta, AVG(p.calificacion) from PreguntaTest p group by(p.pregunta)")
    List<Object[]> promedioPreguntaTest();

    @Query("select p.pregunta, count(p.pregunta) from PreguntaTest p where p.calificacion = 1 group by(p.pregunta)")
    List<Object[]>respuestasCorrectas();

    @Query("select p.pregunta, count(p.pregunta) from PreguntaTest p where p.calificacion = 0 group by(p.pregunta)")
    List<Object[]>respuestasIncorrectas();

    @Query("select u.nombre, count (p.calificacion) from PreguntaTest p Join Usuario u on p.usuario.idUsuario = u.idUsuario where p.calificacion = 1 group by (u.nombre) order by p.calificacion")
    List<Object[]>listadoOrdenadoPorEstudiante();
}
