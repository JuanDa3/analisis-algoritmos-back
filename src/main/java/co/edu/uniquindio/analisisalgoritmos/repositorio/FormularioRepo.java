package co.edu.uniquindio.analisisalgoritmos.repositorio;

import co.edu.uniquindio.analisisalgoritmos.entidades.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepo extends JpaRepository<Formulario, Integer> {
}
