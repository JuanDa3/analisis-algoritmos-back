package co.edu.uniquindio.analisisalgoritmos.repositorio;

import co.edu.uniquindio.analisisalgoritmos.entidades.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormularioRepo extends JpaRepository<Formulario, Integer> {

    @Query("select f.pregunta, avg(f.calificacion) from Formulario f group by (f.pregunta)")
    List<Object[]> promedioRespuestasFormulario();
}
