package co.edu.uniquindio.analisisalgoritmos.service;

import co.edu.uniquindio.analisisalgoritmos.entidades.Formulario;

import java.util.List;

public interface FormularioServicio {

    Formulario guardarPreguntaFormulario(Formulario formulario)throws Exception;
    List<Object[]>promedioCadaPregunta()throws Exception;
}
