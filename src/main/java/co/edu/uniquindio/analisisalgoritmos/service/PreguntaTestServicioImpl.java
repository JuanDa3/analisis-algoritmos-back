package co.edu.uniquindio.analisisalgoritmos.service;

import co.edu.uniquindio.analisisalgoritmos.entidades.PreguntaTest;
import co.edu.uniquindio.analisisalgoritmos.entidades.Usuario;
import co.edu.uniquindio.analisisalgoritmos.repositorio.PreguntaTestRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaTestServicioImpl implements PreguntaTestServicio{

    private final PreguntaTestRepo preguntaTestRepo;

    public PreguntaTestServicioImpl(PreguntaTestRepo preguntaTestRepo) {
        this.preguntaTestRepo = preguntaTestRepo;
    }


    @Override
    public PreguntaTest registrarPregunta(PreguntaTest preguntaTest) throws Exception {
        return preguntaTestRepo.save(preguntaTest);
    }

    @Override
    public List<Object[]> promedioGlobalPregunta() throws Exception {
        return preguntaTestRepo.promedioPreguntaTest();
    }

    @Override
    public List<Object[]> numeroRespuestasCorrectasPorPregunta() throws Exception {
        return preguntaTestRepo.respuestasCorrectas();
    }

    @Override
    public List<Object[]> numeroRespuestasIncorrectasPorPregunta() throws Exception {
        return preguntaTestRepo.respuestasIncorrectas();
    }

    @Override
    public List<Object[]> ListadoMayorAMenor() throws Exception {
        return preguntaTestRepo.listadoOrdenadoPorEstudiante();
    }
}
