package co.edu.uniquindio.analisisalgoritmos.service;

import co.edu.uniquindio.analisisalgoritmos.entidades.PreguntaTest;
import co.edu.uniquindio.analisisalgoritmos.entidades.Usuario;

import java.util.List;

public interface PreguntaTestServicio {

    PreguntaTest registrarPregunta(PreguntaTest preguntaTest) throws Exception;
    List<Object[]> promedioGlobalPregunta() throws Exception;
    List<Object[]> numeroRespuestasCorrectasPorPregunta() throws Exception;
    List<Object[]>numeroRespuestasIncorrectasPorPregunta() throws Exception;
    List<Object[]>ListadoMayorAMenor() throws Exception;
}
