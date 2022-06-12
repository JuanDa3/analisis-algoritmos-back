package co.edu.uniquindio.analisisalgoritmos.service;

import co.edu.uniquindio.analisisalgoritmos.entidades.Formulario;
import co.edu.uniquindio.analisisalgoritmos.repositorio.FormularioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularioServicioImpl implements FormularioServicio{

    private final FormularioRepo formularioRepo;

    public FormularioServicioImpl(FormularioRepo formularioRepo) {
        this.formularioRepo = formularioRepo;
    }

    @Override
    public Formulario guardarPreguntaFormulario(Formulario formulario) throws Exception {
        return formularioRepo.save(formulario);
    }

    @Override
    public List<Object[]> promedioCadaPregunta() throws Exception {
        return formularioRepo.promedioRespuestasFormulario();
    }
}
