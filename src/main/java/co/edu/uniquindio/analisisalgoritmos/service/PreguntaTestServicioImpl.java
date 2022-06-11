package co.edu.uniquindio.analisisalgoritmos.service;

import co.edu.uniquindio.analisisalgoritmos.entidades.PreguntaTest;
import co.edu.uniquindio.analisisalgoritmos.repositorio.PreguntaTestRepo;
import org.springframework.stereotype.Service;

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
}
